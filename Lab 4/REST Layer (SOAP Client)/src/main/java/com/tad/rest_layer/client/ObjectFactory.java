
package com.tad.rest_layer.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tad.node2.services package. 
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

    private final static QName _ChangeOrganization_QNAME = new QName("http://services.node2.tad.com/", "changeOrganization");
    private final static QName _ChangeOrganizationResponse_QNAME = new QName("http://services.node2.tad.com/", "changeOrganizationResponse");
    private final static QName _FireEmployee_QNAME = new QName("http://services.node2.tad.com/", "fireEmployee");
    private final static QName _FireEmployeeResponse_QNAME = new QName("http://services.node2.tad.com/", "fireEmployeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tad.node2.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeOrganization }
     * 
     */
    public ChangeOrganization createChangeOrganization() {
        return new ChangeOrganization();
    }

    /**
     * Create an instance of {@link ChangeOrganizationResponse }
     * 
     */
    public ChangeOrganizationResponse createChangeOrganizationResponse() {
        return new ChangeOrganizationResponse();
    }

    /**
     * Create an instance of {@link FireEmployee }
     * 
     */
    public FireEmployee createFireEmployee() {
        return new FireEmployee();
    }

    /**
     * Create an instance of {@link FireEmployeeResponse }
     * 
     */
    public FireEmployeeResponse createFireEmployeeResponse() {
        return new FireEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOrganization }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeOrganization }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.node2.tad.com/", name = "changeOrganization")
    public JAXBElement<ChangeOrganization> createChangeOrganization(ChangeOrganization value) {
        return new JAXBElement<ChangeOrganization>(_ChangeOrganization_QNAME, ChangeOrganization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOrganizationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeOrganizationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.node2.tad.com/", name = "changeOrganizationResponse")
    public JAXBElement<ChangeOrganizationResponse> createChangeOrganizationResponse(ChangeOrganizationResponse value) {
        return new JAXBElement<ChangeOrganizationResponse>(_ChangeOrganizationResponse_QNAME, ChangeOrganizationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FireEmployee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FireEmployee }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.node2.tad.com/", name = "fireEmployee")
    public JAXBElement<FireEmployee> createFireEmployee(FireEmployee value) {
        return new JAXBElement<FireEmployee>(_FireEmployee_QNAME, FireEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FireEmployeeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FireEmployeeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.node2.tad.com/", name = "fireEmployeeResponse")
    public JAXBElement<FireEmployeeResponse> createFireEmployeeResponse(FireEmployeeResponse value) {
        return new JAXBElement<FireEmployeeResponse>(_FireEmployeeResponse_QNAME, FireEmployeeResponse.class, null, value);
    }

}
