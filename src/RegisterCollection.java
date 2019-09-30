
public class RegisterCollection 
{
	private Register[] theRegisters;
	
	public RegisterCollection(int numStandardRegisters)
	{
		this.theRegisters = new Register[numStandardRegisters + 1];
		this.theRegisters[0] = new Register("$zero");
		for(int i = 1; i < this.theRegisters.length; i++)
		{
			this.theRegisters[i] = new Register("$t" + (i-1));
		}
	}
	
	public String getNextAvailableRegisterName()
	{
		for(int i = 1; i < this.theRegisters.length; i++)
		{
			if(!this.theRegisters[i].isInUse())
			{
				this.theRegisters[i].setInUse(true);
				return this.theRegisters[i].getName();
			}
		}
		throw new RuntimeException("OMG Outta Registeeeeeers!!!!");
	}
	
	public int getValueByRegisterName(String name)
	{
		for(Register r : this.theRegisters)
		{
			if(r.getName().equals(name))
			{
				return r.getValue();
			}
		}
		throw new RuntimeException("Register Not Found!");
	}
}
