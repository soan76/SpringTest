package com.yeom.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeom.spring.test.mybatis.domain.RealEstate;
import com.yeom.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getrealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getrealEstateByRentPrice(int rentPrice) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		
		return count;
	}
	
	public int addrealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice
			) {
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
		return count;
	}
	public int updateRealEstate (int id, String type, int price) {
		int count = realEstateRepository.updateRealEstate(id, type, price);
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = realEstateRepository.deleteRealEstate(id);
		return count;
	}
	
	
	
}
