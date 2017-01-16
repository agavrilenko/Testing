
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
 * <p>Java class for GetCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCriteria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="simpleGetCriterion" type="{http://org/my/enterprise}SimpleGetCriterion"/&gt;
 *         &lt;element name="complexGetCriterion" type="{http://org/my/enterprise}ComplexGetCriterion"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCriteria", propOrder = {
    "simpleGetCriterion",
    "complexGetCriterion"
})
public class GetCriteria
    implements Equals, ToString
{

    protected SimpleGetCriterion simpleGetCriterion;
    protected ComplexGetCriterion complexGetCriterion;

    /**
     * Gets the value of the simpleGetCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleGetCriterion }
     *     
     */
    public SimpleGetCriterion getSimpleGetCriterion() {
        return simpleGetCriterion;
    }

    /**
     * Sets the value of the simpleGetCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleGetCriterion }
     *     
     */
    public void setSimpleGetCriterion(SimpleGetCriterion value) {
        this.simpleGetCriterion = value;
    }

    /**
     * Gets the value of the complexGetCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexGetCriterion }
     *     
     */
    public ComplexGetCriterion getComplexGetCriterion() {
        return complexGetCriterion;
    }

    /**
     * Sets the value of the complexGetCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexGetCriterion }
     *     
     */
    public void setComplexGetCriterion(ComplexGetCriterion value) {
        this.complexGetCriterion = value;
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
            SimpleGetCriterion theSimpleGetCriterion;
            theSimpleGetCriterion = this.getSimpleGetCriterion();
            strategy.appendField(locator, this, "simpleGetCriterion", buffer, theSimpleGetCriterion);
        }
        {
            ComplexGetCriterion theComplexGetCriterion;
            theComplexGetCriterion = this.getComplexGetCriterion();
            strategy.appendField(locator, this, "complexGetCriterion", buffer, theComplexGetCriterion);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetCriteria)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetCriteria that = ((GetCriteria) object);
        {
            SimpleGetCriterion lhsSimpleGetCriterion;
            lhsSimpleGetCriterion = this.getSimpleGetCriterion();
            SimpleGetCriterion rhsSimpleGetCriterion;
            rhsSimpleGetCriterion = that.getSimpleGetCriterion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "simpleGetCriterion", lhsSimpleGetCriterion), LocatorUtils.property(thatLocator, "simpleGetCriterion", rhsSimpleGetCriterion), lhsSimpleGetCriterion, rhsSimpleGetCriterion)) {
                return false;
            }
        }
        {
            ComplexGetCriterion lhsComplexGetCriterion;
            lhsComplexGetCriterion = this.getComplexGetCriterion();
            ComplexGetCriterion rhsComplexGetCriterion;
            rhsComplexGetCriterion = that.getComplexGetCriterion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "complexGetCriterion", lhsComplexGetCriterion), LocatorUtils.property(thatLocator, "complexGetCriterion", rhsComplexGetCriterion), lhsComplexGetCriterion, rhsComplexGetCriterion)) {
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
