package net.robertovormittag.salestaxes.order;

import net.robertovormittag.salestaxes.product.*;
import net.robertovormittag.salestaxes.tax.Tax;

import java.math.BigDecimal;

public class OrderLine {

    private final Product product;
    private final Integer quantity;

    public OrderLine(Product product, Integer quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public BigDecimal getTax() {
    	
    	BigDecimal tax = BigDecimal.ZERO;
    	
    	if (!product.isExempt()) {
    		tax = tax.add(product.getPrice().multiply(Tax.SALES_TAX));
    	}
    	
    	if (product.isImported()) {
    		tax = tax.add(product.getPrice().multiply(Tax.IMPORT_DUTY));
    	}
    	
    	tax = Tax.round(tax, Tax.ROUNDING, BigDecimal.ROUND_UP);
    	
    	return tax;
    }
    

    public BigDecimal getTotal() {
    	
        BigDecimal total = product.getPrice().add(getTax());
        
        total = total.multiply(new BigDecimal(quantity));
        total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        
        return total;
    }
    
}
