public class LeapYear {
   public static void main(String[] args) {
	int year = Integer.valueOf(args[0]);
   	if (isLeapYear(year)) {
		System.out.println(String.valueOf(year) + " is a leap year.");
	} else {
		System.out.println(String.valueOf(year) + " is not a leap year.");
	}		
   }

   public static boolean isLeapYear(int year) {
	   if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
	    	return true;
	   }
	   return false;
   }
}
