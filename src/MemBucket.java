
public class MemBucket 
{
	private int location;
	private int value;
	private boolean inUse;
	
	public MemBucket(int location)
	{
		this.value = 0;
		this.inUse = false;
		this.location = location;
	}
	
	public boolean isInUse()
	{
		return this.inUse;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
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
