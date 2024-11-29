package temper;

import java.util.Scanner;

public class FirstFile {
static double celcius;
static double fahrenheit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("which conversion you want to perform 1. celcius to fahrenheit    2. fahrenheit to celcius");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("enter temperature in celcius: ");
			celcius = sc.nextDouble();
			fahrenheit = (celcius * 9/5 )+32;
			System.out.println(celcius+" degree celcius ==> "+fahrenheit+" Fahrenheit");
			break;
		case 2:
			System.out.println("enter temperature in fahrenheit: ");
			fahrenheit = sc.nextDouble();
			celcius = (fahrenheit-32)*5/9;
			System.out.println(fahrenheit+" Fahrenheit ==> "+celcius+" celcius degrees");
			break;
		default:
			System.out.println("invalid choice");
		}
	}
}






/*
package temper;

import temper.scales.*;

import java.util.Scanner;

public class TemperatureConverter {
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

        if (resultTemp != Double.MIN_VALUE) {
            String unit = getUnitSymbol(targetScale); // Get the symbol for the target scale
            System.out.printf("Converted Temperature: %.2f (%s)%n", resultTemp, unit);
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

    // Helper method to get the unit symbol
    public static String getUnitSymbol(int scale) {
        switch (scale) {
            case 1: return "°C";  // Celsius
            case 2: return "°F";  // Fahrenheit
            case 3: return "K";   // Kelvin
            case 4: return "°R";  // Rankine
            case 5: return "°D";  // Delisle
            case 6: return "°N";  // Newton
            case 7: return "°Re"; // Réaumur
            case 8: return "°Rø"; // Rømer
            default: return "";   // Default case
        }
    }
}
*/
