package com.gavrilol.tutorials.quickfix.beans;

import com.gavrilol.tutorials.quickfix.configuration.ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import quickfix.*;
import quickfix.field.BeginString;
import quickfix.field.HeartBtInt;
import quickfix.field.ResetSeqNumFlag;
import quickfix.fix44.Logon;

import java.io.FileNotFoundException;

@Configuration
public class FixClientConfiguration {

    @Autowired
    private ClientProperties properties;

    @Autowired
    KafkaTemplate<String, String> producerTemplate;

    @Bean
    public void createFixServer() throws ConfigError, InterruptedException, SessionNotFound, FileNotFoundException {
        Application application = new FixApplication(producerTemplate);
        SessionSettings settings = new SessionSettings(this.getClass().getClassLoader().getResourceAsStream("client.properties"));
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();

        Initiator initiator = new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
        initiator.start();
        while (!initiator.isLoggedOn()) {
            sendLogonRequest(initiator.getSessions().get(0));
            Thread.sleep(5000);
        }
    }

    private static void sendLogonRequest(SessionID sessionId)
            throws SessionNotFound {
        Logon logon = new Logon();
        Message.Header header = logon.getHeader();
        header.setField(new BeginString("FIX.4.4"));
        logon.set(new HeartBtInt(30));
        logon.set(new ResetSeqNumFlag(true));
        boolean sent = Session.sendToTarget(logon, sessionId);
        System.out.println("Logon Message Sent : " + sent);
    }

}


