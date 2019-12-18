package com.sunil.AssesmentOnStrings;
public class product
{
	private String productName;
	private double productCost;
	private double weight;
	public product(String productName, double productCost, double weight) {
		super();
		this.productName = productName;
		this.productCost = productCost;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "product [productName=" + productName + ", productCost=" + productCost + ", weight=" + weight + "]";
	}
	
}
