package com.wll.test.javabase.base;

import java.math.BigDecimal;

public class TestBigDecimal {

	public static void main(String[] args) {
		BigDecimal balance = new BigDecimal("16601983251.90");
		BigDecimal consume = new BigDecimal("7641.00");
		BigDecimal consumeSelf = new BigDecimal("37290.00");
		BigDecimal recharge = new BigDecimal("50000000");
		
		System.out.println(balance.add(consume).add(consumeSelf).subtract(recharge));
	}
}
