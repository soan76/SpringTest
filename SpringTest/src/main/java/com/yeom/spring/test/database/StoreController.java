package com.yeom.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yeom.spring.test.database.domain.Store;
import com.yeom.spring.test.database.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	public List<Store> storeList() {
		
		List<Store> storeList = storeService.getStoreList();
		return storeList;
	}
	
}
