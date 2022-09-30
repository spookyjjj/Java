
public class MyHolder<T> { //아무 대문자나 되는데 보통 Type이라서 T를 씀
	private T object;
	
	public MyHolder() {}
	
	public MyHolder(T object) {
		super();
		this.object = object;
	}
	
	public T getObject() {
		return object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
}
