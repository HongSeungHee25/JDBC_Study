package partE.thread;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/*  자바에서 쓰레드를 사용하기 형식 <2>:
*   1. Thread 익명 클래스를 정의하면서 인스턴스 생성 
*   2. 정의한 클래스에서 run() 메소드를 override - 쓰레드에서 할 일을 구현
*   3. 생성된 인스턴스에서 start() 메소드를 호출
*/

public class Main02 {
	
	
	JFrame frame = new JFrame("쓰레드 동시성 테스트");
	JTextArea jta1 = new JTextArea();
	JTextArea jta2 = new JTextArea();
	
	public Main02() {
	    initialize();
	}
	
	private void initialize() {
		
		frame.setSize(510, 850);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container ctn = frame.getContentPane();   

		jta1.setBounds(10, 10, 240, 800);
		jta2.setBounds(260, 10, 240, 800);
		
		ctn.add(jta1);
//		JScrollPane jsp1 = new JScrollPane(jta1); 
//		jsp1.setBounds(10, 10, 240, 440);
//		ctn.add(jsp1);
//		
		ctn.add(jta2);
//		JScrollPane jsp2 = new JScrollPane(jta2); 
//		jsp2.setBounds(250, 10, 240, 440);
//		ctn.add(jsp2);
//		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		System.out.println("쓰레드 생성하기 <2>");
		Main02 main = new Main02();

		//1.
		Thread th1 = new Thread("덧셈 쓰레드!") {
			
				// 2. run() 메소드 override -쓰레드에서 할 일을 구현
				@Override
				public void run() {
					int sum=0;
					StringBuilder message = new StringBuilder();
					for(int i = 0; i < 20; i++) {
						message.append(getName() + "    sum : " + (sum+=i) +"\n");
						main.jta1.setText(message.toString());
						try {
							Thread.sleep(1000);		//지정된 시간(ms) 만큼 스레드 실행을 멈추기
						} catch (InterruptedException e) {}
					}
					System.out.println("I am 쓰레드 ID:"+ getId()+" 〓〓〓 스레드 실행 끝 〓〓〓〓〓〓〓〓");
				}
				
		};
		Thread th2 = new Thread("뺄셈 쓰레드!") {
			@Override
			public void run() {
				int sum=1000;
				StringBuilder message = new StringBuilder();
				for(int i = 0; i < 20; i++) {
					message.append(getName() + "    index : " + (sum-=i) +"\n");
					main.jta2.setText(message.toString());
					try {
						Thread.sleep(500);		//지정된 시간(ms) 만큼 스레드 실행을 멈추기
					} catch (InterruptedException e) {}
				}
				System.out.println("I am 쓰레드 ID:"+ getId()+" 〓〓〓 스레드 실행 끝 〓〓〓〓〓〓〓〓");
			
			}
			
		};
		
		
		// 4. 생성된 인스턴스로 start() 메소드를 호출
		th1.start();
		th2.start();

		
		try {
			//main 쓰레드 다른 쓰레드 모두 종료된 후에 끝내기를 원한다면 ▶ main 쓰레드의 대기
			th1.join();			//main 이 th1 이 종료될때까지 기다림
			th2.join();			//main 이 th2 이 종료될때까지 기다림
			//두개의 쓰레드를 기다림 ▶ 항상 main 쓰레드가 마지막에 종료합니다.
		} catch (InterruptedException e) {}
		
		System.out.println("I am Main 〓〓〓〓〓〓〓〓〓〓〓〓〓 언제 실행되는지 확인하세요. 〓〓〓〓〓〓〓〓〓〓");
		
		
		
	} //main end
	
} // class end

	














