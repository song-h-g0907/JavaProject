package test240731;

import java.util.ArrayList;
import java.util.HashMap;
//Controller : 사용자가 요청한 내욜을 처리한 후 그 결과를 
public class FarmController {
	private HashMap<Farm, Integer> hMap = new HashMap<>();
	private ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount ) {
		if(hMap.get(f)==null) {
			hMap.put(f, amount);
			return true;
		}
		return false;
	}
	public boolean removeKind(Farm f) {
		if(hMap.get(f)!=null) {
			hMap.remove(f);
			return true;
		}
		return false;
	}
	public boolean changeAmount(Farm f, int amount) {
		if(hMap.get(f)!=null) {
			hMap.put(f, amount);
			return true;
		}
		return false;
	}
	public HashMap<Farm, Integer> printFarm(){
		return hMap;
	}
	public boolean buyFarm(Farm f) {
		if(hMap.get(f)!=null && hMap.get(f)>=0) {
			hMap.put(f, hMap.get(f)-1);
			list.add(f);
			return true;
		}
		return false;
	}
	public boolean removeFarm(Farm f) {
		for(int i = 0 ; i<list.size(); i++) {
			if(list.get(i).equals(f)) {
				list.remove(i);
				hMap.put(f, hMap.get(f)+1);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Farm> printBuyFarm(){
		return list;
	}
}
