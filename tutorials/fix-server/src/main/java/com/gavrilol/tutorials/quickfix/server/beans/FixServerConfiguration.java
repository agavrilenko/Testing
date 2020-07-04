package com.gavrilol.tutorials.quickfix.server.beans;

import com.gavrilol.tutorials.quickfix.server.configuration.ServerProperties;
import com.gavrilol.tutorials.quickfix.beans.FixApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;
import quickfix.field.BeginString;
import quickfix.field.HeartBtInt;
import quickfix.field.ResetSeqNumFlag;
import quickfix.fix44.Logon;

import java.io.FileNotFoundException;

@Configuration
public class FixServerConfiguration {


    @Autowired
    private ServerProperties properties;

    @Bean
    public void createFixServer() throws ConfigError, InterruptedException, SessionNotFound, FileNotFoundException {
        Application application = new FixApplication();
        SessionSettings settings = new SessionSettings(this.getClass().getClassLoader().getResourceAsStream("server.properties"));
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor(application, storeFactory, settings, logFactory, messageFactory);
        acceptor.start();
        Session session = Session.lookupSession(acceptor.getSessions().get(0));
        session.isLoggedOn();
        FixMessageGenerator generator = new FixMessageGenerator(session);
        generator.generateAndSend();
//        while (acceptor.isLoggedOn()) {
//            Thread.sleep(10000);
//        }
//        acceptor.stop();
//        while (true) {
//            Thread.sleep(5000);
//        }


    }

    private static void sendLogonRequest(SessionID sessionId)
            throws SessionNotFound {
        Logon logon = new Logon();
        Message.Header header = logon.getHeader();
        header.setField(new BeginString("FIX.4.2"));
        logon.set(new HeartBtInt(30));
        logon.set(new ResetSeqNumFlag(true));
        boolean sent = Session.sendToTarget(logon, sessionId);
        System.out.println("Logon Message Sent : " + sent);
    }
}
