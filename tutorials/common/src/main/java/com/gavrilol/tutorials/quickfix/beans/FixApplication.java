package com.gavrilol.tutorials.quickfix.beans;

import org.springframework.kafka.core.KafkaTemplate;
import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fix44.MessageCracker;
import quickfix.fix44.News;
import quickfix.fix44.Quote;

public class FixApplication extends MessageCracker implements Application {
    private KafkaTemplate<String, String> producerTemplate;

    public FixApplication(KafkaTemplate<String, String> producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public FixApplication() {
    }

    ;

    @Override
    public void onCreate(SessionID sessionID) {

    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("Logon accepted for " + sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("Logout for " + sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println(String.format("Arrived message %s", message.toString()));
        String key = Integer.parseInt(((Quote) message).getSymbol().getValue()) % 2 + "";
        producerTemplate.sendDefault(key, message.toString());
    }

    @Override
    public void onMessage(News message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        super.onMessage(message, sessionID);
        System.out.println(String.format("Arrived message %s", message.toString()));
    }
}
