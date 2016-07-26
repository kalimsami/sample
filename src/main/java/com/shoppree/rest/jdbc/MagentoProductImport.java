package com.shoppree.rest.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.util.EntityUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppree.rest.bean.ProductBean;
import com.shoppree.rest.bean.ProductList;

public class MagentoProductImport {

	private static Properties configProp = new Properties();
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

		
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public LinkedHashMap importProductsFromMagentoMethod1() {
		System.out.println("In web service ");

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("product.api.url == "+configProp.getProperty("product.api.url"));
		String response = getDataFromAPI(configProp.getProperty("product.api.url")).toString(); 
		LinkedHashMap productList = null;
		try {
			productList = new ObjectMapper().reader(LinkedHashMap.class).readValue(response);
			System.out.println("productList == "+productList.get("name"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	@SuppressWarnings("deprecation")
	public ProductList importProductsFromMagentoMethod2() {
		System.out.println("In web service ");
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("product.api.url == "+configProp.getProperty("product.api.url"));
		String response = getDataFromAPI(configProp.getProperty("product.api.url")).toString(); 
		ProductList productList = null;
		try {
			productList = new ObjectMapper().reader(ProductList.class).readValue(response);
			
			
			for (ProductBean productBean : productList.getItems()) {
				System.out.println("id == "+productBean.getId());
				System.out.println("name == "+productBean.getName());
				System.out.println("sku == "+productBean.getSku());
				System.out.println("status == "+productBean.getStatus());
				System.out.println("price == "+productBean.getPrice());
				System.out.println("type == "+productBean.getType_id());
				System.out.println("===================================");
				
				String sql = "INSERT INTO imported_products(product_id,name,sku,status,price,type) VALUES('"+productBean.getId()+"','"+productBean.getName()+"','"+productBean.getSku()+"','"+productBean.getStatus()+"','"+productBean.getPrice()+"','"+productBean.getType_id()+"')";
				int row = jdbcTemplateObject.update(sql);
				System.out.println(sql);
				System.out.println(row + " row inserted.");
			}
			
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productList;
	}

	
	private Object getDataFromAPI(String apiURL){

		Object response = null;
		RequestConfig config = getRequestConfig();

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setSSLHostnameVerifier(new DefaultHostnameVerifier(null)).build()) {
			HttpGet getMethod = setHttpGetHeader(apiURL);
			response = executeGet(apiURL, httpClient, getMethod);

		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return response;
	}

	private HttpGet setHttpGetHeader(String apiURL) {
		HttpGet getMethod = new HttpGet(apiURL);
		getMethod.addHeader("accept", "application/json");		

		return getMethod;
	}
	
	private Object executeGet(String apiURL, CloseableHttpClient httpClient, HttpRequestBase httpMethod) throws IOException, ClientProtocolException {
		System.out.println("Service URL : " + apiURL);
		HttpCoreContext localContext = new HttpCoreContext();
		HttpResponse httpResponse = httpClient.execute(httpMethod, localContext);
		String response = EntityUtils.toString(httpResponse.getEntity());
		//System.out.println("REST Response from : " + apiURL.substring(apiURL.lastIndexOf("/")) + " : " + response);
		return response;
	}
	
	private RequestConfig getRequestConfig() {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(5 * 1000).setConnectionRequestTimeout(5 * 1000).setSocketTimeout(5 * 1000).build();
		return config;
	}
}
