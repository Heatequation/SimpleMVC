import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class View extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private Model m;
	private JTextField msgTf;
	private JLabel msgLbl;
	private JButton msgOkBtn;
	
	public View(Model m) {
		this.m = m;
		this.msgTf = new JTextField("(your message)", 20);
		this.msgLbl = new JLabel("");
		this.msgOkBtn = new JButton("OK - Display Message");
		
		this.m.addObserver(this);
		
		Dimension d = new Dimension(300, 100);
		
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,0));
		
		this.add(this.msgTf);
		this.add(this.msgOkBtn);
		this.add(this.msgLbl);
		
		this.setVisible(true);
	}
	
	public void updateComponents() {
		this.msgLbl.setText(m.getMessage());
	}

	@Override
	public void update(Observable o, Object arg) {
		updateComponents();
		
	}
	
	public void OkBtnClick(ActionListener l) {
		msgOkBtn.addActionListener(l);
		return;
	}

	public String getMsgTfTxt() {
		return this.msgTf.getText();
	}
	
	public void setMsgTfTxt(String msg) {
		this.msgTf.setText(msg);
	}

}
