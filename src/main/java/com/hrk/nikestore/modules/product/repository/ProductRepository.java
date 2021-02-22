package com.hrk.nikestore.modules.product.repository;

import com.hrk.nikestore.modules.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p order by p.id desc ")
    List<Product> findProductsByLatest();

    @Query("select p from Product p order by p.discount desc ")
    List<Product> findProductsByPopular();

    @Query("select p from Product p order by p.price desc ")
    List<Product> findProductsByHighestPrice();

    @Query("select p from Product p order by p.price asc ")
    List<Product> findProductsByLowestPrice();

    @Query("select p from Product p where p.title like %:title% ")
    List<Product> findAllByTitle(String title);

    Optional<Product> findById(Long productId);

    Product getById(Long id);


}
