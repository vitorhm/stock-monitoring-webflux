package br.com.stock.monitoring.application.handlers;

import br.com.stock.monitoring.application.models.StockPrice;
import br.com.stock.monitoring.application.ports.in.StockSubscription;
import br.com.stock.monitoring.application.ports.out.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class StockSubscriptionHandler implements StockSubscription {

    private final Stocks stocks;

    public StockSubscriptionHandler(@Autowired Stocks stocks) {
        this.stocks = stocks;
    }

    @Override
    public Flux<StockPrice> subscribe(String symbol) {

        return stocks.fetchStockPrices()
                .filter((stockPrice) -> stockPrice.symbol().equals(symbol));
    }
}
