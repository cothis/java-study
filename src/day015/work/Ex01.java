package day015.work;

public class Ex01 {
	public static void main(String[] args) {
		Shape s = new Circle(10);
		System.out.println(s.calcArea());
		
		System.out.println();
		s = new Rectangle(5, 5);
		System.out.println(s.calcArea());
		System.out.println(((Rectangle)s).isSquare());
		
		s = new Shape(new Point(5, 5)) { // Triangle		
			@Override
			double calcArea() {
				return (p.x * p.y / 2.0);
			}
		};
		System.out.println(s.calcArea());
	}
}

class Circle extends Shape{
	double r;
	
	Circle() { this(0); }
	Circle(double r) { this.r = r; }
	
	@Override
	double calcArea() { return Math.PI*r*r; }
	
}

class Rectangle extends Shape{
	int width;
	int height;

	public Rectangle() { this(0, 0); }

	public Rectangle(int width, int height) { 
		this.width = width; 
		this.height = height;
	}

	@Override
	double calcArea() { return width*height; }

	boolean isSquare() { return width == height; }	
}

abstract class Shape {
	Point p;
	
	Shape() {
		this(new Point(0,0));
	}
	Shape(Point p) {
		this.p = p;
	}
	
	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메소드
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
	
	
}

class Point {
	int x;
	int y;
	
	public Point() {
		this(0,0);
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "["+x+","+y+"]";
	}
	
	
}