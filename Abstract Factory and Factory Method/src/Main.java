

abstract class Shape {
    abstract void draw();
}
abstract class ColorfulShape {
    abstract void draw();
}


class ColorfulRectangle extends ColorfulShape {
    int a;
    int b;
    String color;

    ColorfulRectangle(int a, int b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }
    @Override
    void draw() {
        System.out.println("Colorful Rectangle : " + a + " " + b + " " + color);
    }
}


class ColorfulTriangle extends ColorfulShape {
    int a;
    int b;
    int c;
    String color;

    ColorfulTriangle(int a, int b, int c, String color) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }
    @Override
    void draw() {
        System.out.println("Colorful Triangle : " + a +" " + b + " " + c + " " + color );
    }
}







class Rectangle extends Shape {
    int a;
    int b;
    Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    void draw() {
        System.out.println("Rectangle : " + a + " " + b);
    }
}
class Triangle extends Shape {
    int a;
    int b;
    int c;
    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    void draw() {
        System.out.println("Triangle : " + a +" " + b + " " + c );
    }
}


abstract class Corporation {

    protected int a;
    protected int b;
    protected int c;
    protected String color;


    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setC(int c) {
        this.c = c;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public abstract Shape createShape();
    public abstract ColorfulShape createColorfulShape();
}



class TriangleCorporation extends Corporation {

    @Override
    public Shape createShape() {
        return new Triangle(a,b,c);

    }

    @Override
    public ColorfulShape createColorfulShape() {
        return new ColorfulTriangle( a,b,c , color);
    }
}


class RectangleCoroporation extends Corporation {

    @Override
    public Shape createShape() {
        return new Rectangle(a, b);

    }

    @Override
    public ColorfulShape createColorfulShape() {
        return new ColorfulRectangle(a,b ,color);
    }
}


public class Main {
    public static void main(String[] args) {

        RectangleCoroporation rc = new RectangleCoroporation();
        TriangleCorporation tc = new TriangleCorporation();

        rc.setA(1);
        rc.setB(2);
        rc.setColor("zielony");
        ColorfulShape colorfulRectangle = rc.createColorfulShape() ;

        rc.setA(3);
        rc.setB(4);
        Shape regularRectangle = rc.createShape() ;


        tc.setA(5);
        tc.setB(6);
        tc.setC(7);
        tc.setColor("czerwony");
        ColorfulShape colorfulTriangle = tc.createColorfulShape( ) ;

        tc.setA(8);
        tc.setB(9);
        tc.setC(10);
        Shape regularTriangle = tc.createShape() ;


        colorfulRectangle.draw();
        colorfulTriangle.draw();
        System.out.println();
        regularRectangle.draw();
        regularTriangle.draw();

    }
}
