package br.com.stock.monitoring.application.models;

public record AlertNotification(
        String symbol,
        double triggeredPrice,
        AlertCondition condition,
        double targetPrice
) {
}
