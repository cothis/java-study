package awt_example;

import java.awt.*;
import java.awt.event.*;

class FAdapterEx extends Frame implements ActionListener {
	Panel p1, p2, p3;
	TextField tf;
	TextArea ta;
	Button b1, b2;
	public FAdapterEx() {
		super("Adapter Test");
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		tf = new TextField(35);
		ta = new TextArea(10, 35);
		
		b1 = new Button("Clear");
		b2 = new Button("Exit");
		
		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);
		
		add("North", p1);
		add("Center", p2);
		add("South", p3);
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		tf.addKeyListener(new KeyEventHandler());
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("Clear")) {
			ta.setText("");
			tf.setText("");
			tf.requestFocus();
		} else if (str.equals("Exit")) {
			System.exit(0);
		}
	}
	
	
	class KeyEventHandler extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
		}
	}
}


public class AdapterEx2 {
	public static void main(String[] args) {
		FAdapterEx.KeyEventHandler key = new FAdapterEx().new KeyEventHandler();
	}
}
