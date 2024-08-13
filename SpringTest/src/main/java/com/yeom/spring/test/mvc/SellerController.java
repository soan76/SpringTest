package com.yeom.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeom.spring.test.mvc.Service.SellerService;
import com.yeom.spring.test.mvc.domain.Seller;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	// 데이터 저장 과정을 진행할 페이지
	@GetMapping("/create")
	public String createdSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		int count = sellerService.getAddseller(nickname, temperature, profileImage);
		
		return "redirect:/mvc/seller/info";
		
	}
	
	
	@GetMapping("/input")
	public String sellerInput() {
		return "/mvc/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		// Seller seller = sellerService.getLastSeller();
		Seller seller = null;
		//id가 전달이 안되면 최근 판매자 조회
		if(id == null) {
			seller = sellerService.getLastSeller();
		}else {
			// id가 전달이 되면 매치된 판매자 조회
			seller = sellerService.getSeller(id);			
		}
		
		model.addAttribute("seller", seller);
		
		return "/mvc/sellerInfo";
	}
	
}
