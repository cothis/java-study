package myinterface;

public class WriterTest {
	public static void main(String[] args) {
		WriteTest wt = new WriteTest();
		
		Writer w = new BallPen();
		wt.writer_method(w);
		
		Writer[] wArr = new Writer[5];
		wArr[0] = new Pencil();
		wArr[1] = new BallPen();
		wArr[2] = new BallPen();
		wArr[3] = new Pencil();
		wArr[4] = new Pencil();
		
		for(int i=0; i<wArr.length;i++) {
			wt.writer_method(w);
		}
		
	}
}

class WriteTest {
	void writer_method(Writer w) {
		w.write();
		
		/*
		if(w instanceof BallPen) {
			((BallPen)w).erase();
		}
		else {
			((Pencil)w).delete();
		}
		*/
	}
}

interface Writer {
	void write();
}

class BallPen implements Writer {

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("볼펜으로 기록합니다.");
		
		erase();
	}
	
	public void erase() {
		System.out.println("기록을 화이트로 지웁니다.");
	}
}

class Pencil implements Writer {

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("펜슬로 기록합니다.");
		
		delete();
	}
	
	public void delete() {
		System.out.println("기록을 지우개로 삭제합니다.");
	}
}