package net.robertovormittag.salestaxes.tax;

import java.math.BigDecimal;

public class Tax {
	
	// prevents instantiation
	private Tax() {}
	
	public static final BigDecimal SALES_TAX = new BigDecimal("0.10");
	public static final BigDecimal IMPORT_DUTY = new BigDecimal("0.05");
	public static final BigDecimal ROUNDING = new BigDecimal("0.05");
	
	public static BigDecimal round(BigDecimal value, BigDecimal increment, int roundingMode) {
		
		if (value.signum() == 0) return new BigDecimal("0.00");
		if (increment.signum() == 0) return value;
		
		BigDecimal divided = value.divide(increment, 0, roundingMode);
		BigDecimal result = divided.multiply(increment);
		
		return result;
	}

	
}
