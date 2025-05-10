package br.com.stock.monitoring.driver.http.alert.dto;

import br.com.stock.monitoring.application.models.AlertCondition;
import br.com.stock.monitoring.application.models.AlertNotification;

public record AlertNotificationDto(
        String symbol,
        double triggeredPrice,
        AlertCondition condition,
        double targetPrice
) {

    public static AlertNotificationDto from(AlertNotification alertNotification) {
        return new AlertNotificationDto(alertNotification.symbol(), alertNotification.triggeredPrice(), alertNotification.condition(), alertNotification.targetPrice());
    }
}
