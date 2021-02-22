package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductForm extends JFrame {
    ListOfProducts listOfProducts;
    JFrame f;
    JLabel des, pri, aver, prod;
    JButton add, sort, show, av;
    JTextField ds, pr;

    public ProductForm(){
        super("Product Management");
        f = new JFrame("Product Management");
        listOfProducts = new ListOfProducts();
        
        Font font = new Font("Arial", Font.PLAIN, 15);
        
        des = new JLabel("Description:");
        des.setFont(font);
        des.setBounds(10, 10, 100,30);

        pri = new JLabel("Price:");
        pri.setFont(font);
        pri.setBounds(10, 30, 100,30);

        ds = new JTextField();
        ds.setBounds(100, 10, 100, 20);

        pr = new JTextField();
        pr.setBounds(100, 35, 100, 20);

        aver = new JLabel("");
        aver.setFont(font);
        aver.setBounds(500, 60, 200, 20);

        AddHandler addHandler = new AddHandler();
        add = new JButton("Add to List");
        add.setFont(font);
        add.setBounds(30, 70, 120, 20);
        add.addActionListener(addHandler);

        SortHandler sortHandler = new SortHandler();
        sort = new JButton("Sort Products");
        sort.setFont(font);
        sort.setBounds(250, 10, 200, 20);
        sort.addActionListener(sortHandler);

        ShowHandler showHandler = new ShowHandler();
        show = new JButton("Show Products");
        show.setFont(font);
        show.setBounds(250, 35, 200, 20);
        show.addActionListener(showHandler);

        AvHandler avHandler = new AvHandler();
        av = new JButton("Average Price");
        av.setFont(font);
        av.setBounds(250, 60, 200, 20);
        av.addActionListener(avHandler);

        prod = new JLabel("");
        prod.setFont(font);
        prod.setBounds(250, 100, 500, 300);
        {
            f.add(prod);
            f.add(aver);
            f.add(sort);
            f.add(show);
            f.add(av);
            f.add(add);
            f.add(ds);
            f.add(pr);
            f.add(des);
            f.add(pri);
            f.setSize(800, 600);
            f.setLocationRelativeTo(null);
            f.setLayout(null);
            f.setVisible(true);
        }
    }

    private class ShowHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder s = new StringBuilder("<html>");
            String[] ss = listOfProducts.toArray();
            if(ss.length == 0) return;

            s.append(ss[0]);
            for(int i=1;i<ss.length; ++i){
                s.append("<br>").append(ss[i]);
            }
            prod.setText(s.toString());
        }
    }

    private class AvHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            aver.setText(String.format("Average price: %.3f", listOfProducts.averagePrice()));
        }
    }

    private class SortHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            listOfProducts.sortByPrice();
        }
    }

    private class AddHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            listOfProducts.add(new Product(ds.getText(), Double.parseDouble(pr.getText())));
            ds.setText("");
            pr.setText("");
        }
    }
}
