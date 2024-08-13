package test240719.object2;

public class Company {

	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		employees[0] = new Secretary("Hilery",1,"secretary",800);
		employees[1] = new Sales("Clinten",2,"sales",1200);
		for(Employee em : employees) {
			System.out.println(em.getName()+" "+em.getDepartment()+" "+em.getSalary());
		}
		System.out.println("인센티브 100 지급");
		for(Employee em : employees) {
			((Bonus)em).incentive(100);
		}
		for(Employee em : employees) {
			System.out.println(em.getName()+" "+em.getDepartment()+" "+em.getSalary()+" "+em.tax());
		}
	}

}
