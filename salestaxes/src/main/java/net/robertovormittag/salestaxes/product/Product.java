package net.robertovormittag.salestaxes.product;

import java.math.BigDecimal;

public class Product {
	
    private final BigDecimal price;
    private final Integer productCode;
    private final String description;
    private final boolean exempt;
    private final boolean imported;

    public Product(BigDecimal cost, Integer productCode, String description,
    		boolean exempt, boolean imported) {

        this.price = cost;
        this.productCode = productCode;
        this.description = description;
        this.exempt = exempt;
        this.imported = imported;
    }
        
    public BigDecimal getPrice() {
        return price;
    }

    public Integer getProductCode() {
        return productCode;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public boolean isExempt() {
    	return exempt;
    }
    
    public boolean isImported() {
    	return imported;
    }
}
