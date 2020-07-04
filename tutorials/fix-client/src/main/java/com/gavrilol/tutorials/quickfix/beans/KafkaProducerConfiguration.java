package com.gavrilol.tutorials.quickfix.beans;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {
    private KafkaTemplate<String, String> template;

    @Bean
    public KafkaTemplate<String, String> getProducerTemplate() {
        return template;
    }

    public KafkaProducerConfiguration() {
        createTemplate();
        template.setDefaultTopic("fix");
    }

    public void send(String key, String data) {
        template.sendDefault(key, data);
        template.flush();
    }

    private void createTemplate() {
        Map<String, Object> senderProps = senderProps();
        ProducerFactory<String, String> pf =
                new DefaultKafkaProducerFactory<>(senderProps);
        template = new KafkaTemplate<>(pf);
    }

    private Map<String, Object> senderProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }


}
