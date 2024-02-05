package org.berg.portfolio.server.scheduled;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.berg.portfolio.client.AsyncRestClientService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuartzScheduledTasks {

    private final AsyncRestClientService clientService;

    @Scheduled(initialDelay = 60000L, fixedRate = 10000L)
    public void AfterFirstMinuteEveryTenSeconds() {
        log.info("Adding Random Person");
        log.info(clientService.addRando().toString());
    }

}
