package br.com.stock.monitoring.application.ports.in;

import br.com.stock.monitoring.application.commands.CreatePriceAlert;
import br.com.stock.monitoring.application.models.PriceAlert;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AlertDefinition {

    Mono<PriceAlert> create(CreatePriceAlert createPriceAlert);

    Mono<Void> cancel(UUID id);
}
