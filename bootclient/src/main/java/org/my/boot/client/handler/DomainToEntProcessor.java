package org.my.boot.client.handler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.my.boot.client.model.Employee;
import org.my.enterprise.GetCriteria;
import org.my.enterprise.GetOperationRequest;
import org.my.enterprise.GetOperationResponse;
import org.my.enterprise.SimpleGetCriterion;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by trash on 03-Jan-17.
 */
@Component(value = "domainToEntProcessor")
public class DomainToEntProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Employee employee = (Employee) exchange.getIn().getBody();

        GetOperationResponse response = new GetOperationResponse();
        GetOperationRequest request = new GetOperationRequest();
        GetCriteria getCriteria = new GetCriteria();
        SimpleGetCriterion criterion = new SimpleGetCriterion();
        criterion.setName(employee.getPerson().getName());
        criterion.setNumber(employee.getPerson().getLastName());
        getCriteria.setSimpleGetCriterion(criterion);
        request.setBody(getCriteria);
        exchange.getIn().setBody(Arrays.asList(request));
    }
}
