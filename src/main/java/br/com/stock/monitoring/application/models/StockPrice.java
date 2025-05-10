package br.com.stock.monitoring.application.models;

public record StockPrice(
        String symbol,
        double price
) {
}
