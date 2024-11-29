package temper.scales;

public class Fahrenheit { //more precise for small-scale measurements (like body temperature).
    public static double convertTo(int target, double value) {
        switch (target) {
            case 1: return (value - 32) * 5 / 9;               // C
            case 3: return (value - 32) * 5 / 9 + 273.15;      // K
            case 4: return value + 459.67;                     //R
            case 5: return (212 - value) * 5 / 6;              // D
            case 6: return (value - 32) * 11 / 60;             // N
            case 7: return (value - 32) * 4 / 9;               //Re
            case 8: return (value - 32) * 7 / 24 + 7.5;        // Ro
            default: return Double.MIN_VALUE;
        }
    }
}
