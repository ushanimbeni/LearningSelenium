package com.test.automation.concept;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Derived d=new Derived();
		// d.init("Hello");
		// d.prnt();

		// Convert String to an Array
		String pin = "1236";
		String a[] = new String[pin.length()];
		for (int i = 0; i < a.length; i++)// length is the property of array
		{
			a[i] = pin.substring(i, i + 1);
		}
		for (int i = 0; i < a.length; i++)// length is the property of array
		{
			System.out.println(a[i]);
		}		
	}
}


