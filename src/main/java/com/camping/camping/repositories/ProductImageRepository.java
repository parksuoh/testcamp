package com.camping.camping.repositories;

import com.camping.camping.domains.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long>{

    List<ProductImage> findByProduct_Id(Long productId);

}
