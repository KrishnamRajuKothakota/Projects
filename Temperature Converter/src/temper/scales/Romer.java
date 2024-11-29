package temper.scales;

public class Romer {
    public static double convertTo(int target, double value) {
        switch (target) {
            case 1: return (value - 7.5) * 40 / 21;            // C
            case 2: return ((value - 7.5) * 24 / 7) + 32;      // F
            case 3: return ((value - 7.5) * 40 / 21) + 273.15; // K
            case 4: return ((value - 7.5) * 72 / 7) + 491.67;  // R
            case 5: return (60 - value) * 20 / 7;              // D
            case 6: return (value - 7.5) * 22 / 35;            // N
            case 7: return (value - 7.5) * 32 / 21;            // R
            default: return Double.MIN_VALUE;
        }
    }

}
