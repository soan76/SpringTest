package com.yeom.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeom.spring.test.ajax.domain.Booking;
import com.yeom.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("ajax/booking")
public class bookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		List<Booking> bookingList = bookingService.getBookingList();
		
		model.addAttribute("BookingList", bookingList);
		
		return "ajax/booking/list";
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/main")
	public String bookingMian() {
		return "ajax/booking.main";
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String>createBooking(
			@RequestParam("name") String name
			, @RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber")String phoneNumber) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
				
		// {"result":"success}
		// {"result":"fail"}
				
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	public deleteBooking(@RequestParam("id") int id) {
		
		int count = bookingService.deleteBooking(id);
		
		//  reload = 새로고침
	}
	
}
