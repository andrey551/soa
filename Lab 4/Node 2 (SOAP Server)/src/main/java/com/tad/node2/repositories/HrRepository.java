package com.tad.node2.repositories;


import org.springframework.stereotype.Component;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPConnection;
import jakarta.xml.soap.SOAPConnectionFactory;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.soap.SOAPPart;

@Component
public class HrRepository {
	public void fireEmployee(Long id) {
		SOAPConnectionFactory soapConnectionFactory;
		try {
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://localhost:8081/fire";
			SOAPMessage soapMessage = createFireRequest(id);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			soapConnection.close();
		} catch (UnsupportedOperationException | SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public void changeOrg(Long id, Long from_id, Long to_id) {
		SOAPConnectionFactory soapConnectionFactory;
		try {
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://localhost:8081/change";
			SOAPMessage soapMessage = createChangeRequest(id, from_id, to_id);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			soapConnection.close();
		} catch (UnsupportedOperationException | SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static SOAPMessage createFireRequest(Long id) {
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	        SOAPEnvelope envelope = soapPart.getEnvelope();
        
			envelope.addNamespaceDeclaration("HrServiceService", "http://services.node2.tad.com/");
			
			SOAPBody soapBody = envelope.getBody();
	        SOAPElement bodyElement = (SOAPElement) soapBody.addChildElement("fireEmployee", "HrServiceService");
	        SOAPElement idElement = bodyElement.addChildElement("id", "HrServiceService");
	        idElement.addTextNode(id.toString());
	        
	        soapMessage.saveChanges();
	        
	        return soapMessage;
	        
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;   
	}
	
	private static SOAPMessage createChangeRequest(Long id, Long from_id, Long to_id) {
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	        SOAPEnvelope envelope = soapPart.getEnvelope();
        
			envelope.addNamespaceDeclaration("HrServiceService", "http://services.node2.tad.com/");
			
			SOAPBody soapBody = envelope.getBody();
			System.out.println("Body: " + soapBody.toString());
	        SOAPElement bodyElement = soapBody.addChildElement("changeOrganization", "HrServiceService");
	        SOAPElement idElement = bodyElement.addChildElement("id", "HrServiceService");
	        idElement.addTextNode(id.toString());
	        SOAPElement fromElement = bodyElement.addChildElement("from-id", "HrServiceService");
	        fromElement.addTextNode(from_id.toString());
	        SOAPElement toElement = bodyElement.addChildElement("to-id", "HrServiceService");
	        toElement.addTextNode(to_id.toString());
	        
	        soapMessage.saveChanges();
	        
	        return soapMessage;
	        
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;   
	}
}
