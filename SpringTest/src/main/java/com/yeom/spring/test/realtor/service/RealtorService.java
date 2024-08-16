package com.yeom.spring.test.realtor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeom.spring.test.realtor.domain.Realtor;
import com.yeom.spring.test.realtor.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		
		int count = realtorRepository.insertRealtor(realtor);
		
		return count;
		
	}
	
}
