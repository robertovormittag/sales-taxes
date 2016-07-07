package net.robertovormittag.salestaxes.tax;

import java.math.BigDecimal;
import net.robertovormittag.salestaxes.tax.Tax;

import static org.junit.Assert.*;
import org.junit.Test;


public class TaxTest {

	@Test
	public void testRound() {
				
		assertEquals(new BigDecimal("1.05"), Tax.round(new BigDecimal("1.03"), Tax.ROUNDING, BigDecimal.ROUND_UP));
		assertEquals(new BigDecimal("1.10"), Tax.round(new BigDecimal("1.051"), Tax.ROUNDING, BigDecimal.ROUND_UP));
		assertEquals(new BigDecimal("1.05"), Tax.round(new BigDecimal("1.05"), Tax.ROUNDING, BigDecimal.ROUND_UP));
		assertEquals(new BigDecimal("1.95"), Tax.round(new BigDecimal("1.900001"), Tax.ROUNDING, BigDecimal.ROUND_UP));				
	}

}
