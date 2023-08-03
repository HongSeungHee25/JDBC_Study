package partE.thread;

/*
 * Thread : 동일 프로세스 안에서 특정 기능을 수행하는 독립적 단위
 * 목적 : 멀티태스킹(동시성) 과 응답속도 향상 목적
 * 
 * 자바에서 스레드를 만드는 형식은 몇가지 있음.
 * 방법 1.
 * 1. Thread 클래스를 상속받는 클래스를 정의
 * 2. 정의한 클래스에서 run() 메소드 재정의 ▶ 쓰레드가 할일 작성
 * 3. 쓰레드 객체 생성 후 실행은 start() 메소드.
 * 
 */

public class Main01 {
	public static void main(String[] args) {
		System.out.println("━━━━━━━━ 쓰레드 객체 생성 ━━━━━━━━━");
		Thread th1 = new AddThread();
		Thread th2 = new SubtractThread();
		
		//쓰레드 이름 변경
		th1.setName("덧셈쓰레드");
		th2.setName("뺄셈쓰레드");
		
		//3. 쓰레드 객체 생성 후 실행은 start() 메소드.
		//쓰레드 실행 start()는 동시성을 갖습니다.
		th1.start();
		th2.start();
		
		//재정의 run() 실행은 순차적 실행
		/*
		 * th1.run(); 
		 * th2.run();
		 */
		
		System.out.println("━━━━━━━━ 메인 쓰레드 실행 끝 ━━━━━━━━━");
		
	}//main end
}//class Main01 end

//1. Thread 클래스를 상속받는 클래스를 정의
class AddThread extends Thread{
	//2. 정의한 클래스에서 run() 메소드 재정의 ▶ 쓰레드가 할일 작성
	@Override
	public void run() {		//덧셈을 10번 반복하기
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("쓰레드 ID : "+this.getId());
			System.out.println(" sum = "+(sum+=i));
			//쓰레드 실행을 늦추기 위해서 0.5초 쓰레드 중지해봅니다.
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		System.out.println("쓰레드 이름 : "+this.getName()+"\n━━━━━━━━━ 쓰레드 실행 끝 ━━━━━━━━━");
	}
	
}//class AddThread end

//1. Thread 클래스를 상속받는 클래스를 정의
class SubtractThread extends Thread{
	//2. 정의한 클래스에서 run() 메소드 재정의 ▶ 쓰레드가 할일 작성
	@Override
	public void run() {		//뺄셈을 10번 반복하기
		int sum = 100;
		for (int i = 0; i < 10; i++) {
			System.out.print("쓰레드 ID : "+this.getId());
			System.out.println(" sum = "+(sum-=i));
			//쓰레드 실행을 늦추기 위해서 0.5초 쓰레드 중지해봅니다.
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		System.out.println("쓰레드 ID : "+this.getName()+"\n━━━━━━━━━ 쓰레드 실행 끝 ━━━━━━━━━");
	}
}//class SubstracThread end
