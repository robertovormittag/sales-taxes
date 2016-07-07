package net.robertovormittag.salestaxes.order;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static net.robertovormittag.salestaxes.order.OrderBuilder.orderBuilder;
import static net.robertovormittag.salestaxes.order.OrderLineBuilder.orderLineBuilder;
import static net.robertovormittag.salestaxes.product.ProductBuilder.productBuilder;

public class CheckoutTest {

    @Test
    public void shouldCalculateOrder3Total(){
        // Given
    	ArrayList<OrderLine> orderLines = new ArrayList<>();
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("27.99"))
        				.productCode(1301)
        				.description("imported bottle of perfume")
        				.exempt(false)
        				.imported(true)
        				.build())
        		.quantity(1).build());
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("18.99"))
        				.productCode(1302)
        				.description("bottle of perfume")
        				.exempt(false)
        				.imported(false)
        				.build())
        		.quantity(1).build());
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("9.75"))
        				.productCode(1303)
        				.description("packet of headache pills")
        				.exempt(true)
        				.imported(false)
        				.build())
        		.quantity(1).build());
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("11.25"))
        				.productCode(1304)
        				.description("box of imported chocolates")
        				.exempt(true)
        				.imported(true)
        				.build())
        		.quantity(1).build());

        Order order = orderBuilder().orderLines(orderLines).build();
        Checkout checkout = new Checkout(order);

        // When
        BigDecimal orderTax = checkout.getTax();
        BigDecimal orderTotal = checkout.getTotal();

        // Then
        assertThat(orderTax, is(new BigDecimal("6.70")));
        assertThat(orderTotal, is(new BigDecimal("74.68")));
    }
	
    @Test
    public void shouldCalculateOrder2Total(){
        // Given
    	ArrayList<OrderLine> orderLines = new ArrayList<>();
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("10.00"))
        				.productCode(1201)
        				.description("imported box of chocolates")
        				.exempt(true)
        				.imported(true)
        				.build())
        		.quantity(1).build());
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("47.50"))
        				.productCode(1202)
        				.description("imported bottle of perfume")
        				.exempt(false)
        				.imported(true)
        				.build())
        		.quantity(1).build());
        Order order = orderBuilder().orderLines(orderLines).build();
        Checkout checkout = new Checkout(order);

        // When
        BigDecimal orderTax = checkout.getTax();
        BigDecimal orderTotal = checkout.getTotal();

        // Then
        assertThat(orderTax, is(new BigDecimal("7.65")));
        assertThat(orderTotal, is(new BigDecimal("65.15")));
    }

	
    @Test
    public void shouldCalculateOrder1Total(){
        // Given
    	ArrayList<OrderLine> orderLines = new ArrayList<>();
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("12.49"))
        				.productCode(1101)
        				.description("book")
        				.exempt(true)
        				.imported(false)
        				.build())
        		.quantity(1).build());
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("14.99"))
        				.productCode(1102)
        				.description("music CD")
        				.exempt(false)
        				.imported(false)
        				.build())
        		.quantity(1).build());
    	orderLines.add(orderLineBuilder()
        		.product(productBuilder().price(new BigDecimal("0.85"))
        				.productCode(1103)
        				.description("chocolate bar")
        				.exempt(true)
        				.imported(false)
        				.build())
        		.quantity(1).build());    	
        Order order = orderBuilder().orderLines(orderLines).build();
        Checkout checkout = new Checkout(order);

        // When
        BigDecimal orderTax = checkout.getTax();
        BigDecimal orderTotal = checkout.getTotal();

        // Then
        assertThat(orderTax, is(new BigDecimal("1.50")));
        assertThat(orderTotal, is(new BigDecimal("29.83")));
    }
	
}
