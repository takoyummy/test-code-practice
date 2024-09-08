package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Discount {

	private final double price;
	private final CustomerType customerType;
	private final PromotionCode promotionCode;

	public double calculateDiscount() {
		double discount = 0.0;

		// 고객 등급에 따른 기본 할인
		switch (customerType) {
			case VIP:
				discount = 0.2;
				break;
			case REGULAR:
				discount = 0.1;
				break;
			case NEW:
				discount = 0.05;
				break;
			default:
				discount = 0.0;
		}

		// 구매 금액이 100 이상이면 추가 5% 할인
		if (price > 100) {
			discount += 0.05;
		}

		// 프로모션 코드에 따른 추가 할인 적용
		discount += promotionCode.getDiscountRate();

		// 최대 할인 50% 제한
		return price * (1 - Math.min(discount, 0.5));
	}
}
