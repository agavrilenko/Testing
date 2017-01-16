
package org.my.enterprise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for OutputBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputBody"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="employee" type="{http://org/my/enterprise}Employee"/&gt;
 *         &lt;element name="person" type="{http://org/my/enterprise}Person"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputBody", propOrder = {
    "employee",
    "person"
})
public class OutputBody
    implements Equals, ToString
{

    protected Employee employee;
    protected Person person;

    /**
     * Gets the value of the employee property.
     * 
     * @return
     *     possible object is
     *     {@link Employee }
     *     
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the value of the employee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employee }
     *     
     */
    public void setEmployee(Employee value) {
        this.employee = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            Employee theEmployee;
            theEmployee = this.getEmployee();
            strategy.appendField(locator, this, "employee", buffer, theEmployee);
        }
        {
            Person thePerson;
            thePerson = this.getPerson();
            strategy.appendField(locator, this, "person", buffer, thePerson);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OutputBody)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final OutputBody that = ((OutputBody) object);
        {
            Employee lhsEmployee;
            lhsEmployee = this.getEmployee();
            Employee rhsEmployee;
            rhsEmployee = that.getEmployee();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "employee", lhsEmployee), LocatorUtils.property(thatLocator, "employee", rhsEmployee), lhsEmployee, rhsEmployee)) {
                return false;
            }
        }
        {
            Person lhsPerson;
            lhsPerson = this.getPerson();
            Person rhsPerson;
            rhsPerson = that.getPerson();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "person", lhsPerson), LocatorUtils.property(thatLocator, "person", rhsPerson), lhsPerson, rhsPerson)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

}
