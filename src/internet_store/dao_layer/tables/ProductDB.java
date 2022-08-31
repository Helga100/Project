package internet_store.dao_layer.tables;

import internet_store.dao_layer.models.Color;
import internet_store.dao_layer.models.Product;
import internet_store.dao_layer.models.ProductSize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDB {
    private ArrayList<Product> dbProducts = new ArrayList<>();;

    public ProductDB() {
        init();
    }

    public void init() {
        dbProducts.add(new Product("Jacket", ProductSize.M, Color.BLUE, "boy", 10, "OUTWEAR", 1));
        dbProducts.add(new Product("Coat", ProductSize.M, Color.BLACK, "boy", 9, "OUTWEAR", 2));
        dbProducts.add(new Product("Trousers", ProductSize.S, Color.WHITE, "boy", 10, "TROUSERS", 3));
        dbProducts.add(new Product("Trousers", ProductSize.M, Color.BROWN, "boy", 7, "TROUSERS", 4));
        dbProducts.add(new Product("Shirt", ProductSize.M, Color.WHITE, "boy", 9, "SHIRTS", 5));
        dbProducts.add(new Product("Shirt", ProductSize.S, Color.BLUE, "boy", 10, "SHIRTS", 6));
        dbProducts.add(new Product("Shirt", ProductSize.S, Color.GREEN, "boy", 20, "SHIRTS", 7));
        dbProducts.add(new Product("Suit", ProductSize.S, Color.BLUE, "boy", 10, "SUITS", 8));
        dbProducts.add(new Product("Suit", ProductSize.L, Color.BROWN, "boy", 7, "SUITS", 9));
        dbProducts.add(new Product("Shoes", ProductSize.s40, Color.BROWN, "boy", 12, "SHOES", 10));
        dbProducts.add(new Product("Shoes", ProductSize.s36, Color.GREY, "boy", 7, "SHOES", 11));
        dbProducts.add(new Product("Dress", ProductSize.S, Color.YELLOW, "girl", 5, "DRESSES", 12));
        dbProducts.add(new Product("Dress", ProductSize.L, Color.BLUE, "girl", 10, "DRESSES", 13));
        dbProducts.add(new Product("Coat", ProductSize.S, Color.BLUE, "girl", 12, "OUTWEAR", 14));
        dbProducts.add(new Product("Jacket", ProductSize.M, Color.GREY, "girl", 9, "OUTWEAR", 15));
        dbProducts.add(new Product("Jacket", ProductSize.L, Color.BLACK, "girl", 15, "OUTWEAR", 16));
        dbProducts.add(new Product("Trousers", ProductSize.S, Color.BLACK, "girl", 12, "TROUSERS", 17));
        dbProducts.add(new Product("Trousers", ProductSize.L, Color.WHITE, "girl", 8, "TROUSERS", 18));
        dbProducts.add(new Product("Blouse", ProductSize.S, Color.WHITE, "girl", 10, "BLOUSES", 19));
        dbProducts.add(new Product("Blouse", ProductSize.M, Color.YELLOW, "girl", 7, "BLOUSES", 20));
        dbProducts.add(new Product("Suits", ProductSize.L, Color.GREEN, "girl", 9, "SUITS", 21));
        dbProducts.add(new Product("Suits", ProductSize.S, Color.WHITE, "girl", 14, "SUITS", 22));
        dbProducts.add(new Product("Shoes", ProductSize.s37, Color.BLACK, "girl", 10, "SHOES", 23));
        dbProducts.add(new Product("Shoes", ProductSize.s39, Color.BLUE, "girl", 14, "SHOES", 24));
        dbProducts.add(new Product("Skirt", ProductSize.M, Color.BLUE, "girl", 9, "SKIRTS", 25));
        dbProducts.add(new Product("Skirt", ProductSize.S, Color.BLACK, "girl", 12, "SKIRTS", 26));
    }


    public ArrayList<Product> getProductsByCategoryAndSex(String categoryFromScanner, String sexFromConcole) {
        return (ArrayList<Product>)  dbProducts.stream()
                .filter(it -> it.getCategory().equals(categoryFromScanner) && it.getSex().equals(sexFromConcole))
                .collect(Collectors.toList());

    }

    public ArrayList<Product> getProductsBySex(String sexFromScanner) {
        return (ArrayList<Product>) dbProducts.stream().
                filter(currentProduct -> currentProduct.getSex().equals(sexFromScanner))
                .collect(Collectors.toList());
    }



    public ArrayList<Product> getDbProducts() {
        return dbProducts;
    }
    
    public void addNewProductFromConcole(String newProductName, ProductSize newProductSize, Color newProductColor,
                                         String newProductSex, int age, String newProductCategory, int id) {
        dbProducts.add(new Product(newProductName, newProductSize, newProductColor, newProductSex, age,
                newProductCategory, id));
    }


    public Product getProductById(String idChoice) {
        return dbProducts.stream()
                .filter(it -> String.valueOf(it.getId()).equals(idChoice))
                .findFirst()
                .get();
    }

    public void setProductColor(String idProductFromConcole, Color newColorFromConcole) {
        dbProducts.stream()
                .filter(it -> it.getId() == Integer.parseInt(idProductFromConcole))
                .forEach(it -> it.setColor(newColorFromConcole));
    }

}
