package menu;

public class Joongsick3 extends Joongsick {
	public String name = "연어덮밥";
	public int unitPrice = 12000;
	private int salesNum;
	private int leftNum = 2;
	private int tsalesNum;
	
	public Joongsick3() {
		this.name = name;
		this.unitPrice = unitPrice;
		this.salesNum = salesNum;
		this.leftNum = leftNum;
		this.tsalesNum = tsalesNum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getunitPrice() {
		return unitPrice;
	}
	
	public int getSalesNum() {
		return salesNum;
	}
	
	public void setSalesNum(int salesNum) {
		this.salesNum = salesNum;
	}

	public int getLeftNum() {
		return leftNum;
	}

	public void setLeftNum(int salesNum) {
		this.leftNum -= salesNum;
	}

	public int getTsalesNum() {
		return tsalesNum;
	}

	public void setTsalesNum(int tsalesNum) {
		this.tsalesNum += tsalesNum;
	}
}
