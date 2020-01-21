package com.bcits.discomusecase.billtariff;

public class BillTariff {
	public static double claculateBill(int unit, String userType) {
		double tariffBill = 0;
		if (userType.equalsIgnoreCase("residential consumer")) {
			if (unit <= 100) {
				tariffBill = unit * 4;
			} else if (unit <= 200) {
				tariffBill = 100 * 4 + (unit - 100) * 5;
			} else {
				tariffBill = 100 * 4 + 100 * 5 + (unit - 200) * 8;
			}
			return tariffBill;
		} else if (userType.equalsIgnoreCase("commercial consumer")) {
			if (unit <= 1000) {
				tariffBill = unit * 10;
			} else if (unit <= 2000) {
				tariffBill = 1000 * 10 + (unit - 1000) * 15;
			} else {
				tariffBill = 1000 * 10 + 1000 * 15 + (unit - 2000) * 18;
			}
			return tariffBill;
		} else if (userType.equalsIgnoreCase("industries consumer")) {
			if (unit <= 10000) {
				tariffBill = unit * 15;
			} else if (unit <= 20000) {
				tariffBill = 10000 * 15 + (unit - 10000) * 20;
			} else {
				tariffBill = 10000 * 15 + 10000 * 20 + (unit - 20000) * 25;
			}
			return tariffBill;
		} else {
			System.out.println("invalid type of consumer");
			return 0.00;
		}
	}

}
