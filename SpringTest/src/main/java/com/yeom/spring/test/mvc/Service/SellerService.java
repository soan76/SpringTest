package com.yeom.spring.test.mvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeom.spring.test.mvc.domain.Seller;
import com.yeom.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	// 닉네임, 온도, 프로필 이미지 경로 전달 받고 판매자 정보 저장
	public int getAddseller(String nickname
			, double temperature
			, String profileImage) {
		
		int count = sellerRepository.insertSeller(nickname, temperature, profileImage);
		return count;
	}
	
	public Seller getLastSeller() {
		Seller seller = sellerRepository.selectLastSeller();
		
		return seller;
	}
	
	public Seller getSeller(int id) {
		
		Seller seller = sellerRepository.selectSeller(id);
		return seller;
	}
	
}
