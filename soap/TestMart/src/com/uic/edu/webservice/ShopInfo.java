package com.uic.edu.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import com.uic.edu.webservice.InvalidInputException;

@WebService
public class ShopInfo {
	@WebMethod
	@WebResult(partName = "lookupoutput")
	public String getShopInfo(@WebParam(partName = "lookupInput") String property) throws InvalidInputException {
		String response = null;
		if ("shopName".equals(property)) {
			response = "Test Mart";
		} else if ("since".equals(property)) {
			response = "since 2012";
		} else {
			throw new InvalidInputException("Invalid Input", property + "is not a valid input");
		}
		return response;
	}

}
