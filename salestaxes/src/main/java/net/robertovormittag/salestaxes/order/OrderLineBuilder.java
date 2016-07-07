package net.robertovormittag.salestaxes.order;

import net.robertovormittag.salestaxes.product.Product;

import static net.robertovormittag.salestaxes.product.ProductBuilder.productBuilder;

public class OrderLineBuilder {


    private Product product;
    private Integer quantity;

    public static OrderLineBuilder orderLineBuilder() {
        return new OrderLineBuilder();

    }

    public OrderLine build() {
        return new OrderLine(product, quantity);
    }

    public OrderLineBuilder product(Product product) {
        this.product = product;
        return this;
    }

    public OrderLineBuilder quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
