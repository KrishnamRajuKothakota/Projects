package temper;

import temper.scales.*;

import java.util.Scanner;

public class TemperatureConverter {
	static final double  yyy = Double.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Available Scales:"); 
        System.out.println("1. Celsius (°C)");
        System.out.println("2. Fahrenheit (°F)");
        System.out.println("3. Kelvin (K)");
        System.out.println("4. Rankine (°R)");
        System.out.println("5. Delisle (°D)");
        System.out.println("6. Newton (°N)");
        System.out.println("7. Réaumur (°Re)");
        System.out.println("8. Rømer (°Rø)");

        System.out.print("Choose the source scale (1-8): ");
        int sourceScale = sc.nextInt();

        System.out.print("Choose the target scale (1-8): ");
        int targetScale = sc.nextInt();

        System.out.print("Enter the temperature in the source scale: ");
        double sourceTemp = sc.nextDouble();

        double resultTemp = convertTemperature(sourceScale, targetScale, sourceTemp);

        if (resultTemp != Double.MIN_VALUE ) {
            System.out.printf("Converted Temperature: %.2f%n", resultTemp);
        } else {
            System.out.println("Invalid conversion choice.");
        }
    }

    public static double convertTemperature(int source, int target, double value) {
        switch (source) {
            case 1: return Celsius.convertTo(target, value);
            case 2: return Fahrenheit.convertTo(target, value);
            case 3: return Kelvin.convertTo(target, value);
            case 4: return Rankine.convertTo(target, value);
            case 5: return Delisle.convertTo(target, value);
            case 6: return Newton.convertTo(target, value);
            case 7: return Reaumur.convertTo(target, value);
            case 8: return Romer.convertTo(target, value);
            default: return Double.MIN_VALUE;   
            
        }
    }
}
