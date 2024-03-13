import java.util.*;

public class Activity1{
    public static void driver(){
        Convert obj = new Convert();
        System.out.println("45 GBP in USD: "+obj.convertPoundToDollar(45));
        System.out.println("100°F in °C: "+obj.convertFarenheitToCelsius(100));
        System.out.println("69°C in °F: "+obj.convertCelsiusToFarenheit(69));
        System.out.println("Average of 10, 47.5, 39, 52.1: "+obj.average(10,47.5,39,52.1));
        System.out.println("15% off on 273 is "+obj.discount(273,15));
    }
}

class Convert{

    public double convertPoundToDollar(double pound){
        return pound * 1.2;
    }

    public double convertFarenheitToCelsius(double frnt){
        return ((frnt-32)/1.8);
    }

    public double convertCelsiusToFarenheit(double cel){
        return ((cel*1.8) + 32);
    }

    public double average(double a, double b, double c, double d){
        return ((a+b+c+d)/4);
    }

    public double discount(double price, double N){
        return (price - (price * N/100));
    }
}
