package com.camping.camping.repositories;

import com.camping.camping.domains.CartItem;
import com.camping.camping.dtos.GetCartItemByCartItemIdDto;
import com.camping.camping.dtos.GetCartItemsDto;

import java.util.List;

public interface CartItemRepositoryCustom {
    CartItem findByCartIdProductIdProductFirstOptionIdProductSecondOptionId(
            Long CartId,
            Long ProductId,
            Long ProductFirstOptionId,
            Long ProductSecondOptionId
    );

    List<GetCartItemsDto> findByCartId(Long cartId);

    GetCartItemByCartItemIdDto findByCartItemId(Long cartItemId);

}
