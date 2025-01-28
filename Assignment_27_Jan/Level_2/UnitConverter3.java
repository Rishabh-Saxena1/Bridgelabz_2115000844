public class UnitConverter3{
 public static double FahrenheitToCelsius(double fahrenheit) {
 return (fahrenheit - 32) * 5 / 9;
 }
 public static double CelsiusToFahrenheit(double celsius) {
 return (celsius * 9 / 5) + 32;
 }
 public static double PoundsToKilograms(double pounds) {
 return pounds * 0.453592;
 }
 public static double KilogramsToPounds(double kilograms) {
 return kilograms * 2.20462;
 }
 public static double GallonsToLiters(double gallons) {
 return gallons * 3.78541;
 }
 public static double LitersToGallons(double liters) {
 return liters * 0.264172;
 }
 public static void main(String[] args) {
 System.out.println(FahrenheitToCelsius(90.6));
 System.out.println(CelsiusToFahrenheit(30));
 System.out.println(PoundsToKilograms(140));
 System.out.println(KilogramsToPounds(98));
 System.out.println(GallonsToLiters(10));
 System.out.println(LitersToGallons(4.756));
 }
 }
