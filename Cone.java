package criticalThinking4;

public class Cone extends Shape {
    private double radius;
    private double height;

    
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Abstract methods
    @Override
    public double surface_area() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return String.format("Cone:\nRadius: %.2f\nHeight: %.2f\nSurface Area: %.2f\nVolume: %.2f\n",
                radius, height, surface_area(), volume());
    }
}