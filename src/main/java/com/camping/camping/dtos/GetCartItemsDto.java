package com.camping.camping.dtos;


import com.camping.camping.domains.vo.FirstOptionName;
import com.camping.camping.domains.vo.Money;
import com.camping.camping.domains.vo.Name;
import com.camping.camping.domains.vo.SecondOptionName;
import com.querydsl.core.annotations.QueryProjection;

public class GetCartItemsDto {

    private Long cartItemId;
    private Integer quantity;
    private Long productId;
    private Name name;
    private Money price;
    private Long productFirstOptionId;
    private FirstOptionName productFirstOptionName;
    private Money productFirstAddPrice;
    private Long productSecondOptionId;
    private SecondOptionName productSecondOptionName;
    private Money productSecondPrice;

    @QueryProjection
    public GetCartItemsDto(Long cartItemId, Integer quantity, Long productId, Name name, Money price, Long productFirstOptionId, FirstOptionName productFirstOptionName, Money productFirstAddPrice, Long productSecondOptionId, SecondOptionName productSecondOptionName, Money productSecondPrice) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productFirstOptionId = productFirstOptionId;
        this.productFirstOptionName = productFirstOptionName;
        this.productFirstAddPrice = productFirstAddPrice;
        this.productSecondOptionId = productSecondOptionId;
        this.productSecondOptionName = productSecondOptionName;
        this.productSecondPrice = productSecondPrice;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Long getProductFirstOptionId() {
        return productFirstOptionId;
    }

    public void setProductFirstOptionId(Long productFirstOptionId) {
        this.productFirstOptionId = productFirstOptionId;
    }

    public FirstOptionName getProductFirstOptionName() {
        return productFirstOptionName;
    }

    public void setProductFirstOptionName(FirstOptionName productFirstOptionName) {
        this.productFirstOptionName = productFirstOptionName;
    }

    public Money getProductFirstAddPrice() {
        return productFirstAddPrice;
    }

    public void setProductFirstAddPrice(Money productFirstAddPrice) {
        this.productFirstAddPrice = productFirstAddPrice;
    }

    public Long getProductSecondOptionId() {
        return productSecondOptionId;
    }

    public void setProductSecondOptionId(Long productSecondOptionId) {
        this.productSecondOptionId = productSecondOptionId;
    }

    public SecondOptionName getProductSecondOptionName() {
        return productSecondOptionName;
    }

    public void setProductSecondOptionName(SecondOptionName productSecondOptionName) {
        this.productSecondOptionName = productSecondOptionName;
    }

    public Money getProductSecondPrice() {
        return productSecondPrice;
    }

    public void setProductSecondPrice(Money productSecondPrice) {
        this.productSecondPrice = productSecondPrice;
    }
}
