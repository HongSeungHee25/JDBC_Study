package Colors;

import ConsoleColors.ConsoleColors;

public class ColorTest {

	public static void main(String[] args) throws Exception {
		//깜박임 효과
//		 for (int i = 0; i < 10; i++) {
//	            System.out.print("\rBlinking Text");
//	            Thread.sleep(500);
//	            System.out.print("\r            ");
//	            Thread.sleep(500);
//	        }//FOR END
		 
		 ConsoleColors test = new ConsoleColors();
		 System.out.println(ConsoleColors.BLACK+"━━━━━━━━━━━━━ 검은색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.RED+"━━━━━━━━━━━━━ 빨간색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.GREEN+"━━━━━━━━━━━━━ 초록색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.YELLOW+"━━━━━━━━━━━━━ 노란색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BLUE+"━━━━━━━━━━━━━ 파란색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.PURPLE+"━━━━━━━━━━━━━ 보라색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.CYAN+"━━━━━━━━━━━━━ 청록색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.WHITE+"━━━━━━━━━━━━━ 흰색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.GRAY+"━━━━━━━━━━━━━ 회색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_RED +"━━━━━━━━━━━━━ 밝은 빨간색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_GREEN+"━━━━━━━━━━━━━ 밝은 초록색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_YELLOW+"━━━━━━━━━━━━━ 밝은 노란색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_BLUE+"━━━━━━━━━━━━━ 밝은 파란색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_MAGENTA+"━━━━━━━━━━━━━ 밝은 자주색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_CYAN+"━━━━━━━━━━━━━ 밝은 청록색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_GRAY+"━━━━━━━━━━━━━ 밝은 회색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_WHITE+"━━━━━━━━━━━━━ 밝은 흰색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_RED+"━━━━━━━━━━━━━ 어두운 빨간색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_GREEN+"━━━━━━━━━━━━━ 어두운 초록색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_YELLOW +"━━━━━━━━━━━━━ 어두운 노란색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_BLUE+"━━━━━━━━━━━━━ 어두운 파란색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_MAGENTA+"━━━━━━━━━━━━━ 어두운 자주색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_CYAN+"━━━━━━━━━━━━━ 어두운 청록색 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 
		 System.out.println("━".repeat(100));
		 
		 System.out.println(ConsoleColors.BOLD_RED+"━━━━━━━━━━━━━ 굵은 텍스트의 빨간색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_GREEN+"━━━━━━━━━━━━━ 굵은 텍스트의 초록색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_YELLOW+"━━━━━━━━━━━━━ 굵은 텍스트의 노란색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_BLUE+"━━━━━━━━━━━━━ 굵은 텍스트의 파란색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_MAGENTA+"━━━━━━━━━━━━━ 굵은 텍스트의 자주색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_CYAN+"━━━━━━━━━━━━━ 굵은 텍스트의 청록색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_WHITE+"━━━━━━━━━━━━━ 굵은 텍스트의 흰색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 
		 System.out.println("━".repeat(100));
		 
		 System.out.println(ConsoleColors.BLACK_BACKGROUND+"━━━━━━━━━━━━━ 검은 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.RED_BACKGROUND+"━━━━━━━━━━━━━ 빨간 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.GREEN_BACKGROUND+"━━━━━━━━━━━━━ 초록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.YELLOW_BACKGROUND+"━━━━━━━━━━━━━ 노란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BLUE_BACKGROUND+"━━━━━━━━━━━━━ 파란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.PURPLE_BACKGROUND+"━━━━━━━━━━━━━ 보라 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.CYAN_BACKGROUND+"━━━━━━━━━━━━━ 청록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.WHITE_BACKGROUND+"━━━━━━━━━━━━━ 흰색 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.GRAY_BACKGROUND+"━━━━━━━━━━━━━ 회색 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_RED_BACKGROUND +"━━━━━━━━━━━━━ 밝은 빨간 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND +"━━━━━━━━━━━━━ 밝은 초록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_YELLOW_BACKGROUND +"━━━━━━━━━━━━━ 밝은 노란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_BLUE_BACKGROUND +"━━━━━━━━━━━━━ 밝은 파란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_MAGENTA_BACKGROUND +"━━━━━━━━━━━━━ 밝은 자주 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_CYAN_BACKGROUND +"━━━━━━━━━━━━━ 밝은 청록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_WHITE_BACKGROUND +"━━━━━━━━━━━━━ 밝은 하얀 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.LIGHT_GRAY_BACKGROUND +"━━━━━━━━━━━━━ 밝은 회색 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_RED_BACKGROUND +"━━━━━━━━━━━━━ 어두운 빨간 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_GREEN_BACKGROUND +"━━━━━━━━━━━━━ 어두운 초록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_YELLOW_BACKGROUND +"━━━━━━━━━━━━━ 어두운 노란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_BLUE_BACKGROUND +"━━━━━━━━━━━━━ 어두운 파란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_MAGENTA_BACKGROUND +"━━━━━━━━━━━━━ 어두운 자주 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.DARK_CYAN_BACKGROUND +"━━━━━━━━━━━━━ 어두운 청록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 
		 System.out.println("━".repeat(100));
		 
		 System.out.println(ConsoleColors.BOLD_RED_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 빨간 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_GREEN_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 초록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_YELLOW_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 노란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_BLUE_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 파란 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_MAGENTA_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 자주 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_CYAN_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 청록 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_WHITE_BACKGROUND +"━━━━━━━━━━━━━ 텍스트 굵고 흰색 배경색 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 
		 System.out.println("━".repeat(100));
		 
		 System.out.println(ConsoleColors.BOLD +"━━━━━━━━━━━━━ 굵은 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.UNDERLINE +"━━━━━━━━━━━━━ 밀줄 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.REVERSED +"━━━━━━━━━━━━━ 반전된 텍스트(텍스트와 배경색이 반전됨) ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.THIN +"━━━━━━━━━━━━━ 얇은 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.ITALIC +"━━━━━━━━━━━━━ 이탤릭체 효과 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.FLICKER +"━━━━━━━━━━━━━ 깜박임 효과 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.FRAMED +"━━━━━━━━━━━━━ 텍스트 주위 테두리 생성 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.ENCIRCLED +"━━━━━━━━━━━━━ 텍스트를 원형으로 감싸는 효과 생성 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.OVERLINED +"━━━━━━━━━━━━━ 텍스트 위에 수평한 선 생성 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.STRIKETHROUGH +"━━━━━━━━━━━━━ 텍스트 취소선 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.BOLD_UNDERLINE +"━━━━━━━━━━━━━ 텍스트 굵게 표시하고 밑줄 추가 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.RAPID_BLINK +"━━━━━━━━━━━━━ 텍스트가 빠르게 깜박이는 효과 생성 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
		 System.out.println(ConsoleColors.HIDING +"━━━━━━━━━━━━━ 숨김 효과 텍스트 ━━━━━━━━━━━━━"+ConsoleColors.RESET);
	    }//MAIN END
	}//MAIN CLASS END
		
		
	