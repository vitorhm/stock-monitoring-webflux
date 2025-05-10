package br.com.stock.monitoring.driver.http.alert.dto;

import br.com.stock.monitoring.application.models.AlertCondition;
import br.com.stock.monitoring.application.models.PriceAlert;

import java.time.Instant;
import java.util.UUID;

public record PriceAlertDto(
        UUID id,
        String symbol,
        AlertCondition condition,
        double targetPrice,
        Instant createdAt
) {

    public static PriceAlertDto from(PriceAlert priceAlert) {
        return new PriceAlertDto(priceAlert.alertId(), priceAlert.symbol(), priceAlert.condition(), priceAlert.targetPrice(), priceAlert.createdAt());
    }
}
