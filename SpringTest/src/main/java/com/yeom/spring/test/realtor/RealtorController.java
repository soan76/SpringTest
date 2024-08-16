package com.yeom.spring.test.realtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yeom.spring.test.realtor.domain.Realtor;
import com.yeom.spring.test.realtor.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {

	@Autowired
	private RealtorService realtorService;
	
	@PostMapping("/create")
	public String createRealtor(
//			@RequestParam("office") String office
//			, @RequestParam("phoneNumber") String phoneNumber
//			, @RequestParam("address") String address
//			, @RequestParam("grade") String grade
			@ModelAttribute Realtor realtor
			, Model model) {
		
//		Realtor realtor = new Realtor();
//		
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
		
		realtorService.addRealtor(realtor);
		
		model.addAttribute("realtor", realtor);
		
		return "realtor/realtorInfo";
		
	}
	
	@GetMapping("/input")
	public String realtorInput() {
		return "realtor/realtorInput";
	}
	
}
