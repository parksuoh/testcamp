package com.camping.camping.repositories;

import com.camping.camping.domains.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository  extends JpaRepository<CartItem, Long>, CartItemRepositoryCustom {

    Optional<CartItem> findById(Long id);

    List<CartItem> findByProductSecondOption_Id(Long productSecondOptionId);
    List<CartItem> findByProductFirstOption_Id(Long productFirstOptionId);
    List<CartItem> findByProduct_Id(Long productId);

}
