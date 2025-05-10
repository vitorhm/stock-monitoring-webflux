package br.com.stock.monitoring.application.ports.out;

import br.com.stock.monitoring.application.models.PriceAlert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface Alerts {

    Mono<PriceAlert> create(PriceAlert priceAlert);

    Mono<Void> delete(UUID id);

    Mono<PriceAlert> get(UUID id);

    Flux<PriceAlert> getActiveAlerts();
}
