import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private Model m;
	private View v;
	
	public Controller(Model m, View v) {
		this.m = m;
		this.v = v;
		v.OkBtnClick(new OkClickListener());
	}

	public static void main(String[] args) {
		
		Model m = new Model("Hello!");
		View v = new View(m);
		
		Controller c = new Controller(m, v);

	}

	
	private class OkClickListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			m.setMessage(v.getMsgTfTxt());
			v.setMsgTfTxt("");
		}
		
	}
	
}
