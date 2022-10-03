package optional_topic;

import java.util.*;
public class IteratorExample {
	/** Remove all 2-character strings from strList.
	* Precondition: strList initialized with String objects.
	*/
	public static void removeTwos(List<String> strList) { // {"hi", "bye", "hello"}
		Iterator<String> itr = strList.iterator();
		while (itr.hasNext())
			if (itr.next().length() == 2)
				itr.remove();
	}
	
	
	/** Assume a list of integer strings.
	* Remove all occurrences of "6" from the list.
	*/
	public static void remove6(List<String> list) {
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String num = itr.next();
			if (num.equals("6")) {
				itr.remove();
			}
		}
	}
	
	
	/** Remove all negatives from intList.
	* Precondition: intList contains Integer objects.
	*/
	public static void removeNegs(List<Integer> intList) {
		Iterator<Integer> itr = intList.iterator();
			while (itr.hasNext())	
				if (itr.next().intValue() < 0)
					itr.remove();
	}
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Scanner myScanner = new Scanner(System.in);
		
		String word = myScanner.nextLine();
		
		while (!word.equals("")) {
			list.add(word);
			word = myScanner.nextLine();
		}
		
		myScanner.close();
		
//		removeTwos(list);
//		remove6(list);
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(6);
		intList.add(-9);
		intList.add(0);
		intList.add(-6);
		
		removeNegs(intList);
		
		for (Integer num : intList)
			System.out.println(num);
		
		
		//Print strings in list, one per line.
		Iterator<String> itr = list.iterator();
		

		// itr.next();
		// itr.remove();
		
		while (itr.hasNext())
			System.out.println(itr.next());
		
		
		// itr.next();
	}

}
