package j.Interface.ex3;

public class GalaxyNote9 extends SmartPhone implements NotePen{

	public GalaxyNote9() {
		super();
		this.setMaker("삼성");
	}
	
	@Override
	public String charge() {
		return "고속 충전, 고속 무선 충전";
	}

	@Override
	public String touch() {
		return "정전식,와콤펜 지원";
	}

	@Override
	public boolean bluetoothPen() {
		return true;
	}

	@Override
	public String printInformation() {
		String str="";
		str+="갤럭시 노트9은 "+super.getMaker()+"에서 만들어졌고 제원은 다음과 같다.\n";
		str+=this.makeCall()+"\n";
		str+=this.takeCall()+"\n";
		str+=this.picture()+"\n";
		str+=this.charge()+"\n";
		str+=this.touch()+"\n";
		str+=this.bluetoothPen();
		return str;
	}

	@Override
	public String makeCall() {
		return "번호를 누르고 통화버튼을 누름";
	}

	@Override
	public String takeCall() {
		return "수신 버튼을 누름 ";
	}

	@Override
	public String picture() {
		return "1200만 듀얼 카메라";
	}

}
