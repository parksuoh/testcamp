package com.camping.camping.repositories;

import com.camping.camping.domains.CartItem;
import com.camping.camping.dtos.GetCartItemByCartItemIdDto;
import com.camping.camping.dtos.GetCartItemsDto;
import com.camping.camping.dtos.QGetCartItemByCartItemIdDto;
import com.camping.camping.dtos.QGetCartItemsDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.camping.camping.domains.QCartItem.cartItem;
import static com.camping.camping.domains.QCart.cart;
import static com.camping.camping.domains.QProduct.product;
import static com.camping.camping.domains.QProductFirstOption.productFirstOption;
import static com.camping.camping.domains.QProductSecondOption.productSecondOption;

public class CartItemRepositoryImpl implements CartItemRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public CartItemRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public CartItem findByCartIdProductIdProductFirstOptionIdProductSecondOptionId(
            Long CartId,
            Long ProductId,
            Long ProductFirstOptionId,
            Long ProductSecondOptionId) {

        return queryFactory
                .selectFrom(cartItem)
                .where(
                        cartItem.cart.id.eq(CartId),
                        cartItem.product.id.eq(ProductId),
                        cartItem.productFirstOption.id.eq(ProductFirstOptionId),
                        cartItem.productSecondOption.id.eq(ProductSecondOptionId)
                )
                .fetchOne();

    }

    @Override
    public List<GetCartItemsDto> findByCartId(Long cartId) {

        return queryFactory
                .select(new QGetCartItemsDto(
                        cartItem.id,
                        cartItem.quantity,
                        product.id,
                        product.name,
                        product.price,
                        productFirstOption.id,
                        productFirstOption.name,
                        productFirstOption.addPrice,
                        productSecondOption.id,
                        productSecondOption.name,
                        productSecondOption.addPrice
                ))
                .from(cartItem)
                .innerJoin(cartItem.product, product)
                .innerJoin(cartItem.productFirstOption, productFirstOption)
                .innerJoin(cartItem.productSecondOption, productSecondOption)
                .where(cartItem.cart.id.eq(cartId))
                .fetch();

    }

    @Override
    public GetCartItemByCartItemIdDto findByCartItemId(Long cartItemId) {

        return queryFactory.
                select(new QGetCartItemByCartItemIdDto(
                        product,
                        product.id,
                        product.name,
                        product.price,
                        productFirstOption,
                        productFirstOption.id,
                        productFirstOption.name,
                        productFirstOption.addPrice,
                        productSecondOption,
                        productSecondOption.id,
                        productSecondOption.name,
                        productSecondOption.addPrice,
                        cartItem.quantity
                ))
                .from(cartItem)
                .innerJoin(cartItem.product, product)
                .on(cartItem.id.eq(cartItemId))
                .innerJoin(cartItem.productFirstOption, productFirstOption)
                .innerJoin(cartItem.productSecondOption, productSecondOption)
                .fetchOne();


    }
}
