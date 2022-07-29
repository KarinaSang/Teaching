package week4;

public abstract class FlyingObject {
	private String name;
	
	public FlyingObject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void fly();
	
	public abstract boolean isFlying();
}
