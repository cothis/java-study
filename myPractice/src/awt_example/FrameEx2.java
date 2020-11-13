package awt_example;

import java.awt.*;

@SuppressWarnings("serial")
public class FrameEx2 extends Frame {
	public FrameEx2() {
		super("프레임테스트");
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FrameEx2 fr = new FrameEx2();
	}
}
