package criticalThinking4;

public class Cylinder extends Shape {
	private double radius;
	private double height;
	
public Cylinder(double radius, double height) {
	this.radius = radius;
	this.height = height;
}

@Override
public double surface_area() {
	return 2 * Math.PI * radius * (radius + height);
}

@Override
public double volume() {
	return Math.PI * Math.pow(radius, 2) * height;
}
@Override
public String toString() {
	return String.format("Cylinder:\nRadius: %.2f\nHeight: %.2f\nSurface Area: %.2f\nVolume: %.2f\n",
			radius, height, surface_area(), volume());
}
}
