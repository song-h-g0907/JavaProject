package o.collection.set.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	public boolean deleteObject(Lottery l) {
		boolean isRemove = lottery.remove(1);
		if(isRemove && win != null) {
			win.remove(1);
		}
		return isRemove;
	}
	public HashSet winObject() {
		if(lottery.size() < 4) {
			return null;
		}
		List<Lottery> list = new ArrayList<>();
		list.addAll(lottery);
		while(win.size()<4) {// 사이즈확인해서 4명이하면 계속 진행
			int random = (int)Math.random()*list.size();//랜덤발생
			win.add(list.get(random)); //랜덤자리에있는 사람을 당첨목록에 추가
		}
		return win;
	}
	public TreeSet sortedWinObject() {
		TreeSet sortedWinSet = new TreeSet(new SortedLottery());
		sortedWinSet.addAll(win);
		return sortedWinSet;
	}
	public boolean searchWinner(Lottery l) {
		
		return win.contains(l);
	}
}
