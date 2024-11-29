package temper.scales;

public class Rankine { //for Industrial and Engineering Applications:
    public static double convertTo(int target, double value) {
        switch (target) {
            case 1: return (value - 491.67) * 5 / 9;           // C
            case 2: return value - 459.67;                     // R
            case 3: return value * 5 / 9;                      // K
            case 5: return (671.67 - value) * 5 / 6;           // D
            case 6: return (value - 491.67) * 11 / 60;         // N
            case 7: return (value - 491.67) * 4 / 9;           // Re
            case 8: return (value - 491.67) * 7 / 24 + 7.5;    // Ro
            default: return Double.MIN_VALUE;
        }
    }

}
