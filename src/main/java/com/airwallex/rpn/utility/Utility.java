package com.airwallex.rpn.utility;

import java.math.BigDecimal;

public class Utility {

	 /**
     * 
     * @param str
     * @return
     */
    public static Double parseDouble(String str) 
    {
        try {
            return Double.parseDouble(str);
        } 
        catch (NumberFormatException nfe) {
            return null;
        }
    }
    
    public static BigDecimal parseBigDecimal(String str) 
    {
        try {
            return new BigDecimal(str);
        } 
        catch (NumberFormatException nfe) {
            return null;
        }
    }
}
