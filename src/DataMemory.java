
public class DataMemory 
{
	private MemBucket[] theBuckets;
	
	//must be a multiple of 4
	public DataMemory(int byteSize)
	{
		this.theBuckets = new MemBucket[byteSize/4];
		int currLocation = 5000;
		for(int i = 0; i < this.theBuckets.length; i++)
		{
			this.theBuckets[i] = new MemBucket(currLocation);
			currLocation += 4;
		}
	}
	
	//assume we are always asking for 4 bytes - 32 bits
	public int getAddressForNewMemory()
	{
		for(MemBucket mb : this.theBuckets)
		{
			if(!mb.isInUse())
			{
				mb.setInUse(true);
				return mb.getLocation();
			}
		}
		throw new RuntimeException("You Be OUTTA MEMoreee");
	}
}
