package br.com.stock.monitoring.application.ports.in;

import br.com.stock.monitoring.application.models.StockPrice;
import reactor.core.publisher.Flux;

public interface StockSubscription {

    Flux<StockPrice> subscribe(String symbol);
}
