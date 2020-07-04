package com.gavrilol.tutorials.quickfix.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
@ConfigurationProperties(prefix = "client")
public class ClientProperties extends Properties {
    private String SenderCompID;
    private String BeginString;
    private String ConnectionType;
    private String ReconnectInterval;
    private String SocketAcceptPort;
    private String SocketAcceptAddress;
    private String FileLogPath;


    public String getSenderCompID() {
        return SenderCompID;
    }

    public void setSenderCompID(String senderCompID) {
        SenderCompID = senderCompID;
    }

    public String getBeginString() {
        return BeginString;
    }

    public void setBeginString(String beginString) {
        BeginString = beginString;
    }

    public String getConnectionType() {
        return ConnectionType;
    }

    public void setConnectionType(String connectionType) {
        ConnectionType = connectionType;
    }

    public String getReconnectInterval() {
        return ReconnectInterval;
    }

    public void setReconnectInterval(String reconnectInterval) {
        ReconnectInterval = reconnectInterval;
    }

    public String getSocketAcceptPort() {
        return SocketAcceptPort;
    }

    public void setSocketAcceptPort(String socketAcceptPort) {
        SocketAcceptPort = socketAcceptPort;
    }

    public String getSocketAcceptAddress() {
        return SocketAcceptAddress;
    }

    public void setSocketAcceptAddress(String socketAcceptAddress) {
        SocketAcceptAddress = socketAcceptAddress;
    }

    public String getFileLogPath() {
        return FileLogPath;
    }

    public void setFileLogPath(String fileLogPath) {
        FileLogPath = fileLogPath;
    }

}