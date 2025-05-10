package br.com.stock.monitoring.application.models;

import br.com.stock.monitoring.application.commands.CreatePriceAlert;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record PriceAlert(
        UUID alertId,
        String symbol,
        AlertCondition condition,
        double targetPrice,
        Instant createdAt
) {
    public PriceAlert(double targetPrice, AlertCondition condition, String symbol) {
        this(UUID.randomUUID(), symbol, condition, targetPrice, Instant.now());
    }

    public static PriceAlert from(CreatePriceAlert createPriceAlert) {
        return new PriceAlert(
                createPriceAlert.targetPrice(),
                createPriceAlert.condition(),
                createPriceAlert.symbol()
        );
    }

    public PriceAlert {
        Objects.requireNonNull(symbol, "Symbol is required");
        Objects.requireNonNull(condition, "Alert condition is required");
        Objects.requireNonNull(alertId, "Alert id is required");
    }
}
