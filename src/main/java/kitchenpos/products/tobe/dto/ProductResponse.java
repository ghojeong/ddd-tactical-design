package kitchenpos.products.tobe.dto;

import kitchenpos.products.tobe.domain.TobeProduct;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {
    private final UUID id;
    private final String name;
    private final BigDecimal price;

    private ProductResponse(final UUID id, final String name, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static ProductResponse from(final TobeProduct product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
