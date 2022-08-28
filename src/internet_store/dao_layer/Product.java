package internet_store.dao_layer;

public class Product {
    String name;
    String size;
    String color;
    String sex;
    int age;
    String category;
    int id;


    public Product(String name, String size, String color, String sex, int age, String cp, int id) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.sex = sex;
        this.age = age;
        this.category = cp;
        this.id = id;


    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", CategoriesProduct=" + category +
                ", id='" + id + '\'' +

                '}';
    }

    public Product() {


    }
}
