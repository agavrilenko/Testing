package org.my.boot.client.handler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.my.enterprise.GetOperationResponse;

/**
 * Created by trash on 13-Jan-17.
 */
public class SimpleResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        GetOperationResponse response = exchange.getIn().getBody(GetOperationResponse.class);
        exchange.getIn().setBody(response.getBody());
    }
}
