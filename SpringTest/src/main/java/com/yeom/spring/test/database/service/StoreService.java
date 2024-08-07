package com.yeom.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeom.spring.test.database.domain.Store;
import com.yeom.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> getStoreList() {
		// store 테이블 모든 행 조회
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
}
