package com.example.citylist;

import java.util.Comparator;

public class CustomComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getProvinceName().compareTo(o2.getProvinceName());
    }
}