package com.netflix;

import javax.naming.Name;
import java.util.ArrayList;
public class Cats {
        String name; // define the name field

        public static void main(String[] args) {
            ArrayList<Cats> allCats = new ArrayList<>();
            Cats c1 = new Cats();
            c1.name = "Bubbles";
            allCats.add(c1);

            System.out.println(allCats.get(0).name);
        }
    }



//    String name;
//
//        ArrayList<Cats> allCats = new ArrayList<>();
//        Cats c1 = new Cats();
//        c1.name ="Bubbles";
//allCats.add(c1)
