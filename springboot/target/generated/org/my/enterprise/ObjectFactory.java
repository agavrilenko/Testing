
package org.my.enterprise;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.my.enterprise package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.my.enterprise
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleGetCriterion }
     * 
     */
    public SimpleGetCriterion createSimpleGetCriterion() {
        return new SimpleGetCriterion();
    }

    /**
     * Create an instance of {@link ComplexGetCriterion }
     * 
     */
    public ComplexGetCriterion createComplexGetCriterion() {
        return new ComplexGetCriterion();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link GetCriteria }
     * 
     */
    public GetCriteria createGetCriteria() {
        return new GetCriteria();
    }

    /**
     * Create an instance of {@link OutputBody }
     * 
     */
    public OutputBody createOutputBody() {
        return new OutputBody();
    }

    /**
     * Create an instance of {@link GetOperationRequest }
     * 
     */
    public GetOperationRequest createGetOperationRequest() {
        return new GetOperationRequest();
    }

    /**
     * Create an instance of {@link GetOperationResponse }
     * 
     */
    public GetOperationResponse createGetOperationResponse() {
        return new GetOperationResponse();
    }

}
