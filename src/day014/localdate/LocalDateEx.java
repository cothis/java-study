package localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateEx {
	public static void main(String[] args) {
		// 오늘에 해당하는 년월일
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate); // 2020-11-19
		
		// 날짜 가져오기
		int year = currentDate.getYear();
		Month monthEnum = currentDate.getMonth();
		int month = currentDate.getMonthValue();
		int day = currentDate.getDayOfMonth();
		DayOfWeek dayOfWeekEnum = currentDate.getDayOfWeek();
		int dayOfWeek = dayOfWeekEnum.getValue();
		
		System.out.println(year+"-"+month+"("+monthEnum+")-"+day+", "+dayOfWeek+"("+dayOfWeekEnum+")");
		
		// 날짜 설정
		LocalDate targetDate = LocalDate.of(2021, 3, 1);
		System.out.println(targetDate);
			
		// 요일
		DayOfWeek targetDow = targetDate.getDayOfWeek();
		System.out.println(targetDow);
		
		// 지정한 달의 마지막날	
		System.out.println(targetDate.getYear()+"년 "+targetDate.getMonthValue()+"월의 마지막 날: "+targetDate.lengthOfMonth());
		
		// 날짜 차이
		Period period = currentDate.until(targetDate);
		System.out.println("차이: "+period.getYears()+"년 "+period.getMonths()+"개월 "+period.getDays()+"일");
		
		// 초 차이
		System.out.println("날짜 차이: "+ChronoUnit.DAYS.between(currentDate, targetDate)+"일");
	}
}
