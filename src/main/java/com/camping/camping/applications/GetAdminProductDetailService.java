package com.camping.camping.applications;

import com.camping.camping.domains.Product;
import com.camping.camping.dtos.FindProductFirstOptionDto;
import com.camping.camping.dtos.FindProductSecondOptionDto;
import com.camping.camping.dtos.GetProductDetailDto;
import com.camping.camping.dtos.GetProductFitstOptionDto;
import com.camping.camping.dtos.GetProductSecondOptionDto;
import com.camping.camping.dtos.ProductImageDto;
import com.camping.camping.exceptions.ProductNotExist;
import com.camping.camping.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GetAdminProductDetailService {
    private final ProductRepository productRepository;

    public GetAdminProductDetailService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public GetProductDetailDto getProductDetail(Long productId){

        Product product = productRepository
                .findById(productId)
                .orElseThrow(ProductNotExist::new);

        List<ProductImageDto> productImages = productRepository.findProductImages(productId);


        return new GetProductDetailDto(
                product.id(),
                product.name().toString(),
                product.price().asLong(),
                product.description().toString(),
                productImages,
                firstOptionToDto(product.id()));
    }

    private List<GetProductSecondOptionDto> secondOptionToDto(Long firstOptionId) {
        List<FindProductSecondOptionDto> productSecondOptions = productRepository.findProductSecondOptions(firstOptionId);

        return productSecondOptions
                .stream()
                .map(secondOption ->
                new GetProductSecondOptionDto(
                        secondOption.getId(),
                        secondOption.getName().toString(),
                        secondOption.getAddPrice().asLong())).toList();
    }

    private List<GetProductFitstOptionDto> firstOptionToDto(Long productId) {
        List<FindProductFirstOptionDto> productFirstOptions = productRepository.findProductFirstOptions(productId);

        return productFirstOptions
                .stream()
                .map(firstOption -> {
                    Long id = firstOption.getId();
                    return new GetProductFitstOptionDto(
                            id,
                            firstOption.getName().toString(),
                            firstOption.getAddPrice().asLong(),
                            secondOptionToDto(id));})
                .toList();
    }

}
