package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class ProductManager implements IProductManager {

    @Autowired
    private List<Product> listInit;

//    static {
//        asList(
//                productList.add(new Product(1, "Samsung")),
//                productList.add(new Product(2, "Apple")),
//                productList.add(new Product(3, "Huawei")),
//                productList.add(new Product(4, "LG")),
//                productList.add(new Product(5, "Toshiba"))
//        );
//    }


//    private List<Product> productList = new ArrayList<>();
//
//    public ProductManager() {
//        productList.add(new Product(1, "Samsung"));
//        productList.add(new Product(2, "Apple"));
//        productList.add(new Product(3, "Huawei"));
//        productList.add(new Product(4, "LG"));
//        productList.add(new Product(5, "Toshiba"));
//    }

    @Override
    public void add(Product product) {
        listInit.add(product);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < listInit.size(); i++) {
            if (listInit.get(i).getId() == product.getId()){
                listInit.set(i,product);
            }
        }
    }

    @Override
    public void delete(Product product) {
        for (int i = 0; i < listInit.size(); i++) {
            if (listInit.get(i).getId() == product.getId()){
                listInit.remove(i);
            }
        }
    }

    @Override
    public Product get(int id) {
        Product product = new Product();
        for (int i = 0; i < listInit.size(); i++) {
            if (listInit.get(i).getId() == id){
                product = listInit.get(i);
            }
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        return listInit;
    }
}
