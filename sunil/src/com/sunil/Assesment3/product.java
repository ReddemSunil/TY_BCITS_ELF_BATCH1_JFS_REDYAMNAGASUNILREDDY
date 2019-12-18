package com.sunil.Assesment3;
public class product
{
	private String productName;
	private static double productCost;                                                                                                                                                                                                       
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
	static double cost()
	{
		if(productCost<2000)
			return productCost;
		else
			return 0;
	}
}
