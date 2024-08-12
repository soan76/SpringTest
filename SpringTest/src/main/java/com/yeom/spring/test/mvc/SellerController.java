package com.yeom.spring.test.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {

	@GetMapping("/mvc/seller/info")
	public String sellerInfo() {
		
		return "/mvc/sellerInfo";
	}
	
}
