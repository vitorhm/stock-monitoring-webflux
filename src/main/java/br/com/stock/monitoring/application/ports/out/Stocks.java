package br.com.stock.monitoring.application.ports.out;

import br.com.stock.monitoring.application.models.StockPrice;
import reactor.core.publisher.Flux;

public interface Stocks {
    Flux<StockPrice> fetchStockPrices();
}
