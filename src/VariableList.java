import java.util.HashMap;
import java.util.Map;
public class VariableList {
	private Map<String, Pair> list;
	
	public VariableList() {
		list = new HashMap<String, Pair>();
	}
	
	public Boolean IsAssigned(String key) {
		return list.containsKey(key);
	}
	
	public void Assign(String key, RegisterCollection rc, DataMemory dm) {
		list.put(key, new Pair(rc.getNextAvailableRegisterName(), dm.getAddressForNewMemory()));
	}
	
	public Pair GetVarMemoryAddress(String key) {
		if (list.containsKey(key)) {
			return this.list.get(key);
		}
		throw new RuntimeException("Variable \"" + key + "\" hasn't been declared");
	}
}

