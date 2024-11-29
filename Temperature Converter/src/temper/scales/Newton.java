package temper.scales;

public class Newton {
    public static double convertTo(int target, double value) {
        switch (target) {
            case 1: return value * 100 / 33;                   //C
            case 2: return (value * 60 / 11) + 32;             // F
            case 3: return (value * 100 / 33) + 273.15;        // K
            case 4: return (value * 180 / 33) + 491.67;        // R
            case 5: return (33 - value) * 50 / 11;             // D
            case 7: return value * 80 / 33;                    // Re
            case 8: return (value * 35 / 33) + 7.5;            // Ro
            default: return Double.MIN_VALUE;
        }
    }

}
