package com.tony.Service.impl;


import com.tony.Service.ProductService;
import com.tony.constant.SortRule;
import com.tony.dto.ProductQueryParams;
import com.tony.exception.NotFoundException;
import com.tony.model.Product;
import com.tony.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    public Product getProduct(String id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find product."));
    }

    public Product createProduct(Product request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return repository.insert(product);
    }

    public Product replaceProduct(String id, Product request) {
        Product oldProduct = getProduct(id);

        Product product = new Product();
        product.setId(oldProduct.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return repository.save(product);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

    public List<Product> getProducts(ProductQueryParams productQueryParams) {

        String keyword = Optional.ofNullable(productQueryParams.getKeyword()).orElse("");
        int priceFrom = Optional.ofNullable(productQueryParams.getPriceFrom()).orElse(0);
        int priceTo = Optional.ofNullable(productQueryParams.getPriceTo()).orElse(Integer.MAX_VALUE);

        Sort sort = genSortingStrategy(productQueryParams.getOrderBy(), productQueryParams.getSortRule());

        return repository.findByPriceBetweenAndNameLikeIgnoreCase(priceFrom, priceTo, keyword, sort);
    }

    private Sort genSortingStrategy(String orderBy, SortRule sortRule) {
        Sort sort = Sort.unsorted();
        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
            Sort.Direction direction = Sort.Direction.fromString(String.valueOf(sortRule));
            sort = Sort.by(direction, orderBy);
        }

        return sort;
    }

}
