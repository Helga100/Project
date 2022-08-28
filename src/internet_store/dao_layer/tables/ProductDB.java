package internet_store.dao_layer.tables;

import internet_store.dao_layer.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDB {
    ArrayList<Product> dbProducts;

    public ProductDB() {
        this.dbProducts = new ArrayList<>();
        init();
    }

    public void init() {
        dbProducts.add(new Product("Jacket", "M", "Blue", "boy", 10, "OUTWEAR", 1));
        dbProducts.add(new Product("Coat", "M", "Black", "boy", 9, "OUTWEAR", 2));
        dbProducts.add(new Product("Trousers", "S", "White", "boy", 10, "TROUSERS", 3));
        dbProducts.add(new Product("Trousers", "M", "Brown", "boy", 7, "TROUSERS", 4));
        dbProducts.add(new Product("Shirt", "M", "White", "boy", 9, "SHIRTS", 5));
        dbProducts.add(new Product("Shirt", "S", "Blue", "boy", 10, "SHIRTS", 6));
        dbProducts.add(new Product("Shirt", "S", "Green", "boy", 20, "SHIRTS", 7));
        dbProducts.add(new Product("Suit", "S", "Blue", "boy", 10, "SUITS", 8));
        dbProducts.add(new Product("Suit", "L", "Brown", "boy", 7, "SUITS", 9));
        dbProducts.add(new Product("Shoes", "40", "Brown", "boy", 12, "SHOES", 10));
        dbProducts.add(new Product("Shoes", "36", "Grey", "boy", 7, "SHOES", 11));
        dbProducts.add(new Product("Dress", "S", "yellow", "girl", 5, "DRESSES", 12));
        dbProducts.add(new Product("Dress", "L", "Blue", "girl", 10, "DRESSES", 13));
        dbProducts.add(new Product("Coat", "S", "Blue", "girl", 12, "OUTWEAR", 14));
        dbProducts.add(new Product("Jacket", "M", "Grey", "girl", 9, "OUTWEAR", 15));
        dbProducts.add(new Product("Jacket", "L", "Black", "girl", 15, "OUTWEAR", 16));
        dbProducts.add(new Product("Trousers", "S", "Black", "girl", 12, "TROUSERS", 17));
        dbProducts.add(new Product("Trousers", "L", "White", "girl", 8, "TROUSERS", 18));
        dbProducts.add(new Product("Blouse", "S", "White", "girl", 10, "BLOUSES", 19));
        dbProducts.add(new Product("Blouse", "M", "Yellow", "girl", 7, "BLOUSES", 20));
        dbProducts.add(new Product("Suits", "L", "Green", "girl", 9, "SUITS", 21));
        dbProducts.add(new Product("Suits", "S", "White", "girl", 14, "SUITS", 22));
        dbProducts.add(new Product("Shoes", "37", "Black", "girl", 10, "SHOES", 23));
        dbProducts.add(new Product("Shoes", "39", "Blue", "girl", 14, "SHOES", 24));
        dbProducts.add(new Product("Skirt", "M", "Blue", "girl", 9, "SKIRTS", 25));
        dbProducts.add(new Product("Skirt", "S", "Black", "girl", 12, "SKIRTS", 26));
    }


    public ArrayList<Product> getProductsByCategoryAndSex(String categoryFromScanner, String sexFromConcole) {
        final List<Product> listOfProcustsByCategoryAndSex = dbProducts.stream()
                .filter(it -> it.getCategory().equals(categoryFromScanner) && it.getSex().equals(sexFromConcole))
                .collect(Collectors.toList());
        return (ArrayList<Product>) listOfProcustsByCategoryAndSex;

    }

    public ArrayList<Product> getProductsBySex(String sexFromScanner) {
        final ArrayList<Product> listOfProductBySex = (ArrayList<Product>) dbProducts.stream().
                filter(currentProduct -> currentProduct.getSex().equals(sexFromScanner))
                .collect(Collectors.toList());
        return listOfProductBySex;

    }



    public ArrayList<Product> getDbProducts() {
        return dbProducts;
    }

    public void addNewProductFromConcole(String newProductName, String newProductSize, String newProductColor,
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

    public void setProductColor(String idProductFromConcole, String newColorFromConcole) {
        dbProducts.stream()
                .filter(it -> it.getId() == Integer.parseInt(idProductFromConcole))
                .forEach(it -> it.setColor(newColorFromConcole));
    }

}
