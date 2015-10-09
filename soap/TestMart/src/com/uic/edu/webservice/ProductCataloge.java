package com.uic.edu.webservice;

import java.util.List;

import javax.jws.WebService;

import com.uic.edu.webservice.business.ProductSericeImpl;
import com.uic.edu.webservice.model.Product;

@WebService(endpointInterface = "com.uic.edu.webservice.ProductCatalogInterface")
public class ProductCataloge implements ProductCatalogInterface {

	ProductSericeImpl productSericeImpl = new ProductSericeImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uic.edu.webservice.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		return productSericeImpl.getProductCategories();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uic.edu.webservice.ProductCatalogInterface#getProduct(java.lang.
	 * String)
	 */
	@Override

	public List<String> getProduct(String category) {
		return productSericeImpl.getProduct(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uic.edu.webservice.ProductCatalogInterface#addProduct(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productSericeImpl.addProduct(category, product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uic.edu.webservice.ProductCatalogInterface#getProductV2(java.lang.
	 * String)
	 */
	@Override
	public List<Product> getProductV2(String category) {
		return productSericeImpl.getProductV2(category);
	}

}
