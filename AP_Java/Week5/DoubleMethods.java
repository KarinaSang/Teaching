package week5;

public class DoubleMethods {
	public static void main(String[] args) {
		// Double dobj = new Double(2.5);
		Double dObj = Double.valueOf(2.5); //boxes 2.5 in Double object
		double d = dObj.doubleValue(); //unboxes 2.5 from Double object
		
		Object object = Double.valueOf(7.3); //Double is a subclass of Object
		Object intObj = Integer.valueOf(4);
		
//		if (dObj.compareTo(object) > 0) {
//			System.out.println("Error");
//		}
		
		if (dObj.compareTo((Double) object) < 0) {
			System.out.println("compareTo: object has a greater value");
		}
		
//		if (dObj.compareTo(intObj) > 0) {
//			System.out.println("Error");
//		}
		
//		if (dObj.compareTo((Double) intObj) < 0) {
//			System.out.println("compareTo: int object has a greater value");
//		}

	}

}
