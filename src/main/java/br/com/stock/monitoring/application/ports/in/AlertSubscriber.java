package br.com.stock.monitoring.application.ports.in;

import br.com.stock.monitoring.application.models.AlertNotification;
import reactor.core.publisher.Flux;

public interface AlertSubscriber {

    Flux<AlertNotification> subscribe();
}
