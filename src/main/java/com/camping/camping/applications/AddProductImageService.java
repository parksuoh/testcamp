package com.camping.camping.applications;


import com.camping.camping.aws.S3UploadService;
import com.camping.camping.domains.Product;
import com.camping.camping.domains.ProductImage;
import com.camping.camping.exceptions.ProductNotExist;
import com.camping.camping.repositories.ProductImageRepository;
import com.camping.camping.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
public class AddProductImageService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    private final S3UploadService s3UploadService;

    public AddProductImageService(ProductRepository productRepository, ProductImageRepository productImageRepository, S3UploadService s3UploadService) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.s3UploadService = s3UploadService;
    }

    public String addProductImageService(Long productId, MultipartFile image) throws IOException {

        Product product = productRepository
                .findById(productId)
                .orElseThrow(ProductNotExist::new);

        String url = s3UploadService.saveFile(image);

        ProductImage productImage = new ProductImage(product, url);

        productImageRepository.save(productImage);

        return "success";
    }
}
