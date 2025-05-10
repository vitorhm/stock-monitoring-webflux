package br.com.stock.monitoring.driver.http.stock.dto;

import br.com.stock.monitoring.application.models.StockPrice;

public record StockPriceDto(String symbol, double price) {

    public static StockPriceDto from(StockPrice model) {
        return new StockPriceDto(model.symbol(), model.price());
    }
}
