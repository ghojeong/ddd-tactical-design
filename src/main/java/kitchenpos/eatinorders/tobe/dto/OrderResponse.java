package kitchenpos.eatinorders.tobe.dto;

import kitchenpos.eatinorders.tobe.domain.OrderLineItem;
import kitchenpos.eatinorders.tobe.domain.OrderStatus;
import kitchenpos.eatinorders.tobe.domain.OrderType;
import kitchenpos.eatinorders.tobe.domain.ordertable.OrderTable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class OrderResponse {
    private UUID id;
    private OrderType type;
    private OrderStatus status;
    private LocalDateTime orderDateTime;
    private List<OrderLineItem> orderLineItems;
    private String deliveryAddress;
    private OrderTable orderTable;
    private UUID orderTableId;

    protected OrderResponse() {}

    public OrderResponse(final UUID id, final OrderType type, final OrderStatus status, final LocalDateTime orderDateTime, final List<OrderLineItem> orderLineItems, final String deliveryAddress, final OrderTable orderTable, final UUID orderTableId) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.orderDateTime = orderDateTime;
        this.orderLineItems = Collections.unmodifiableList(orderLineItems);
        this.deliveryAddress = deliveryAddress;
        this.orderTable = orderTable;
        this.orderTableId = orderTableId;
    }

    public UUID getId() {
        return id;
    }

    public OrderType getType() {
        return type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return new ArrayList<>(orderLineItems);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public UUID getOrderTableId() {
        return orderTableId;
    }
}
