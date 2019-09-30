
public class Register 
{
	private String name;
	private int value;
	private boolean inUse;
	
	public Register(String name)
	{
		this.name = name;
		this.value = 0;
		this.inUse = false;
	}
	
	public boolean isInUse()
	{
		return this.inUse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	
}
