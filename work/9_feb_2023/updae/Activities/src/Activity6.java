import java.util.*;

class Activity6 {
    public static void driver() {
        Rectangle rect = new Rectangle(5,4);
        Triangle tri = new Triangle(3,4);
        Circle cr = new Circle(10);
        Square sq = new Square(5);
        System.out.println("Area of rectanlge "+rect.Area());
        System.out.println("Area of Triangle "+tri.Area());
        System.out.println("Area of square "+sq.Area());
        System.out.println("Area of circle "+cr.Area());
        System.out.println("Circumference of circle "+cr.Circumference());
    }
}

class Rectangle{
    double height;
    double width;
    public Rectangle(double h, double w){
        height = h;
        width=w;
    }
    public double Area(){
        return height*width;
    }
}

class Triangle{
    double height;
    double width;
    public Triangle(double h, double w){
        height = h;
        width = w;
    }
    public double Area(){
        return 0.5*height*width;
    }
}


class Circle{
    double radius;
    public Circle(double r){
        radius = r;
    }
    public double Area(){
        return radius*radius*3.14;
    }
    public double Circumference(){
        return Diameter()*3.14;
    }
    public double Diameter(){
        return 2*radius;
    }
}

class Square extends Rectangle{
    Square(double sd){
        super(sd,sd);
    }
}


