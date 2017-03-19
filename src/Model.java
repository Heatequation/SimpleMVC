import java.util.Observable;

public class Model extends Observable {

	private String msg;
	
	public Model() {
		this.msg = "Hello!";
	}
	
	public Model(String msg) {
		this.msg = msg;
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
		setChanged();
		notifyObservers();
	}
	
	public String getMessage() {
		return this.msg;
	}
}
