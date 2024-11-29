package temper.scales;

public class Reaumur {
	  public static double convertTo(int target, double value) {
	        switch (target) {
	            case 1: return value * 5 / 4;                      // C
	            case 2: return (value * 9 / 4) + 32;               // F
	            case 3: return (value * 5 / 4) + 273.15;           // K
	            case 4: return (value * 9 / 4) + 491.67;           // R
	            case 5: return (80 - value) * 15 / 8;              // D
	            case 6: return value * 33 / 80;                    // N
	            case 8: return (value * 21 / 32) + 7.5;            // R
	            default: return Double.MIN_VALUE;
	        }
	    }

}
