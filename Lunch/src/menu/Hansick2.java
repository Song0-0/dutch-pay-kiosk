package menu;

public class Hansick2 extends Hansick{
	public String name = "묵밥";
	public int unitPrice = 6000;
	private int salesNum;
	private int leftNum = 5;
	private int tsalesNum;
	
	public Hansick2() {
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
