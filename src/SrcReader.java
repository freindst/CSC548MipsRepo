import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class SrcReader 
{
	private String filename;
	private LinkedList<String> theHighLevelCode;
	private int linePos;
	
	public SrcReader(String filename)
	{
		this.theHighLevelCode = new LinkedList<String>();
		this.linePos = 0;
		
		this.filename = filename;
		try
		{
			Scanner input = new Scanner(new File(this.filename));
			while(input.hasNext())
			{
				this.theHighLevelCode.add(input.nextLine());
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getNextLine()
	{
		if(this.linePos < this.theHighLevelCode.size())
		{
			this.linePos++;
			return this.theHighLevelCode.get(this.linePos-1);
		}
		return "EOF";
	}
}
