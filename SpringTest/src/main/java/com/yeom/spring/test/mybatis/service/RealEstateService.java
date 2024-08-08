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
	
	public List<RealEstate> getrealEstateRent(int rent) {
		List<RealEstate> realEstateRent = realEstateRepository.selectRealEstateRent(rent);
		
		return realEstateRent;
	}
	
}
