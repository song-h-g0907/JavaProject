package test240719.object2;

public class Sales extends Employee implements Bonus{

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	public Sales() {
		super();
	}

	@Override
	public void incentive(int pay) {
		this.setSalary((int)(this.getSalary()+(pay*1.2)));
	}

	@Override
	public double tax() {
		return this.getSalary()*0.13;
	}
	
}
