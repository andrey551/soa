
package com.tad.b1.utils;

import com.tad.b1.dto.Wrapper.GroupNameWrapper;
import com.tad.b1.entity.Worker;
import com.tad.b1.dto.Wrapper.WorkerListWrapper;
import com.tad.b1.dto.entityDto.WorkerDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dau Cong Tuan Anh
 */
public class XmlService {
    public static String marshal(Worker x) {
        try {
            JAXBContext context = JAXBContext.newInstance(Worker.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            mar.marshal(x, sw);
            return sw.toString();
        } catch (JAXBException ex) {
              
        }
        
        return null;
    }
    
    public static String marshalArray(GroupNameWrapper wrapper) {
        try{
            JAXBContext context = JAXBContext.newInstance(GroupNameWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(wrapper, sw);
            return sw.toString();
        } catch(JAXBException ex) {
            
        }
        
        return null;
    }
     
    public static String marshalArray(WorkerListWrapper wrapper) {
        try{
            JAXBContext context = JAXBContext.newInstance(WorkerListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(wrapper, sw);
            return sw.toString();
        } catch(JAXBException ex) {
            
        }
        
        return null;
    }
    
    public static Worker unmarshal(String xmlStr) {
        try {
            JAXBContext context = JAXBContext.newInstance(Worker.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlStr);
            Worker worker = (Worker)unmarshaller.unmarshal(reader);
            
            return worker;
        } catch (JAXBException ex) {
              
        }
        
        return null;
    }
    
    public static String marshalWorkerDTO(WorkerDTO worker) {
            
        try {
            JAXBContext context = JAXBContext.newInstance(WorkerDTO.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(worker, sw);
            return sw.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(XmlService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
}
