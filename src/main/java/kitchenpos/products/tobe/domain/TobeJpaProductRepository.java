package kitchenpos.products.tobe.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TobeJpaProductRepository extends ProductRepository, JpaRepository<Product, UUID> {}
