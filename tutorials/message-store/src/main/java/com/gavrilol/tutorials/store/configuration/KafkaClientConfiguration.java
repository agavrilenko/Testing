package com.gavrilol.tutorials.store.configuration;

import com.gavrilol.tutorials.store.beans.FixModel;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import quickfix.DataDictionary;
import quickfix.fix44.Quote;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Configuration
public class KafkaClientConfiguration {
    private static final Logger log = LoggerFactory.getLogger(KafkaClientConfiguration.class);

    @Autowired
    private ConcurrentMap<String, FixModel> quotes;

    @Bean
    public KafkaMessageListenerContainer<Integer, String> kafkaConsumer() {
        log.info("Started kafka with spring producer");
        ContainerProperties config = new ContainerProperties("fix");

        config.setMessageListener((MessageListener<Integer, String>) data -> {
            log.info("Arrived message " + data);
            Quote q = new Quote();
            try {
                q.fromString(data.value(), new DataDictionary("FIX44.xml"), false);
                FixModel model = new FixModel(q.getQuoteID().getValue(), q.getOfferPx().getValue(),
                        q.getOfferSize().getValue(), q.getSymbol().getValue());
                quotes.put(model.getSymbol(), model);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }


        });
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "MessageStore-group");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        DefaultKafkaConsumerFactory<Integer, String> cf = new DefaultKafkaConsumerFactory<Integer, String>(props);
        KafkaMessageListenerContainer<Integer, String> container = new KafkaMessageListenerContainer<>(cf, config);
//        container.start();
        return container;
    }

    public void setQuotes(ConcurrentMap<String, FixModel> quotes) {
        this.quotes = quotes;
    }
}
