package com.camping.camping.repositories;

import com.camping.camping.domains.CartItem;
import com.camping.camping.dtos.GetCartItemByCartItemIdDto;
import com.camping.camping.dtos.GetCartItemsDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;


    @Test
    void findByIdTest() {

        Long id = 8L;

        Optional<CartItem> cartItem = cartItemRepository.findById(id);

        assertThat(cartItem).isNotNull();
    }

    @Test
    void findByProductSecondOption_IdTest() {

        Long id = 9L;

        List<CartItem> res = cartItemRepository.findByProductSecondOption_Id(id);

        assertThat(res).asList();
    }

    @Test
    void findByProductFirstOption_IdTest() {

        Long id = 7L;

        List<CartItem> res = cartItemRepository.findByProductFirstOption_Id(id);

        assertThat(res).asList();
    }

    @Test
    void findByProduct_Id() {

        Long id = 5L;

        List<CartItem> res = cartItemRepository.findByProduct_Id(id);

        assertThat(res).asList();
    }

    @Test
    void findByCartId_IdTest() {

        Long id = 1L;

        List<GetCartItemsDto> res = cartItemRepository.findByCartId(id);

        assertThat(res).asList();
    }

    @Test
    void findByCartItemIdTest() {

        Long id = 8L;

        GetCartItemByCartItemIdDto res = cartItemRepository.findByCartItemId(id);

        assertThat(res.getProductId()).isNotNull();
    }

    @Test
    void findByCartIdProductIdProductFirstOptionIdProductSecondOptionIdTest() {

        Long cartId = 1L;
        Long productId = 1L;
        Long productFirstOptionId = 1L;
        Long productSecondOptionId = 1L;
        CartItem res = cartItemRepository
                .findByCartIdProductIdProductFirstOptionIdProductSecondOptionId(
                        cartId,
                        productId,
                        productFirstOptionId,
                        productSecondOptionId
                );

        assertThat(res.id()).isNotNull();
    }

}