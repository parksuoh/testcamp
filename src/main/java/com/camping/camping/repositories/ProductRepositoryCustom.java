package com.camping.camping.repositories;

import com.camping.camping.domains.ProductFirstOption;
import com.camping.camping.domains.ProductSecondOption;
import com.camping.camping.dtos.FindProductFirstOptionDto;
import com.camping.camping.dtos.FindProductSecondOptionDto;
import com.camping.camping.dtos.GetProductByCategoryDto;
import com.camping.camping.dtos.ProductImageDto;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ProductImageDto> findProductImages(Long productId);
    List<FindProductFirstOptionDto> findProductFirstOptions(Long productId);
    List<FindProductSecondOptionDto> findProductSecondOptions(Long ProductFirstOptionId);
}
