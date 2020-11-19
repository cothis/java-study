package myarraylist;

import java.util.ArrayList;

public class Test {
	MyArrayList<Student> list = new MyArrayList<Student>(1);
	ArrayList<Student> listA = new ArrayList<Student>(1);
	
	public void addStudent(Student s) {
		list.insert(s);
		listA.add(s);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		Student s = new Student(0, "abc");
		t.addStudent(s);
		s = new Student(1,"cde");
		t.addStudent(s);
		
		t.list.print();
		System.out.println(t.listA.toString());
		
		System.out.println(t.list.size());
		System.out.println(t.listA.size());
		
	
		Student s2 = new Student(1, "cde");
		Student tmp = t.list.search(s2);
		System.out.println("searched: " + tmp);
		if(t.listA.indexOf(s2)>=0)
			tmp = t.listA.get(t.listA.indexOf(s2));
		else tmp = null;
		System.out.println("searched: " + tmp);
	}
}


class Student{
	int id;
	String name;
		
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student tmp = (Student) obj;
		boolean res = id == tmp.id && name.equals(tmp.name);
		return res;
	}



	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
	
}