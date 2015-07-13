package hashtable;

public class Record {
	private String key;
	private String value;
	
	public Record(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String k) {
		key = k;
	}
	
	public int getHash(int size) {
		int cum = 0;
		for(int i = 0; i < key.length(); i++) {
			cum += (int)key.charAt(i);
		}
		
		return cum % size;
		
	}
}
