package criticalThinking4;

public class Sphere extends Shape {
	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius;
	}

@Override
//Abstract method extended from shape.java
public double surface_area() {
	return 4 * Math.PI * Math.pow(radius, 2);
}

@Override
//Abstract method extended from shape.java
public double volume() {
	return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
}
@Override
public String toString() {
	return String.format("Sphere: \nRadius: %.2f\nSurface Area: %.2f\nVolume: %.2f\n",
			radius, surface_area(), volume());
}
}