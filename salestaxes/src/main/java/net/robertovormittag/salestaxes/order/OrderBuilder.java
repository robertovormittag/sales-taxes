package net.robertovormittag.salestaxes.order;

import java.util.List;

public class OrderBuilder {

	private List<OrderLine> orderLines;

    public static OrderBuilder orderBuilder() {
        return new OrderBuilder();

    }

    public Order build() {
        return new Order(orderLines);
    }

    public OrderBuilder orderLines(List<OrderLine> orderLines){
        this.orderLines = orderLines;
        return this;
    }

    public OrderBuilder orderLine(OrderLine orderLine){
        this.orderLines.add(orderLine);
        return this;
    }
}
