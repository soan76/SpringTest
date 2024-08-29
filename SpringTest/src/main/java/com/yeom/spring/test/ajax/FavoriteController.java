package com.yeom.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeom.spring.test.ajax.domain.Favorite;
import com.yeom.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/list")
	public String favorite(Model model) {
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
				
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/list";
	}
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/favorite/input";
	}
	
	//api
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoriteService.addFavoriteService(name, url);
		
		//json 문자열로 response에 데이터를 채운다
		// 성공여부
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
	
	@PostMapping("/duplicate-url")
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		Map<String, Boolean> resultMap = new HashMap<>();
		
//		if(isDuplicate) {
//			resultMap.put("isDuplicate", true);
//		} else {
//			resultMap.put("isDuplicate", false);
//		}
		resultMap.put("isDuplicate", isDuplicate);
		
		return resultMap;
	}
	
	//삭제 api
	@GetMapping("/delete")
	public Map<String, String> deleteFavorite(int id) {
		
		int count = favoriteService.deleteFavorite(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
}
