package o.collection.set.ex1;

import java.util.Comparator;

public class SortedLottery implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		int num = ((Lottery) o1).getName().compareTo(((Lottery) o2).getName());
		if(num == 0) {
			return ((Lottery) o1).getPhone().compareTo(((Lottery) o2).getPhone());
		}
		return num;
	}

	

	
	
}
