package com.sunil.Assesment3;
public class ProductDemo
{
	public static void main(String[] args)
	{
		Object[] a=new Object[4];
		product p1=new product("mobile", 15000, 0.8);
		product p2=new product("laptop", 65000, 8.0);
		product p3=new product("watch", 500, 0.3);
		product p4=new product("pen", 15, 0.05);
		a[0]=p1;
		a[1]=p2;
		a[2]=p3;
		a[3]=p4;
		for(Object o:a)
		{
			System.out.println(((product) o).cost());
		}
	}

}
 