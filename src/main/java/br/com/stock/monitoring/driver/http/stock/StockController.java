package br.com.stock.monitoring.driver.http.stock;

import br.com.stock.monitoring.application.ports.in.StockSubscription;
import br.com.stock.monitoring.driver.http.stock.dto.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockSubscription stockSubscription;

    @Autowired
    public StockController(StockSubscription stockSubscription) {
        this.stockSubscription = stockSubscription;
    }

    @GetMapping("/{symbol}/prices")
    @ResponseBody
    public Flux<StockPriceDto> subscribe(@PathVariable String symbol) {
        return stockSubscription
                .subscribe(symbol)
                .map(StockPriceDto::from);
    }
}
