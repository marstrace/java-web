package top.top234.bean;

import java.util.Objects;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/10 9:51.
 *
 * ********************************
 *
 * @author top234
 */
public class Book {
    private int id;
    private String name;
    private double price;
    private String publish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publish='" + publish + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(int id, String name, double price, String publish) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.publish = publish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name) &&
                Objects.equals(price, book.price) &&
                Objects.equals(publish, book.publish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, publish);
    }

}
