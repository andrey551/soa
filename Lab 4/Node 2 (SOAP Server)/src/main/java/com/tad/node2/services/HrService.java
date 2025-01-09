package com.tad.node2.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tad.node2.repositories.HrRepository;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class HrService {
	@Autowired
	HrRepository repo = new  HrRepository();
	
	@WebMethod
	public void fireEmployee(@WebParam Long id) {
		repo.fireEmployee(id);
	}
	
	@WebMethod
	public void changeOrganization(@WebParam Long id,
								   @WebParam Long from_id,
								   @WebParam Long to_id) {
		System.out.println("id:" + id + ", from: " + from_id + ", to: " + to_id);
		repo.changeOrg(id, from_id, to_id);
	}

}
