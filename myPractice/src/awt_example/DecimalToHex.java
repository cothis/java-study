package awt_example;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DecimalToHex extends Frame implements ActionListener, WindowListener{
	Panel numpadPanel;
	Label result;
	Button[] numpad;
	Button Enter;
	boolean clear;
	
	public DecimalToHex() {
		// TODO Auto-generated constructor stub
		super("Calculator");
		this.setLayout(new BorderLayout());
		clear = true;
		
		numpadPanel = new Panel();
		
		Panel[] numPanel = new Panel[4];
		for (int i = 0 ; i < numPanel.length; i++) {
			numPanel[i] = new Panel();
		}
		numpad = new Button[10];
		for(int i = 0 ; i < numpad.length; i++) {
			String buttonName = "" + i;
			numpad[i] = new Button(buttonName);
			numpad[i].setSize(100, 100);
			numpad[i].addActionListener(this);
		}
		numPanel[0].add(numpad[7]);
		numPanel[0].add(numpad[8]);
		numPanel[0].add(numpad[9]);
		numPanel[1].add(numpad[4]);
		numPanel[1].add(numpad[5]);
		numPanel[1].add(numpad[6]);
		numPanel[2].add(numpad[1]);
		numPanel[2].add(numpad[2]);
		numPanel[2].add(numpad[3]);
		numPanel[3].add(numpad[0]);
		
		
		
		numpadPanel.add(numPanel[0]);
		numpadPanel.add(numPanel[1]);
		numpadPanel.add(numPanel[2]);
		numpadPanel.add(numPanel[3]);
		
		
		
		
//		numpad = new Button[10];
//		for(int i = 0; i < numpad.length; i++) {
//				String buttonName = "" + i;
//				numpad[i] = new Button(buttonName);
//				numpad[i].addActionListener(this);
//				numpadPanel.add(numpad[i]);
//		}
		
		
		Enter = new Button("Enter");
		Enter.addActionListener(this);
		result = new Label("hello");
		result.setSize(200, 300);
		
		addWindowListener(this);
		add(result, BorderLayout.NORTH);
		add(numpadPanel, BorderLayout.CENTER);
		add(Enter, BorderLayout.SOUTH);
		
		setBounds(300, 300, 300, 300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new DecimalToHex();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String name;
		name = ae.getActionCommand().toUpperCase();
		if(name.equals("ENTER")) {
			if(clear == false) {
				String res = result.getText();
				long number = Long.parseLong(res);
				res = String.format("0x%02X", number);
				result.setText(res);
				clear = true;				
			}
		} else {
			if (clear == true) {
				clear = false;
				result.setText(name);
			} else {
				String res = result.getText();
				result.setText(res + name);
			}
		}
		
	}
}
