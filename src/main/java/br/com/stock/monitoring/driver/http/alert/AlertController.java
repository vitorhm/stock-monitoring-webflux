package br.com.stock.monitoring.driver.http.alert;

import br.com.stock.monitoring.application.ports.in.AlertDefinition;
import br.com.stock.monitoring.application.ports.in.AlertSubscriber;
import br.com.stock.monitoring.driver.http.alert.dto.AlertNotificationDto;
import br.com.stock.monitoring.driver.http.alert.dto.CreatePriceAlertDto;
import br.com.stock.monitoring.driver.http.alert.dto.PriceAlertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertDefinition alertDefinition;
    private final AlertSubscriber alertSubscriber;

    @Autowired
    public AlertController(AlertDefinition alertDefinition, AlertSubscriber alertSubscriber) {
        this.alertDefinition = alertDefinition;
        this.alertSubscriber = alertSubscriber;
    }

    @PostMapping
    public Mono<PriceAlertDto> create(@RequestBody CreatePriceAlertDto createPriceAlertDto) {
        var command = createPriceAlertDto.toCommand();

        return alertDefinition
                .create(command)
                .map(PriceAlertDto::from);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {

        return alertDefinition
                .cancel(UUID.fromString(id));
    }

    @GetMapping(value = "/notifications", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<AlertNotificationDto> notifications() {

        return alertSubscriber
                .subscribe()
                .map(AlertNotificationDto::from);
    }

}
