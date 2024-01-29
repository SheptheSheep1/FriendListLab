package src;

public class Friend {
	private String name;
	private long digits;
	private int age;
	private int IQ;
	private int BFrating;
	public Friend() {

	}
	public Friend(String name, long digits, int age, int IQ, int BFrating){
		this.name = name;
		this.digits = digits;
		this.age = age;
		this.IQ = IQ;
		this.BFrating = BFrating;
	}
	public static void main(String[] args) {
		
	}
	public String getName() {
		return name;
	}
	public long getDigits() {
		return digits;
	}
	public int getAge() {
		return age;
	}
	public int getIQ() {
		return IQ;
	}
	public int getBFrating() {
		return BFrating;
	}
}
