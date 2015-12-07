package com.system.loan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class test {

	public static void main(String[] args) {
		
		float b1=0,b2=0,b3=0,b4;
		
		 b1=(float) 567666.336666;
		 b2=(float) (b1*0.01);
		 b3=(float) (Math.ceil(b2));
		 b4=(b3*100);
		
		System.out.println(Math.ceil(b4));
		

	}

}
