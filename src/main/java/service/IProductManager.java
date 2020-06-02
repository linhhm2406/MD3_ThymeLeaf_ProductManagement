package service;

import model.Product;

import java.util.List;

public interface IProductManager {
    void add (Product product);
    void update(Product product);
    void delete(Product product);
    Product get(int id);
    List<Product> getAll();
}
