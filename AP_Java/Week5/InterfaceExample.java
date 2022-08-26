package week5;

public interface InterfaceExample {	
	public String getName();
	
	default String getName2() { 
		return "name"; 
	}
	
	void method2();
}
