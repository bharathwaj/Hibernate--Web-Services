package com.uic.edu.webservice.business;

import java.util.ArrayList;
import java.util.List;

import com.uic.edu.webservice.model.Product;

public class ProductSericeImpl {
	List<String> bookList = new ArrayList<>();
	List<String> movieList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();

	public ProductSericeImpl() {
		bookList.add("Java");
		bookList.add("C++");
		bookList.add("Hadoop");
		movieList.add("ABCD");
		movieList.add("ABCD2");
		movieList.add("ABCD3");
		musicList.add("we are young");
		musicList.add("Cheerleader");
		musicList.add("beautiful");
	}

	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		return categories;
	}

	public List<String> getProduct(String category) {
		switch (category.toLowerCase()) {
		case "books":
			return bookList;
		case "music":
			return musicList;
		case "movie":
			return movieList;

		}
		return null;

	}

	public boolean addProduct(String category, String product) {
		switch (category.toLowerCase()) {
		case "books":
			bookList.add(product);
			break;
		case "music":
			musicList.add(product);
			break;
		case "movie":
			movieList.add(product);
			break;
		default:
			return false;

		}
		return true;
	}

	public List<Product> getProductV2(String category) {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("Java Brains Book", "1234", 100));
		productList.add(new Product("DotNet Brainsless Book", "ABC", 50));
		// TODO Auto-generated method stub
		return productList;
	}
}
