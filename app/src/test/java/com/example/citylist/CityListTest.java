package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());//cityList er size dekha hocche
        assertTrue(cityList.getCities(0).contains(city));//whether the city actually exits or not
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }

    @Test
    public void testDelete()
    {
        CityList cityList = new CityList();
        City city = new City("Jessore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertTrue(!cityList.getCities(0).contains(city));
    }
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = new City("Jessore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);//jehetu ei city already delete hoye gese sehetu ei exception ta dibe
        });
    }
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Jessore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2, cityList.count());//cityList er size dekha hocche
    }

}
