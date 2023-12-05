package com.camping.camping.repositories;

import com.camping.camping.dtos.FindProductFirstOptionDto;
import com.camping.camping.dtos.FindProductSecondOptionDto;
import com.camping.camping.dtos.ProductImageDto;
import com.camping.camping.dtos.QFindProductFirstOptionDto;
import com.camping.camping.dtos.QFindProductSecondOptionDto;
import com.camping.camping.dtos.QProductImageDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.camping.camping.domains.QProductImage.productImage;
import static com.camping.camping.domains.QProductFirstOption.productFirstOption;
import static com.camping.camping.domains.QProductSecondOption.productSecondOption;

public class ProductRepositoryImpl implements ProductRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductImageDto> findProductImages(Long productId) {

        List<ProductImageDto> contents = queryFactory
                .select(new QProductImageDto(productImage.id, productImage.url))
                .from(productImage)
                .where(productImage.product.id.eq(productId))
                .fetch();

        return contents;
    }

    @Override
    public List<FindProductFirstOptionDto> findProductFirstOptions(Long productId) {

        List<FindProductFirstOptionDto> cotents = queryFactory
                .select(new QFindProductFirstOptionDto(
                        productFirstOption.id,
                        productFirstOption.name,
                        productFirstOption.addPrice))
                .from(productFirstOption)
                .where(productFirstOption.product.id.eq(productId))
                .fetch();

        return cotents;
    }

    @Override
    public List<FindProductSecondOptionDto> findProductSecondOptions(Long ProductFirstOptionId) {

        List<FindProductSecondOptionDto> cotents = queryFactory
                .select(new QFindProductSecondOptionDto(
                        productSecondOption.id,
                        productSecondOption.name,
                        productSecondOption.addPrice))
                .from(productSecondOption)
                .where(productSecondOption.productFirstOption.id.eq(ProductFirstOptionId))
                .fetch();

        return cotents;
    }
}
