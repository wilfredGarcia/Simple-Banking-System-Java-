import java.util.Collection;

abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}
class Circle extends Shape {
    double radius;
    Circle(double radius) {
        super();
        this.radius = radius;
    }
    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
class Triangle extends Shape {
    double firstside, secondside, thirdside;
    Triangle(double firstArg, double secondArg, double thirdArg) {
        super();
        this.firstside = firstArg;
        this.secondside = secondArg;
        this.thirdside = thirdArg;

    }
    @Override
    public double getPerimeter() {
        return firstside + secondside + thirdside;
    }
    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter()/2;
        double area = semiPerimeter*(semiPerimeter - firstside)*(semiPerimeter- secondside)*(semiPerimeter- thirdside);
        return Math.sqrt(area);
    }
}

class Rectangle extends Shape {
    double width;
    double height;
    Rectangle(double firstArg, double secondArg) {
        super();
        this.width = firstArg;
        this.height = secondArg;
    }

    @Override
    public double getPerimeter() {
        return (2*width)+(2*height);
    }
    @Override
    public double getArea() {
        return height*width;
    }
}
class main{
    public static void main(String[] args) {
        Shape circle = new Circle(10    );
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

        Shape triangle = new Triangle(14, 14 , 10 );
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());

        Shape rectangle = new Rectangle(5 ,10  );
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}