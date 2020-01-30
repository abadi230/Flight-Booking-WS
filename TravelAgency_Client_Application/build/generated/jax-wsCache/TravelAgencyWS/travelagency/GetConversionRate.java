
package travelagency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetConversionRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetConversionRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromCurr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toCurr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetConversionRate", propOrder = {
    "fromCurr",
    "toCurr"
})
public class GetConversionRate {

    protected String fromCurr;
    protected String toCurr;

    /**
     * Gets the value of the fromCurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromCurr() {
        return fromCurr;
    }

    /**
     * Sets the value of the fromCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromCurr(String value) {
        this.fromCurr = value;
    }

    /**
     * Gets the value of the toCurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToCurr() {
        return toCurr;
    }

    /**
     * Sets the value of the toCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToCurr(String value) {
        this.toCurr = value;
    }

}
