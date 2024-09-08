package com.example.domain;

public enum PromotionCode {
	PROMO10(0.1),
	PROMO20(0.2),
	NONE(0.0); // 프로모션 코드가 없는 경우

	private final double discountRate;

	PromotionCode(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public static PromotionCode fromCode(String code) {
		switch (code) {
			case "PROMO10":
				return PROMO10;
			case "PROMO20":
				return PROMO20;
			default:
				return NONE;
		}
	}
}
