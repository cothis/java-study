package awt_example;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;

public class RadioCheckboxEx {
	public static void main(String[] args) {
		Frame f = new Frame("라디오형 체크박스 테스트");
		Panel p = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox radio1 = new Checkbox("고졸", group, false);
		Checkbox radio2 = new Checkbox("전문대졸", group, false);
		Checkbox radio3 = new Checkbox("대졸", group, true);
		
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}
