package menu;

public class Hansick3 extends Hansick {
	public String name = "칼국수";
	public int unitPrice = 4000;
	private int salesNum;
	private int leftNum = 5;
	private int tsalesNum;
	
	public Hansick3() {
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
