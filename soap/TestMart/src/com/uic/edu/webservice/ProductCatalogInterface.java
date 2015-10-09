package com.uic.edu.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.uic.edu.webservice.model.Product;

@WebService(name = "TestMartCatalog", portName = "TestMartCatalogePort")
public interface ProductCatalogInterface {
	@WebMethod(action = "fetch_categories", operationName = "fetchCategories")
	List<String> getProductCategories();

	@WebMethod
	List<String> getProduct(String category);

	@WebMethod
	boolean addProduct(String category, String product);

	@WebMethod
	@WebResult(name = "Product")
	List<Product> getProductV2(String category);

}