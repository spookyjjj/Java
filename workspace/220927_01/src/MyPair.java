
public class MyPair<K, V> { //아무글자나 되는데 Key Value 이렇게 많이들 씀
	private K key;
	private V value;
	
	public MyPair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}

}
