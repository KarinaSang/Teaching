package week5;

public class IntegerMethods {

	public static void main(String[] args) {
		// Integer intObj = new Integer(6); //boxes 6 in Integer object
		Integer intObj = Integer.valueOf(6);
		int j = intObj.intValue(); //unboxes 6 from Integer object
		System.out.println("Integer value is " + intObj);
		
		Object object = Integer.valueOf(6); //Integer is a subclass of Object
		Integer intObj2 = Integer.valueOf(6);
		int k = intObj2.intValue();
		if (intObj.equals(object)) {
			System.out.println("equals: Two integers are equal");
		}
		
		if (intObj.intValue() == intObj2.intValue()) {
			System.out.println("intValue: Two integers are equal");
		}

//		if (k.equals(j)) {
//			System.out.println("Error");
//		}
//		
//		if ((intObj.intValue()).compareTo(intObj2.intValue()) < 0) {
//			System.out.println("Error");
//		}
//		
//		if (intObj.compareTo(object) < 0) {
//			System.out.println("Error");
//		}
		
		if (intObj.compareTo((Integer) object) == 0) {
			System.out.println("compareTo:");
		}

//		if (object.compareTo(intObj) < 0) {
//			System.out.println("Error");
//		}

		
		if (((Integer) object).compareTo(intObj) == 0) {
			System.out.println("compareTo:");
		}
	

	}

}
