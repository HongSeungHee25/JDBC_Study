package partD.gui.rekiosk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NightClientEx {
	Socket client = null;	//서버와 통신하기 위한 클라이언트 소켓
	
	String ip;	//접속을 요청할 서버의 아이피주소를 저장할 변수
	static final int PORT = 7000;	//접속 요청할 서버와 동일한 포트번호
	
	BufferedReader reader;	//키보드로부터 메시지를 읽어올 입력 스트림
	
	InputStream is;	//서버가 보낸 데이터를 읽기 위한 입력 스트림 저장
	ObjectInputStream ois;	//서버로부터 데이터를 전송받기 (자료를 읽어들이기) 위한 입력 스트림
	
	OutputStream os;	//서버로 메시지를 보내기 위한 출력 스트림 저장
	ObjectOutputStream oos;	//서버에 데이터 (자료)를 전송하기 위한 출력 스트림
	
	String sendData;	//서버로 보낼 데이터를 저장하기 위한 변수
	String receiveData;	//서버로부터 받은 데이터를 저장하기 위한 변수
	
	public NightClientEx(String ip) {//생성자는 접속할 서버의 ip를 전달받음
		this.ip = ip;
		try {
			System.out.println("━━━━━ 클라이언트 (사용자) ━━━━━");
			
			//접속할 서버의 ip주소와 포트를 이용해서 클라이언트 소켓 생성
			client = new Socket(ip,PORT);	//서버 ip주소와 포트 번호를 생성자 인자값으로 전달해서 사용자단의 소켓 객체를 생성
			//클라이언트 소켓이 생성되는 순간 서버의 accept 메소드가 수행된다.
			
			//키보드로부터 메시지를 읽어올 입력 스트림 생성
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			//서버로 메시지를 보내기 위해서 클라이언트로부터 출력 스트림을 얻음
			os = client.getOutputStream();
			//출력 스트림을 ObjectOutputStream으로 변환한다
			oos = new ObjectOutputStream(os);
			
			//서버의 데이터를 수신받기 위해서 클라이언트로부터 입력 스트림을 얻어옴
			is = client.getInputStream();
			//입력 스트림을 ObjectInputStream으로 변환한다
			ois = new ObjectInputStream(is);
			
			//서버에게 보낼 데이터를 키보드에서 입력받기
			System.out.print("입력 ▷ ");
			//키보드로부터 데이터를 입력받음
			while((sendData = reader.readLine()) != null) {
				oos.writeObject(sendData);	//서버로 데이터를 전송함
				oos.flush();	//출력 스트림을 비움
				if(sendData.equals("quit")) break;	//quit 문자열이 입력되면 반복문 종료
				
				
				receiveData = (String)ois.readObject();	//스트림을 통해 데이터를 읽어 receiveData에 저장
				//서버가 보낸 데이터를 다시 받아서 출력(메아리처럼)
				
				System.out.println("["+client.getInetAddress()+"] 로 부터 받은 메시지 ▶ "+receiveData);
				System.out.print("입력 ▷ ");
			}
		} catch (Exception e) {
			System.out.println("예외 : "+e.getMessage());	//에러 메시지를 출력하고
			System.exit(0);	//프로그램을 종료한다
		} finally {
			try {
				//굳이 명시적으로 안해도 닫히긴 함
				if(is != null) is.close();
				if(ois != null) ois.close();
				if(os != null) os.close();
				if(oos != null) oos.close();
				if(client != null) client.close();
			} catch (Exception e2) {
				System.out.println("예외 : "+e2.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new NightClientEx("192.168.0.235");	//생성자 인자값으로 서버 ip주소
		//내 자신이기때문에 모든 내 자신 컴을 뜻하는 localhost 대입
		//두대의 컴퓨터에서는 저 ip주소 대신 에코서버가 실행되는 컴퓨터의 ip주소를 입력한다
	}
	
}//class