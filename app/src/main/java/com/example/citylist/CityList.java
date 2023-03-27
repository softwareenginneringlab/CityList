package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }


    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int ck) {
        List<City> cityList = cities;
        if(ck==0)
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList,new CustomComparator());
        }
        return cityList;
    }
    public void delete(City city)
    {
        if(!cities.contains(city))
        {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }
    public int count()
    {
        return cities.size();
    }
}

