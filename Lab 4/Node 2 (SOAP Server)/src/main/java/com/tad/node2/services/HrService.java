package com.tad.node2.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tad.node2.repositories.HrRepository;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.soap.SOAPMessage;

@WebService
public class HrService {
	@Autowired
	HrRepository repo = new  HrRepository();
	
	@WebMethod
	public int fireEmployee(@WebParam Long id) {
		return repo.fireEmployee(id);
	}
	
	@WebMethod
	public int changeOrganization(@WebParam Long id,
								   @WebParam Long from_id,
								   @WebParam Long to_id) {
		return repo.changeOrg(id, from_id, to_id);
	}

}
