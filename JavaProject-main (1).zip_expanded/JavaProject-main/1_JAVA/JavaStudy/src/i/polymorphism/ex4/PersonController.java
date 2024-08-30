package i.polymorphism.ex4;

public class PersonController {
	Person[] p = new Person[13];
//	private Student[] s = new Student[3];
//	private Employee[] e= new Employee[10];
	public int[] personCount() {
		int scount=0,ecount=0;
		for (int i = 0; i<3; i++) {
			if (p[i]==null) {
				break;
			}
			scount++;
		}
		for (int i = 3; i<p.length; i++) {
			if (p[i]==null) {
				break;
			}
			ecount++;
		}
		int[] pc = {scount,ecount};
		return pc;
	}
	public void insertStudent(String name,int age,double height,double weight, int grade,String major) {
		for(int i = 0 ; i<3; i++) {
			if (p[i]==null) {
				p[i]=new Student(name,age,height,weight,grade,major);
				break;
			}
		}
	}
	public Person[] printStudent() {
		Person[] ps = new Person[3];
		for (int i =0; i<3; i++) {
			ps[i]=p[i];
		}
		return ps;
	}
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for(int i = 3 ; i<p.length; i++) {
			if (p[i]==null) {
				p[i]=new Employee(name,age,height,weight,salary,dept);
				break;
			}
		}
	}
	public Person[] printEmployee() {
		Person[] ps = new Person[10];
		for (int i =0; i<10; i++) {
			ps[i]=p[i+3];
		}
		return ps;
	}
}
