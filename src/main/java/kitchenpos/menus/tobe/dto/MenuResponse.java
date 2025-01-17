package kitchenpos.menus.tobe.dto;

import kitchenpos.menus.tobe.domain.Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MenuResponse {
    private final UUID id;
    private final String name;
    private final BigDecimal price;
    private final MenuGroupResponse menuGroup;
    private final boolean displayed;
    private final List<MenuProductResponse> menuProducts;
    private final UUID menuGroupId;

    private MenuResponse(final UUID id, final String name, final BigDecimal price, final MenuGroupResponse menuGroup, final boolean displayed, final List<MenuProductResponse> menuProducts, final UUID menuGroupId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.menuGroup = menuGroup;
        this.displayed = displayed;
        this.menuProducts = Collections.unmodifiableList(menuProducts);
        this.menuGroupId = menuGroupId;
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

    public MenuGroupResponse getMenuGroup() {
        return menuGroup;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public List<MenuProductResponse> getMenuProducts() {
        return new ArrayList<>(menuProducts);
    }

    public UUID getMenuGroupId() {
        return menuGroupId;
    }

    public static MenuResponse from(final Menu menu, final MenuGroupResponse menuGroup) {
        return new MenuResponse(
                menu.getId(),
                menu.getName(),
                menu.getPrice(),
                menuGroup,
                menu.isDisplayed(),
                menu.getMenuProducts().stream()
                        .map(MenuProductResponse::from)
                        .collect(Collectors.toList()),
                menuGroup.getId()
        );
    }
}
