package internet_store.dao_layer.models;

public class Product {
    private String name;
    private ProductSize size;
    private Color color;
    private String sex;
    private int age;
    private String category;
    private int id;

    public Product(String name, ProductSize size, Color color, String sex, int age, String cp, int id) {
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


    public void setColor(Color color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

}
