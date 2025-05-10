package br.com.stock.monitoring.driver.http.alert.dto;

import br.com.stock.monitoring.application.commands.CreatePriceAlert;
import br.com.stock.monitoring.application.models.AlertCondition;

public record CreatePriceAlertDto(String symbol, double targetPrice, AlertCondition condition) {

    public CreatePriceAlert toCommand() {
        return new CreatePriceAlert(symbol, targetPrice, condition);
    }
}
