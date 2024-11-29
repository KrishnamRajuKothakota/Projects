package temper.scales;
public class Celsius {
    public static double convertTo(int target, double value) {
        switch (target) {
            case 2: return (value * 9 / 5) + 32;                //F
            case 3: return value + 273.15;                     //K
            case 4: return (value + 273.15) * 9 / 5;           //R
            case 5: return (100 - value) * 3 / 2;              //D
            case 6: return value * 33 / 100;                   //N
            case 7: return value * 4 / 5;                      //Re
            case 8: return (value * 21 / 40) + 7.5;            //Ro
            default: return Double.MIN_VALUE;
        }
    }
}
