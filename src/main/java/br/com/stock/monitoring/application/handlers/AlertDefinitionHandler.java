package br.com.stock.monitoring.application.handlers;

import br.com.stock.monitoring.application.commands.CreatePriceAlert;
import br.com.stock.monitoring.application.models.PriceAlert;
import br.com.stock.monitoring.application.ports.in.AlertDefinition;
import br.com.stock.monitoring.application.ports.out.Alerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class AlertDefinitionHandler implements AlertDefinition {

    private final Alerts alerts;

    public AlertDefinitionHandler(@Autowired Alerts alerts) {
        this.alerts = alerts;
    }

    @Override
    public Mono<PriceAlert> create(CreatePriceAlert createPriceAlert) {
        PriceAlert priceAlert = PriceAlert.from(createPriceAlert);

        return alerts.create(priceAlert);
    }

    @Override
    public Mono<Void> cancel(UUID id) {

        return alerts.delete(id);
    }
}
