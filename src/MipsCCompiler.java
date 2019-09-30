
public class MipsCCompiler 
{
	private DataMemory theDataMemory;
	private RegisterCollection theRegisterCollection;
	private SrcReader theSrc;
	private String filename;
	
	public MipsCCompiler(String filename)
	{
		this.filename = filename;
		this.theSrc = new SrcReader(filename);
		this.theDataMemory = new DataMemory(200000);
		this.theRegisterCollection = new RegisterCollection(16);
		VariableList vars = new VariableList();
		String currLine = "";
		while (!currLine.contentEquals("EOF")) {
			currLine = this.theSrc.getNextLine();
			String[] words = currLine.replaceAll(";", "").split(" ");
			Boolean foundDeclare = false;
			Boolean foundAssign = false;
			for (String string : words) {
				if (string.contentEquals("int")) {
					foundDeclare = true;
				}
				if (string.contentEquals("=")) {
					foundAssign = true;
				}
			}
			if (foundDeclare) {
				for (String string : words) {
					if (!string.contentEquals("int")) {
						vars.Assign(string, this.theRegisterCollection, this.theDataMemory);
						Pair p = vars.GetVarMemoryAddress(string);
						System.out.println("Addi " + p.getValue0() + ", $zero, " + p.getValue1());
					}
				}
			}
			String left = "";
			String right = "";
			if (foundAssign) {
				for (String string : words) {
					if (!string.contentEquals("=")) {
						if (left.length() == 0) {
							left = string;
						} else {
							right = string;
						}
					}
				}
				String regForTmp = this.theRegisterCollection.getNextAvailableRegisterName();
				if (vars.IsAssigned(left) && right.length() > 0) {
					Pair p = vars.GetVarMemoryAddress(left);
					System.out.println("addi " + regForTmp + ", $zero, " + right);
					System.out.println("sw " + regForTmp + ", 0(" + p.getValue0() + ")");
				}
			}
		}
	}
}
