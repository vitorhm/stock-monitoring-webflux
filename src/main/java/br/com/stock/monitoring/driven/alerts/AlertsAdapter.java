package br.com.stock.monitoring.driven.alerts;

import br.com.stock.monitoring.application.models.PriceAlert;
import br.com.stock.monitoring.application.ports.out.Alerts;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.UUID;

@Component
public class AlertsAdapter implements Alerts {

    private final HashMap<UUID, PriceAlert> storage = new HashMap<>();

    @Override
    public Mono<PriceAlert> create(PriceAlert priceAlert) {
        storage.put(priceAlert.alertId(), priceAlert);

        return Mono.just(priceAlert);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        storage.remove(id);
        return Mono.empty();
    }

    @Override
    public Mono<PriceAlert> get(UUID id) {
        return Mono.justOrEmpty(storage.get(id));
    }

    @Override
    public Flux<PriceAlert> getActiveAlerts() {
        return Flux.fromIterable(storage.values());
    }
}
