package proekt.factory;

import proekt.cars.Camry;
import proekt.cars.Dyna;
import proekt.cars.Hiance;
import proekt.cars.Solara;
import proekt.cars.abstract_cars.CarModel;
import proekt.cars.car_components.*;

import java.math.BigDecimal;
/*
Конвейер
 */

public class AssemblyLine {
    public Country country;
    private static KppTypeEnum DYNA_KPP_DEFAULT = KppTypeEnum.MANUAL;
    private static KppTypeEnum HIANCE_KPP_DEFAULT = KppTypeEnum.MANUAL;
    private static KppTypeEnum SOLARA_KPP_DEFAULT = KppTypeEnum.ROBOT;
    private static KppTypeEnum CAMRY_KPP_DEFAULT = KppTypeEnum.AUTOMAT;
    private static Integer CAMRY_MAXSPEED = 250;
    private static Integer DYNA_MAXSPEED = 1900;
    private static Integer HIANCE_MAXSPEED = 180;
    private static Integer SOLARA_MAXSPEED = 230;
    private static Integer DYNA_MAX_CAPACITY = 1900;
    private static Integer HIANCE_MAX_CAPACITY = 2500;
    private static boolean CAMRY_CRUIZE_CONTROL = true;
    private static boolean SOLARA_ROOF_CLOSE = true;

    private Headlight headlight;
    private Electric electric;
    private Engine engine;
    private FuelTank fueltank;
    private Wheel[] weels;
    private Factory factory;

    // проверка совпадения стран фабрики и конвейера
    public void setFactory(Factory newfactory) throws CountryFactoryNotEqualException {
        if (newfactory.country != country) {
            throw new CountryFactoryNotEqualException("Страна фабрики компонент " + newfactory.country +
                    " не совпадает со страной сборочного конвейера " + country);
        }
        this.factory = newfactory;
    }

    public AssemblyLine(Country country) {
        this.country = country;
    }
    //создание авто Camry

    public Camry createCamry(String color, BigDecimal price) {
        createComponents(CarModel.CAMRY);
        Camry camry = new Camry(country, color, CAMRY_MAXSPEED, CAMRY_KPP_DEFAULT, false, weels,
                price, fueltank, engine, electric, headlight, CAMRY_CRUIZE_CONTROL);
        return camry;
    }

    //создание авто Dyna

    public Dyna createDyna(String color, BigDecimal price) {
        createComponents(CarModel.DYNA);

        Dyna dyna = new Dyna(country, color, DYNA_MAXSPEED, DYNA_KPP_DEFAULT, false, weels,
                price, fueltank, engine, electric, headlight, DYNA_MAX_CAPACITY);
        return dyna;
    }

    //создание авто Hiance

    public Hiance createHiance(String color, BigDecimal price) {
        createComponents(CarModel.HIANCE);
        Wheel spareweel = new Wheel(CarModel.HIANCE.getWheelDiskEnum());

        Hiance hiance = new Hiance(country, color, HIANCE_MAXSPEED, HIANCE_KPP_DEFAULT, false, weels,
                price, fueltank, engine, electric, headlight, HIANCE_MAX_CAPACITY, spareweel);
        return hiance;
    }

    //создание авто Solara

    public Solara createSolara(String color, BigDecimal price) {
        createComponents(CarModel.SOLARA);

        Solara solara = new Solara(country, color, SOLARA_MAXSPEED, SOLARA_KPP_DEFAULT, false, weels,
                price, fueltank, engine, electric, headlight, SOLARA_ROOF_CLOSE);
        return solara;
    }

    //создание основных компонент

    public void createComponents(CarModel carModel) {
        headlight = factory.createHeadlight();
        electric = factory.createElectric();
        engine = factory.createEngine();
        fueltank = factory.createFueltank();
        weels = factory.createWeels(carModel.getWheelDiskEnum());
        fueltank.setFuel(0);
    }
}
