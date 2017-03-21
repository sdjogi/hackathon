
package com.util;

/**
 * @author jogish
 */
public class UnitConverter {

    static double INCHES = 39.37;
    static double FEET = 3.28;
    static double MILES = 0.00062;
    static double MILLIMETERS = 1000;
    static double CENTIMETERS = 100;
    static double METERS = 1;
    static double KILOMETERS = 0.001;
    private double val, meters, converted;
    String fromUnit, toUnit;

    public UnitConverter(String afromUnit) {
        fromUnit = afromUnit;
        toUnit = afromUnit;
    }

    public double toMeters(double val) {
        if(toUnit.equals("in")){
            meters = (1 / INCHES);
        }else if(toUnit.equals("ft")){
            meters = (1 / FEET);
        }else if(toUnit.equals("mi")){
            meters = (1 / MILES);
        }else if(toUnit.equals("mm")){
            meters = (1 / MILLIMETERS);
        }else if(toUnit.equals("cm")){
            meters = (1 / CENTIMETERS);
        }else if(toUnit.equals("m")){
            meters = (1 / METERS);
        }else{
            meters = (1 / KILOMETERS);
        }
        return meters;
    }

    public double fromMeters(double meters) {
        if(fromUnit.equals("in")){
            converted = Math.round(meters * 100 * val);
        }else if(fromUnit.equals("ft")){
            converted = Math.round(meters * 100 * val);
        }else if(fromUnit.equals("mi")){
            converted = Math.round(meters * 100 * val);
        }else if(fromUnit.equals("mm")){
            converted = Math.round(meters * 100 * val);
        }else if(fromUnit.equals("cm")){
            converted = Math.round(CENTIMETERS * val);
        }else if(fromUnit.equals("m")){
            converted = Math.round(METERS * val);
        }else{
            converted = Math.round(KILOMETERS * val);
        }
        return converted;
    }
}
