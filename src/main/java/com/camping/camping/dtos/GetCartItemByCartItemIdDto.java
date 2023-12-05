package com.camping.camping.dtos;

import com.camping.camping.domains.Product;
import com.camping.camping.domains.ProductFirstOption;
import com.camping.camping.domains.ProductSecondOption;
import com.camping.camping.domains.vo.FirstOptionName;
import com.camping.camping.domains.vo.Money;
import com.camping.camping.domains.vo.Name;
import com.camping.camping.domains.vo.SecondOptionName;
import com.querydsl.core.annotations.QueryProjection;

public class GetCartItemByCartItemIdDto {

    private Product product;
    private Long productId;
    private Name productName;
    private Money productPirce;

    private ProductFirstOption productFirstOption;
    private Long productFirstOptionId;
    private FirstOptionName productFirstOptionName;
    private Money productFirstOptinPrice;

    private ProductSecondOption productSecondOption;
    private Long productSecondOptionId;
    private SecondOptionName productSecondOptionName;
    private Money productSecondOptinPrice;
    private Integer quantity;

    @QueryProjection
    public GetCartItemByCartItemIdDto(Product product, Long productId, Name productName, Money productPirce, ProductFirstOption productFirstOption, Long productFirstOptionId, FirstOptionName productFirstOptionName, Money productFirstOptinPrice, ProductSecondOption productSecondOption, Long productSecondOptionId, SecondOptionName productSecondOptionName, Money productSecondOptinPrice, Integer quantity) {
        this.product = product;
        this.productId = productId;
        this.productName = productName;
        this.productPirce = productPirce;
        this.productFirstOption = productFirstOption;
        this.productFirstOptionId = productFirstOptionId;
        this.productFirstOptionName = productFirstOptionName;
        this.productFirstOptinPrice = productFirstOptinPrice;
        this.productSecondOption = productSecondOption;
        this.productSecondOptionId = productSecondOptionId;
        this.productSecondOptionName = productSecondOptionName;
        this.productSecondOptinPrice = productSecondOptinPrice;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Name getProductName() {
        return productName;
    }

    public void setProductName(Name productName) {
        this.productName = productName;
    }

    public Money getProductPirce() {
        return productPirce;
    }

    public void setProductPirce(Money productPirce) {
        this.productPirce = productPirce;
    }

    public ProductFirstOption getProductFirstOption() {
        return productFirstOption;
    }

    public void setProductFirstOption(ProductFirstOption productFirstOption) {
        this.productFirstOption = productFirstOption;
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

    public Money getProductFirstOptinPrice() {
        return productFirstOptinPrice;
    }

    public void setProductFirstOptinPrice(Money productFirstOptinPrice) {
        this.productFirstOptinPrice = productFirstOptinPrice;
    }

    public ProductSecondOption getProductSecondOption() {
        return productSecondOption;
    }

    public void setProductSecondOption(ProductSecondOption productSecondOption) {
        this.productSecondOption = productSecondOption;
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

    public Money getProductSecondOptinPrice() {
        return productSecondOptinPrice;
    }

    public void setProductSecondOptinPrice(Money productSecondOptinPrice) {
        this.productSecondOptinPrice = productSecondOptinPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
