package temper.scales;

public class Delisle {
    public static double convertTo(int target, double value) {
        switch (target) {
            case 1: return 100 - (value * 2 / 3);               // C
            case 2: return 212 - (value * 6 / 5);               // F
            case 3: return 373.15 - (value * 2 / 3);            // K
            case 4: return 671.67 - (value * 6 / 5);            // R
            case 6: return (100 - (value * 2 / 3)) * 33 / 100;  //N
            case 7: return (100 - (value * 2 / 3)) * 4 / 5;     //Re
            case 8: return ((100 - (value * 2 / 3)) * 21 / 40) + 7.5; //Ro
            default: return Double.MIN_VALUE;
        }
    }
}
