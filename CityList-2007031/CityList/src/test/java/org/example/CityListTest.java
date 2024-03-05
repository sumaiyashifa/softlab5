package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CityManagerTest {
    City city1 = new City("Dhaka", "Bangladesh");
    City city2 = new City("Paris", "France");
    City city3 = new City("Washington, D.C.", "USA");

    @Test
    public void testDeleteCity() {
        CityList cityManager = new CityList();
        cityManager.addCity(city1);
        cityManager.addCity(city2);
        cityManager.addCity(city3);

        cityManager.deleteCity(city1);

        List<City> cityList = cityManager.getSortedCities(CityList.SortingCriteria.BY_PROVINCE);
        assertFalse(cityList.contains(city1));
    }

    @Test
    public void testDeleteCityException() {
        CityList cityManager = new CityList();
        cityManager.addCity(city1);
        cityManager.addCity(city2);
        cityManager.addCity(city3);

        cityManager.deleteCity(city1);

        assertThrows(IllegalArgumentException.class, () -> cityManager.deleteCity(city1));
    }

    @Test
    public void testCityCount() {
        CityList cityManager = new CityList();
        cityManager.addCity(city1);
        cityManager.addCity(city2);
        assertEquals(2, cityManager.getCityCount());
    }

    @Test
    public void testSortCities() {
        CityList cityManager = new CityList();
        cityManager.addCity(city1);
        cityManager.addCity(city2);
        cityManager.addCity(city3);

        List<City> sortedCities = cityManager.getSortedCities(CityList.SortingCriteria.BY_PROVINCE);
        int n = sortedCities.size();
        for (int i = 0; i < n - 1; i++) {
            assertTrue(sortedCities.get(i).getProvinceName().compareTo(sortedCities.get(i + 1).getProvinceName()) <= 0);
        }
    }

    @Test
    public void testGetCitiesByCityName() {
        CityList cityList = new CityList();
        City city1 = new City("Dhaka", "Bangladesh");
        City city2 = new City("Paris", "France");
        City city3 = new City("Washington, D.C.", "USA");

        cityList.addCity(city1);
        cityList.addCity(city2);
        cityList.addCity(city3);

        List<City> sortedCities = cityList.getSortedCities(CityList.SortingCriteria.BY_CITY);

        assertEquals("Dhaka", sortedCities.get(0).getCityName());
        assertEquals("Paris", sortedCities.get(1).getCityName());
        assertEquals("Washington, D.C.", sortedCities.get(2).getCityName());
    }

    @Test
    public void testGetCitiesByStateName() {
        CityList cityList = new CityList();
        City city1 = new City("Dhaka", "Bangladesh");
        City city2 = new City("Paris", "France");
        City city3 = new City("Washington, D.C.", "USA");

        cityList.addCity(city1);
        cityList.addCity(city2);
        cityList.addCity(city3);

        List<City> sortedCities = cityList.getSortedCities(CityList.SortingCriteria.BY_PROVINCE);

        assertEquals("Bangladesh", sortedCities.get(0).getProvinceName());
        assertEquals("France", sortedCities.get(1).getProvinceName());
        assertEquals("USA", sortedCities.get(2).getProvinceName());
    }

}
