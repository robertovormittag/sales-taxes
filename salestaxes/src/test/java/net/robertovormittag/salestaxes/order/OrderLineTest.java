package net.robertovormittag.salestaxes.order;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static net.robertovormittag.salestaxes.order.OrderLineBuilder.orderLineBuilder;
import static net.robertovormittag.salestaxes.product.ProductBuilder.productBuilder;

public class OrderLineTest {

    @Test
    public void shouldCalculateCostOfImportedChocolateBox() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("11.25"))
        				.productCode(1304)
        				.description("box of imported chocolates")
        				.exempt(true)
        				.imported(true)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("0.60")));
        assertThat(total, is(new BigDecimal("11.85")));
    }
	
    @Test
    public void shouldCalculateCostOfHeadachePills() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("9.75"))
        				.productCode(1303)
        				.description("packet of headache pills")
        				.exempt(true)
        				.imported(false)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("0.00")));
        assertThat(total, is(new BigDecimal("9.75")));
    }
		
    @Test
    public void shouldCalculateCostOfPerfumeBottle() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("18.99"))
        				.productCode(1302)
        				.description("bottle of perfume")
        				.exempt(false)
        				.imported(false)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("1.90")));
        assertThat(total, is(new BigDecimal("20.89")));
    }
	
    @Test
    public void shouldCalculateCostOfImportedPerfumeBottle() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("27.99"))
        				.productCode(1301)
        				.description("imported bottle of perfume")
        				.exempt(false)
        				.imported(true)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("4.20")));
        assertThat(total, is(new BigDecimal("32.19")));
    }

    @Test
    public void shouldCalculateCostOfImportedPerfume() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("47.50"))
        				.productCode(1202)
        				.description("imported bottle of perfume")
        				.exempt(false)
        				.imported(true)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("7.15")));
        assertThat(total, is(new BigDecimal("54.65")));
    }
	
    @Test
    public void shouldCalculateCostOfImportedChocolate() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("10.00"))
        				.productCode(1201)
        				.description("imported box of chocolates")
        				.exempt(true)
        				.imported(true)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("0.50")));
        assertThat(total, is(new BigDecimal("10.50")));
    }

    @Test
    public void shouldCalculateCostOfChocolateBar() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("0.85"))
        				.productCode(1103)
        				.description("chocolate bar")
        				.exempt(true)
        				.imported(false)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("0.00")));
        assertThat(total, is(new BigDecimal("0.85")));
    }
    
    @Test
    public void shouldCalculateCostOfMusicCD() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("14.99"))
        				.productCode(1102)
        				.description("music CD")
        				.exempt(false)
        				.imported(false)
        				.build())
        		.quantity(1).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();
        
        // Then
        assertThat(tax, is(new BigDecimal("1.50")));
        assertThat(total, is(new BigDecimal("16.49")));
    }

	
    
    @Test
    public void shouldCalculateCostOfTwoBooks() {
        // Given
        OrderLine orderLine = orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("12.49"))
        				.productCode(1101)
        				.description("book")
        				.exempt(true)
        				.imported(false)
        				.build())
        		.quantity(2).build();

        // When
        BigDecimal tax = orderLine.getTax();
        BigDecimal total = orderLine.getTotal();

        // Then
        assertThat(tax, is(new BigDecimal("0.00")));
        assertThat(total, is(new BigDecimal("24.98")));
    }
    
}
