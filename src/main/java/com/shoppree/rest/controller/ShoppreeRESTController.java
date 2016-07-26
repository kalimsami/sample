package com.shoppree.rest.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppree.rest.jdbc.MagentoProductImport;
import com.shoppree.rest.jdbc.ShoppreeJDBCTemplate;

 
@Controller
public class ShoppreeRESTController 
{
	private final String ALL_COMPANIES = "/companies";
	private final String COMPANY_BY_USER_ID = "/companies/{userid}";
	private final String ALL_BENEFITS = "/benefits";
	private final String BENEFITS_BY_USER_ID = "/benefits/{userid}";
	private final String LOCATIONS_BY_USER_ID = "/locationsbyuser/{userid}";
	private final String LOCATIONS_BY_BUSINESS_ID = "/locationsbybusiness/{business_id}";
	private final String LOGO_BY_USER_ID = "/logo/{userid}";
	private final String BENEFITS_BY_BENEFIT_ID = "/get-benefits/{benefit_id}";
	private final String CATEGORIES = "/categories";
	private final String GET_PRODUCT = "/products";
	private final String GET_POINTS_BY_CART_AMOUNT = "/get-points-by-cart-amount/{amount}";
	private final String GET_ITEMS_BY_PURCHASES = "/get-items-by-no-of-purchases/{no_of_purchases}";
	
	@Autowired
	private ShoppreeJDBCTemplate shoppreeJDBCTemplate;
	
	@Autowired
	private MagentoProductImport magentoProductImport;
	
    @RequestMapping(value = ALL_COMPANIES)
    public String getAllCompaniesJSON(Model model) {
        model.addAttribute("companies", shoppreeJDBCTemplate.getAllCompanies());
        return "jsonTemplate";
    }
    
    @RequestMapping(value = COMPANY_BY_USER_ID)
    public String getCompanyByIdJSON(Model model, @PathVariable("userid") int userid) {
    	model.addAttribute("companies", shoppreeJDBCTemplate.getCompanyListByUserId(userid));
        return "jsonTemplate";
    }
    
    @RequestMapping(value = ALL_BENEFITS)
    public String getAllBenefitsJSON(Model model) {
        model.addAttribute("benefits", shoppreeJDBCTemplate.getAllBenefits());
        return "jsonTemplate";
    }
    
    @RequestMapping(value = BENEFITS_BY_USER_ID)
    public String getBenefitsByIdJSON(Model model, @PathVariable("userid") int userid) {
    	model.addAttribute("benefits", shoppreeJDBCTemplate.getBenefitsListByUserId(userid));
        return "jsonTemplate";
    }

    @RequestMapping(value = LOCATIONS_BY_USER_ID)
    public String getAllLocationsByUserJSON(Model model, @PathVariable("userid") int userid) {
    	model.addAttribute("locations", shoppreeJDBCTemplate.getAllLocationsByUser(userid));
    	return "jsonTemplate";
    }

    @RequestMapping(value = LOCATIONS_BY_BUSINESS_ID)
    public String getAllLocationsByBusinessJSON(Model model, @PathVariable("business_id") int business_id) {
    	model.addAttribute("locations", shoppreeJDBCTemplate.getAllLocationsByBusiness(business_id));
    	return "jsonTemplate";
    }
    
    @RequestMapping(value = LOGO_BY_USER_ID)
    public String getAllLogoByUserJSON(Model model, @PathVariable("userid") int userid) {
    	model.addAttribute("logos", shoppreeJDBCTemplate.getAllLogoByUser(userid));
    	return "jsonTemplate";
    }

    @RequestMapping(value = BENEFITS_BY_BENEFIT_ID)
    public String getBenefitsByBusinessIdJSON(Model model, @PathVariable("benefit_id") int benefit_id) {
    	model.addAttribute("benefits", shoppreeJDBCTemplate.getBenefitsListByBenefitId(benefit_id));
    	return "jsonTemplate";
    }
    
    @RequestMapping(value = CATEGORIES)
    public String getAllCategoriesJSON(Model model) {
        model.addAttribute("categories", shoppreeJDBCTemplate.getAllCategories());
        return "jsonTemplate";
    }

    @RequestMapping(value = GET_PRODUCT)
    public String importProducts(Model model) {
    	//model.addAttribute("productList", magentoProductImport.importProductsFromMagentoMethod1());
    	model.addAttribute("productList", magentoProductImport.importProductsFromMagentoMethod2());
    	return "jsonTemplate";
    }

    @RequestMapping(value = GET_POINTS_BY_CART_AMOUNT)
    public String getPointsByCartAmount(Model model, @PathVariable("amount") String cartAmount) {
    	model.addAttribute("red_PointsList", shoppreeJDBCTemplate.getPointsByCartAmount(cartAmount));
    	return "jsonTemplate";
    }
    
    @RequestMapping(value = GET_ITEMS_BY_PURCHASES)
    public String getItemsByPurchases(Model model, @PathVariable("no_of_purchases") String noOfPurchases) {
    	model.addAttribute("red_itemList", shoppreeJDBCTemplate.getItemsByPurchases(noOfPurchases));
    	return "jsonTemplate";
    }
}