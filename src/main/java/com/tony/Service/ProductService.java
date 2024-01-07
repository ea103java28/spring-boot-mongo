package com.tony.Service;

import com.tony.dto.ProductQueryParams;
import com.tony.exception.NotFoundException;
import com.tony.model.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product request);
    public Product getProduct(String id) throws NotFoundException;
    public Product replaceProduct(String id, Product request);
    public void deleteProduct(String id);
    public List<Product> getProducts(ProductQueryParams productQueryParams);

}
