package criticalThinking4;

//ShapeArray.java
public class ShapeArray {
 public static void main(String[] args) {
     // Instantiate shapes
     Shape sphere = new Sphere(5.0);
     Shape cylinder = new Cylinder(3.0, 7.0);
     Shape cone = new Cone(3.0, 7.0);

     // Store in an array
     Shape[] shapeArray = {sphere, cylinder, cone};

     // Loop through and print details
     for (Shape shape : shapeArray) {
         System.out.println(shape.toString());
     }
 }
}