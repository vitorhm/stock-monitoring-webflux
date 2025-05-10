package br.com.stock.monitoring.application.commands;

import br.com.stock.monitoring.application.models.AlertCondition;

public record CreatePriceAlert(String symbol, double targetPrice, AlertCondition condition) {
}
