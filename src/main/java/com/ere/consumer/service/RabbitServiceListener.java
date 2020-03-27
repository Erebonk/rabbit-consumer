package com.ere.consumer.service;

import com.ere.consumer.domain.domain.InfoDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Rabbit service listener
 *
 * @author ilya
 * @version 1.3
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitServiceListener {

    @RabbitListener(queues = "document-queue-find")
    public String getDocProcess(String message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        log.info("Received from queue: " + message);
        return "Docs id: " + message;
    }

    @RabbitListener(queues = "document-queue-saved")
    public void savedDocsQueueListener(final ConcurrentLinkedQueue<InfoDocument> infoDocument) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        log.info("Received from queue: " + infoDocument);
        // todo: some action with docs
    }

}
