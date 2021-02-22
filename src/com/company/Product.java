package com.company;

public class Product implements Comparable<Product>{
    public static int ctr;
    private final int ID;
    private String description;
    private double price;

    public Product() {
        ID = ++ctr;
    }

    public Product(String description, double price) {
        this.ID = ++ctr;
        this.description = description;
        this.price = price;
    }

    public Product(Product p){
        ID = p.ID;
        description = p.description;
        price = p.price;
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" +
                "ID=" + ID +
                ",description='" + description + '\'' +
                ", price=" + price +
                ']';
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(price, o.price);
    }
}
