package com.yeom.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeom.spring.test.mybatis.domain.RealEstate;
import com.yeom.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {

	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id")int id) {
		RealEstate realEstate = realEstateService.getrealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/real-estate/2")
	@ResponseBody
	public List<RealEstate> realEstateRent(@RequestParam("rent")int rent) {
		List<RealEstate> realEstateRent = realEstateService.getrealEstateRent(rent);
		
		return realEstateRent;
	}
	
}
