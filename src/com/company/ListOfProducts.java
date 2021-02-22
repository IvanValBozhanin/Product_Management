package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class ListOfProducts {
    private ArrayList<Product> products = new ArrayList<>();

    public void add(Product product){
        products.add(product);
    }

    public void sortByPrice(){
        Collections.sort(products, Collections.reverseOrder());
    }

    @Override
    public String toString(){
        int n = products.size();
        StringBuilder s = new StringBuilder();
        s.append(products.get(0).toString());
        for(int i=1;i<n;++i){
            s.append(", ");
            s.append(products.get(i).toString());
        }
        return s.toString();
    }

    public double averagePrice(){
        double d = 0.0;
        int n = products.size();
        for (Product product : products) {
            d += product.getPrice();
        }
        return d/n;
    }

    public String[] toArray(){
        int n = products.size();
        String[] s = new String[n];
        for(int i=0;i<n;++i){
            s[i] = products.get(i).toString();
        }
        return s;
    }
}
