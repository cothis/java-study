package work;

public class Ex02 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?" + (p1==p2));
		System.out.println("p1.equals(p2)" + (p1.equals(p2)));
	}
}

class Point3D {
	int x, y, z;

	public Point3D(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point3D() {
		this(0,0,0);
	}
	
	public boolean equals(Object obj) {
		/*
		 * x,y,z 비교 
		 */
		if(obj instanceof Point3D) {
			Point3D p = (Point3D)obj;
			return x==p.x && y==p.y && z==p.z;
		}
		else return false;
	}
	
	public String toString() {
		/*
		 * x,y,z 출력
		 */
		return "["+x+","+y+","+z+"]";
	}
	
}