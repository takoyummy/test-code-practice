package com.example.application;

import org.springframework.stereotype.Service;

import com.example.domain.CustomerType;
import com.example.domain.Discount;
import com.example.domain.PromotionCode;

@Service
public class DiscountService {
	public double applyDiscount(double price, CustomerType customerType, String promotionCodeStr) {
		PromotionCode promotionCode = PromotionCode.fromCode(promotionCodeStr);
		Discount discount = new Discount(price, customerType, promotionCode);
		return discount.calculateDiscount();
	}
}
