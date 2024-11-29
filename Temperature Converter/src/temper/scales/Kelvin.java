package temper.scales;

public class Kelvin { //used for scientific purposes as it produces accurate and absolute results.
    public static double convertTo(int target, double value) {
        switch (target) {
            case 1: return value - 273.15;                     //C
            case 2: return (value - 273.15) * 9 / 5 + 32;      // F
            case 4: return value * 9 / 5;                      // R
            case 5: return (373.15 - value) * 3 / 2;           // D
            case 6: return (value - 273.15) * 33 / 100;        // N
            case 7: return (value - 273.15) * 4 / 5;           // Re
            case 8: return ((value - 273.15) * 21 / 40) + 7.5; // Ro
            default: return Double.MIN_VALUE;
        }
    }

}
