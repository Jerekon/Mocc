package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    @Test
    public void testLocaleRussia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        GeoService geoService = new GeoServiceImpl();
        Country country = geoService.byIp("172.").getCountry();

        String actual = localizationService.locale(country);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testLocaleOther() {
        LocalizationService localizationService = new LocalizationServiceImpl();

        String actual = localizationService.locale(Country.GERMANY);
        String expected = "Welcome";
        Assertions.assertEquals(actual, expected);
    }
}