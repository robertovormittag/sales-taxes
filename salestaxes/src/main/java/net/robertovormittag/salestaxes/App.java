package net.robertovormittag.salestaxes;

import static net.robertovormittag.salestaxes.order.OrderBuilder.orderBuilder;
import static net.robertovormittag.salestaxes.order.OrderLineBuilder.orderLineBuilder;
import static net.robertovormittag.salestaxes.product.ProductBuilder.productBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;

import net.robertovormittag.salestaxes.order.Checkout;
import net.robertovormittag.salestaxes.order.Order;
import net.robertovormittag.salestaxes.order.OrderLine;

public class App {
	
    public static void main( String[] args ) {
    	
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
        
        System.out.println(checkout.getReceipt());
        
    }
}
