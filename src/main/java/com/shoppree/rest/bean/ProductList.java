package com.shoppree.rest.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductList {
	private List<ProductBean> items;

	public List<ProductBean> getItems() {
		return items;
	}

	public void setItems(List<ProductBean> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ProductList [items=" + items + "]";
	}

}
