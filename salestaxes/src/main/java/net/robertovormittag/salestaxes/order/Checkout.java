package net.robertovormittag.salestaxes.order;

import java.math.BigDecimal;

public class Checkout {
	
    private final Order order;
    
    // lazy cache
    private BigDecimal tax;
    private BigDecimal total;
    private String receipt;

    public Checkout(Order order) {
        this.order = order;
    }

    public BigDecimal getTax() {
    	
    	if (tax != null) return tax;
    	
        tax = BigDecimal.ZERO;      
        
        for (OrderLine orderLine : order.getOrderLines()) {
            tax = tax.add(orderLine.getTax());
        }
        
        return tax;
    }
    
    public BigDecimal getTotal() {
    	
    	if (total != null) return total;
    	
        total = BigDecimal.ZERO;
        
        for (OrderLine orderLine : order.getOrderLines()) {
            total = total.add(orderLine.getTotal());
        }
        
        return total;
    }
    
    public String getReceipt() {
    	
    	if (receipt != null) return receipt;
    	
    	String newline = System.getProperty("line.separator");
    	
    	StringBuilder sb = new StringBuilder();
    	BigDecimal price, tax, cost;
    	
        for (OrderLine orderLine : order.getOrderLines()) {
        	price = orderLine.getProduct().getPrice();
        	tax = orderLine.getTax();
        	cost = price.add(tax);
        	sb.append(orderLine.getQuantity());
        	sb.append(" ");
        	sb.append(orderLine.getProduct().getDescription());
        	sb.append(": ");
        	sb.append(cost);
        	sb.append(newline);
        }
        sb.append("Sales Taxes: ");
        sb.append(getTax());
    	sb.append(newline);
    	sb.append("Total: ");
    	sb.append(getTotal());
    	sb.append(newline);
    	    	
    	receipt = sb.toString();
    	return receipt;
    }
    
}
