package com.system.loan.config;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Testing {
	public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  
		  // create 2 BigDecimal Objects
		        BigDecimal bg1, bg2;

		        bg1 = new BigDecimal("0.02402344547456443");

		 // set scale of bg1 to 2 in bg2 using floor as rounding mode
		        bg2 = bg1.setScale(3, RoundingMode.HALF_UP);
		        
		       
		        String str = bg1 + " after changing the scale to 2 and rounding is " +bg2;

		 // print bg2 value
		        System.out.println( str );

		}

}
