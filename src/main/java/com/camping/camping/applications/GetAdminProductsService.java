package com.camping.camping.applications;

import com.camping.camping.domains.Product;
import com.camping.camping.dtos.GetProductByCategoryDto;
import com.camping.camping.dtos.ProductImageDto;
import com.camping.camping.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GetAdminProductsService {

    private final ProductRepository productRepository;

    public GetAdminProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<GetProductByCategoryDto> getAdminProducts() {

        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .map(product -> {
                    List<ProductImageDto> productImages = productRepository.findProductImages(product.id());
                    return new GetProductByCategoryDto(
                            product.id(),
                            product.name().toString(),
                            product.price().asLong(),
                            productImages
                    );
                })
                .toList();
    }
}
