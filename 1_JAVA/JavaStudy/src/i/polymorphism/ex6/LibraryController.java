package i.polymorphism.ex6;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];
	{
	bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
	bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
	bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
	bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
	bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}

	public void insertMember(Member mem) {
		this.mem = mem;
	}
	public Member myInfo() {
		return this.mem;
	}
	public Book[] selectAll() {
		return bList;
	}
	public Book[] searchBook(String keyword) {
		Book[] barr = new Book[5];
		for (int i  =0; i<bList.length; i++) {
			if(bList[i]==null) {
				break;
			}
			if(bList[i].getTitle().indexOf(keyword)>=0) {
				for(int j = 0 ; j <barr.length; j++) {
					if(barr[j]==null) {
						barr[j]=bList[i];
						break;
					}
				}
			}
		}
		return barr;
	}
	public int rentBook(int index) {
		int result = 0;
		if (bList[index] instanceof AniBook) {
			if(this.mem.getAge()<((AniBook)bList[index]).getAccessAge()) {
				result =1;
			}
		}else {
			if(((CookBook)bList[index]).isCoupon()) {
				this.mem.setCouponCount(this.mem.getCouponCount()+1);
				return 2;
			}
		}
		return result;
	}
}
