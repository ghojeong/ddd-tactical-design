package kitchenpos.menus.tobe.domain;

import kitchenpos.common.infra.Profanities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class MenuName {
    @Column(name = "name", nullable = false)
    private String name;

    protected MenuName() {}

    public MenuName(final String name, final Profanities profanities) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("메뉴 이름은 필수값입니다.");
        }
        if (profanities.contains(name)) {
            throw new IllegalArgumentException("적절하지 않은 메뉴 이름입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
