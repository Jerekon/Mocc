package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    @Test
    public void testbyIpRussia() {
        GeoService geoService = new GeoServiceImpl();

        Country actual = geoService.byIp("172.0.32.11").getCountry();
        Country expected = new Location(null, Country.RUSSIA, null, 0).getCountry();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testbyIpUSA() {
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp("96.44.183.149");

        String actual = location.getCity();
        String expected = new Location("New York", null, null, 0).getCity();
        Assertions.assertEquals(actual, expected);
    }
}