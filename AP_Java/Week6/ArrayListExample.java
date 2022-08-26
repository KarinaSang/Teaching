package week6;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	
	public static <E> void swap(List<E> list, int i, int j)
	{
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(); 

		
		for (int i = 0; i < 4; i++)
			list.add(i); // {0, 1, 8, 7, 5}

		Integer intOb = list.get(2); 
		
		int n = list.get(3); 	

		Integer x = list.set(3, 5); 
		
		x = list.remove(2); 
		
		list.add(1, 7); 
		list.add(2, 8); 
	
		swap(list, 1, 3);
		
		for (Integer num : list)
			System.out.println(num);

	}

}
