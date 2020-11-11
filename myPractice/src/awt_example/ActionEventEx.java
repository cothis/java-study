package awt_example;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionEventEx extends Frame implements ActionListener, WindowListener{
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public static void main(String[] args) {
		new ActionEventEx();
	}
	
	public ActionEventEx() {
		super("ActionEvent Test");
		
		p = new Panel();
		input = new Button("input");
		exit = new Button("exit");
		ta = new TextArea();
		
		input.addActionListener(this);
		exit.addActionListener(this);
		
		addWindowListener(this);
		
		p.add(input);
		p.add(exit);
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setBounds(300,300,300,200);
		setVisible(true);
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name;
		name = e.getActionCommand();
		if(name.equals("input"))
			ta.append("button inputted.\n");
		else {
			ta.append("Closing Program\n");
			try {
				Thread.sleep(2000);
			}
			catch (Exception error) {
				
			}
			System.exit(0);
		}
	}
}
