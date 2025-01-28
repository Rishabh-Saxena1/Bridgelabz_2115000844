import java.util.HashSet;
 public class OTPGenerator {

 	// Method to generate a 6-digit OTP using Math.random()
 	public static int generateOTP() {
     	return (int) (Math.random() * 900000) + 100000; // Ensures a 6-digit number
 	}

 	// Method to check if all OTPs in the array are unique
 	public static boolean areOTPsUnique(int[] otpArray) {
     	HashSet<Integer> uniqueOTPs = new HashSet<>();
     	for (int otp : otpArray) {
         	if (!uniqueOTPs.add(otp)) {
          	   return false; // Duplicate found
         	}
     	}
     	return true; // All OTPs are unique
 	}

 	public static void main(String[] args) {
     	int[] otpArray = new int[10];

     	// Generate 10 OTPs and store them in the array
     	for (int i = 0; i < otpArray.length; i++) {
         	otpArray[i] = generateOTP();
     	}

     	// Display the generated OTPs
     	System.out.println("Generated OTPs:");
     	for (int otp : otpArray) {
         	System.out.println(otp);
     	}

     	// Check if all generated OTPs are unique
     	boolean unique = areOTPsUnique(otpArray);
     	System.out.println("Are all OTPs unique? " + unique);
 	}
 }
