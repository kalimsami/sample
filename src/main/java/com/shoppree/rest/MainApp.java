package com.shoppree.rest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppree.rest.bean.ItemsBean;
import com.shoppree.rest.bean.PointsBean;
import com.shoppree.rest.jdbc.ShoppreeJDBCTemplate;

public class MainApp {

		
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config-test.xml");

		try {
			/*ShoppreeJDBCTemplate shoppreeJDBCTemplate = (ShoppreeJDBCTemplate) context.getBean("shoppreeJDBCTemplate");

			System.out.println("------Listing Multiple Records--------");

			List<BusinessDetailsBean> businessDetails = shoppreeJDBCTemplate.getAllCompanies();

			for (BusinessDetailsBean record : businessDetails) {
				System.out.println("Business_id : " + record.getBusiness_id());
				System.out.println("BusinessName : " + record.getBusinessName());
				System.out.println("Details : " + record.getDetails());
				System.out.println("PhoneNumber : " + record.getPhoneNumber());
				System.out.println("Website : " + record.getWebsite());
				System.out.println("UserId : " + record.getUserId());
				System.out.println("BusinessLogo : " + record.getBusinessLogo());
				System.out.println("DateTimeStamp : " + record.getDateTimeStamp());
				System.out.println();
				System.out.println();
			}*/
			
			/*MagentoProductImport magentoProductImport = (MagentoProductImport) context.getBean("magentoProductImport");
			//System.out.println(magentoProductImport.importProductsFromMagentoMethod1());
			System.out.println(magentoProductImport.importProductsFromMagentoMethod2());*/
			
			ShoppreeJDBCTemplate shoppreeJDBCTemplate = (ShoppreeJDBCTemplate) context.getBean("shoppreeJDBCTemplate");

			System.out.println("--------------------------------------");
			System.out.println("------Listing Multiple Records--------");
			System.out.println("--------------------------------------");
			
			List<PointsBean> pointList = shoppreeJDBCTemplate.getPointsByCartAmount("10");
			for (PointsBean record : pointList) {
				System.out.println(record.getCurrency());
				System.out.println(record.getPoints_count());
				System.out.println(record.getRed_currency());
				System.out.println(record.getRed_points());
			}
			List<ItemsBean> itemList = shoppreeJDBCTemplate.getItemsByPurchases("2");
			for (ItemsBean record : itemList) {
				System.out.println(record.getNo_of_purchases());
				System.out.println(record.getProduct_id());
				System.out.println(record.getRed_product_id());
			}
			
		} finally {
			((ClassPathXmlApplicationContext) context).close();
		}

	}
}
