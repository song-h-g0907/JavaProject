package test240731;

public class Fruit extends Farm{
	private String name;

	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getKind()+ " : "+this.name;
	}

	@Override
	public int hashCode() {
		String str = ""+this.getKind()+this.name;
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fruit) {
			Fruit ve = (Fruit)obj;
			if(this.name.equals(ve.getName()) && this.getKind().equals(ve.getKind())){
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	
}
