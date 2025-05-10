package br.com.stock.monitoring.driven.stocks;

import br.com.stock.monitoring.application.models.StockPrice;
import br.com.stock.monitoring.application.ports.out.Stocks;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class StocksAdapter implements Stocks {

    @Override
    public Flux<StockPrice> fetchStockPrices() {
        return Flux.just(
                new StockPrice("AACG", 5.0),
                new StockPrice("AAME", 20.0),
                new StockPrice("ABVX", 20.0),
                new StockPrice("ABUS", 20.0),
                new StockPrice("ATRA", 20.0),
                new StockPrice("AUBN", 20.0),
                new StockPrice("ATMC", 20.0),
                new StockPrice("ATLN", 20.0),
                new StockPrice("ATEX", 20.0))
                .delaySequence(Duration.ofSeconds(1));
    }
}
