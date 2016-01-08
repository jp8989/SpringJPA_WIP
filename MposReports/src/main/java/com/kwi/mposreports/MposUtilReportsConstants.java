package com.kwi.mposreports;

public final class MposUtilReportsConstants {
	
	   private MposUtilReportsConstants() {}

	  // LOTS OF static fields...

	  static public final String SESSIONID = "SESSIONID";

	  /*
	  Instead of implementing a "constants interface", in Java 1.5+, you can use static imports to import the constants/static methods from another class/interface:

	  import static com.kittens.kittenpolisher.KittenConstants.*;
	  This avoids the ugliness of making your classes implement interfaces that have no functionality.

	  As for the practice of having a class just to store constants, 
	  I think it's sometimes necessary. There are certain constants that just don't have a natural place in a class, so it's better to have them in a "neutral" place.

	  But instead of using an interface, use a final class with a private constructor. 
	  (Making it impossible to instantiate or subclass the class, sending a strong message that it doesn't contain non-static functionality/data.)
	  */

	}
