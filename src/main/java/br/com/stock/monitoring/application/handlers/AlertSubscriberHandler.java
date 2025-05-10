package br.com.stock.monitoring.application.handlers;

import br.com.stock.monitoring.application.models.AlertNotification;
import br.com.stock.monitoring.application.ports.in.AlertSubscriber;
import br.com.stock.monitoring.application.ports.out.Alerts;
import br.com.stock.monitoring.application.ports.out.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class AlertSubscriberHandler implements AlertSubscriber {

    private final Alerts alerts;
    private final Stocks stocks;

    @Autowired
    public AlertSubscriberHandler(Alerts alerts, Stocks stocks) {
        this.alerts = alerts;
        this.stocks = stocks;
    }

    @Override
    public Flux<AlertNotification> subscribe() {

        var stockPrices = stocks.fetchStockPrices();
        var activeAlerts = alerts.getActiveAlerts();

        return Flux.zip(stockPrices, activeAlerts)
                .filter((p) -> p.getT1().symbol().equals(p.getT2().symbol()))
                .filter((p) -> {
                    var stockPrice = p.getT1();
                    var alert = p.getT2();

                    return switch (alert.condition()) {
                        case GREATER_THAN -> stockPrice.price() > alert.targetPrice();
                        case LESS_THAN -> stockPrice.price() < alert.targetPrice();
                        case EQUAL_TO -> stockPrice.price() == alert.targetPrice();
                    };
                })
                .map((t) -> new AlertNotification(t.getT1().symbol(), t.getT1().price(), t.getT2().condition(), t.getT2().targetPrice()));
    }
}
