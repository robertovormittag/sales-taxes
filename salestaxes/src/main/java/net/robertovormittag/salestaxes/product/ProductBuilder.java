package net.robertovormittag.salestaxes.product;

import java.math.BigDecimal;


public class ProductBuilder {

    private BigDecimal price;
    private Integer productCode;
    private String description;
    private boolean exempt;
    private boolean imported;

    public Product build() {
        return new Product(price, productCode, description, exempt, imported);
    }

    public static ProductBuilder productBuilder() {
        return new ProductBuilder();
    }

    public ProductBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder productCode(Integer productCode) {
        this.productCode = productCode;
        return this;
    }
    
    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }
    
    public ProductBuilder exempt(boolean exempt) {
        this.exempt = exempt;
        return this;
    }

    public ProductBuilder imported(boolean imported) {
        this.imported = imported;
        return this;
    }

}
