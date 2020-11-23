package day013.calendar;

import java.util.Calendar;

public class CalendarMain {
	public static void main(String[] args) {
	/*
		Calendar year month day
		Date					time
		
	*/
		//Calendar cal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance(); // 오늘에 해당하는 년월일
		
		// 날짜 가져오기
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11 이므로  + 1
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		// 날짜 설정
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 4 - 1); // 4월 == 4 - 1
		cal.set(Calendar.DATE, 13);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11 이므로  + 1
		day = cal.get(Calendar.DATE);
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		// 요일
		int weekDay = cal.get(Calendar.DAY_OF_WEEK); // 1 ~ 7(일요일 ~ 토요일)
		System.out.println("weekDay = " + weekDay);
		
		switch(weekDay) {
			case 1:
				System.out.println("일요일");
				break;
			case 2:
				System.out.println("월요일");
				break;
			case 3:
				System.out.println("화요일");
				break;
			default:
				System.out.println("수~토요일");
				break;
		}
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11 - 1);
		
		// 지정한 달의 마지막날
		int last_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("lastDay = " + last_day);
	// 달력 출력
		// 먼저 1일로 맞춰놓고 요일을 구한다.
		cal.set(Calendar.DATE, 1); // 2020년 11월 1일
		
		// 위쪽의 빈칸
		weekDay = cal.get(Calendar.DAY_OF_WEEK);
		int upSpace = (weekDay - 1) % 7; // 나머지 연산은 사실 필요없음
		System.out.println("윗쪽 빈칸 수: " + upSpace);
		
		// 그 달의 마지막 날짜를 구한다.
		last_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("lastDay = " + last_day);
		
		// 아래쪽 빈칸
		cal.set(Calendar.DATE, last_day);
		weekDay = cal.get(Calendar.DAY_OF_WEEK);
		int downSpace = 7 - weekDay;
		System.out.println("아래쪽 빈칸 수: " + downSpace);
		
		// 달력 출력
		year = 2020;
		month = 11;
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);
		
		int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int date = 1;
		
		System.out.println(year + "년 " + month + "월");
		System.out.println("==================================================");
		
		// - 요일 출력
		String weekString = "일월화수목금토";
		for(int i = 0; i < weekString.length(); i++) {
			char c = weekString.charAt(i);
			System.out.print(c + "\t");
		}
		System.out.println();
		System.out.println("==================================================");
		
		// - 윗쪽 빈칸
		for (int i = 1; i < startDayOfWeek; i++) {
			System.out.print("*\t");
		}
		
		// - 날짜
		for (int i = 0; i < lastDay; i++) {
			System.out.print(date + "\t");
			
			//개행
			if ((date + startDayOfWeek - 1) % 7 == 0) {
				System.out.println();
			}
			date++;
		}
		
		// - 아랫쪽 빈칸
//		for (int i = 0; i < (7 - (startDayOfWeek + lastDay - 1) % 7); i++) {
//		for (int i = 0; i < 7 - (lastDay % 7) - (startDayOfWeek - 1); i++) {
		for (int i = 0; i < 7 - (startDayOfWeek - 1 + lastDay) % 7; i++) {
			System.out.print("*\t");
		}
		System.out.println();		 
	}
}