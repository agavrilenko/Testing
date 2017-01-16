package org.my.boot.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.my.enterprise.*;

/**
 * Created by trash on 13-Jan-17.
 */
public class SimpleServerProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        GetOperationRequest obj = exchange.getIn().getBody(GetOperationRequest.class);
        GetOperationResponse response = new GetOperationResponse();
        Employee employee = new Employee();
        SimpleGetCriterion criterion = obj.getBody().getSimpleGetCriterion();
        employee.setPosition(criterion.getNumber());
        Person person = new Person();
        person.setName(criterion.getName() + "Yo!!");
        person.setLastName(criterion.getName() + criterion.getNumber());
        employee.setPerson(person);
        OutputBody outputBody = new OutputBody();
        if (criterion.getName().toLowerCase().contains("employee")) {
            outputBody.setEmployee(employee);
        } else {
            outputBody.setPerson(person);
        }

        response.setBody(outputBody);
        exchange.getIn().setBody(response);
    }
}
