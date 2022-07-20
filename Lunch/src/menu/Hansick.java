package menu;

public abstract class Hansick extends Menu {
	public String name;
	public int unitPrice;
	private int salesNum;
	private int leftNum;
	private int tsalesNum;

	public abstract String getName();

	public abstract int getunitPrice();

	public abstract int getSalesNum();

	public abstract void setSalesNum(int salesNum);

	public abstract int getLeftNum();

	public abstract void setLeftNum(int salesNum);

	public abstract int getTsalesNum();

	public abstract void setTsalesNum(int tsalesNum);

}
