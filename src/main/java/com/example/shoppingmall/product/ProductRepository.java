package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> product_table
            = new HashMap<>();

    int id = 0; // DB의 auto_increment

    public Product save(Product product) {
        product.setId(id++);

        product_table.put(product.getId(), product);
        System.out.println(
                "/products : repository - " + product_table.get(id-1));
        return product_table.get(id-1);
    }

    public Product findProduct(int id) {
        return product_table.get(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        // Map -> Stram -> List
        // limit, currentPage => 상품 id 범위
        // limit4 / curPage 1 => 0~3
        // limit4 / curPage 2 => 4~7
        return product_table.values().stream().toList();
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        List<Product> resultProducts = new ArrayList<>();

        for(Product product : product_table.values()){
            if(product.getCategoryId() == categoryId){
                resultProducts.add(product);
            }
        }

        return resultProducts;
    }

    public boolean deleteProduct(int id) {
        product_table.remove(id);
        if(product_table.get(id)==null)
            return true;
        else
            return false;
    }

    public void deleteProducts(List<Integer> productIds) {
        for(int idx = 0; idx < productIds.size(); idx++){
            product_table.remove(productIds.get(idx));
        }
    }
}
