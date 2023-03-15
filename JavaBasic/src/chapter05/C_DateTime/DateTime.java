package chapter05.C_DateTime;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

// 날짜 및 시간

public class DateTime {

	public static void main(String[] args) {
//		System.
//		현재 시간을 long타입으로 0.001초 단위로 표현
//		기준 1970년 1월 1일
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		
		for (int count = 0; count < 10000000; count++) {
			count++;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
//		Date class
//		날짜를 관리 해주는 클래스
//		주로 날짜와 관련된 데이텉입을 취급할 때 사용
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getMonth());
		
		date.setHours(date.getHours() + 2);
		System.out.println(date);
		
//		최신버전
		System.out.println("최신버전");
		Date now = Date.from(Instant.now());
		System.out.println(now);
		
		Date minusTwoHour = Date.from(Instant.now().minus(2, ChronoUnit.HOURS));
		System.out.println(minusTwoHour);
		
//		SimpleDateFormat
//		Date 타입의 참조변수를 지정한 포멧의 문자열로 변경해주는 클래스
//		y: 연, M: 월, d: 일, H: 시간, m: 분, s: 초
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd. HH:mm:ss");
		String formatedDate = simpleDateFormat.format(now);
		System.out.println(formatedDate);
		
//		Time Package
//		Date와 Calendar 클래스의 단점 보완 
		
//		LocalDate class
//		날짜를 관리해주는 class
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		LocalDate localDateOf = LocalDate.of(2022, 12, 25);
		System.out.println(localDateOf);
		
//		LocalTime class
//		시간을 관리해주는 class
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		LocalTime localTimeOf = LocalTime.of(12, 40);
		System.out.println(localTimeOf);
		
//		LocalDateTime class
//		날짜와 시간을 관리해주는 class
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		LocalDateTime localDateTimeOf = LocalDateTime.of(localDateOf, localTimeOf);
		System.out.println(localDateTimeOf);
		
//		특정 날짜 혹은 시간 가져오기
//		.getXXX();
		int year = localDateTime.getYear();
		System.out.println(year);
		int month = localDateTime.getMonthValue();
		System.out.println(month);
		Month enumMonth = localDateTime.getMonth();		// 현재 달 영문으로
		System.out.println(enumMonth);
		int dayOfYear = localDateTime.getDayOfYear();	// 이번년도에서 며칠째인지
		System.out.println(dayOfYear);
		int dayOfMonth = localDateTime.getDayOfMonth();	// 해당 달의 며칠째인지
		System.out.println(dayOfMonth);
		DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();	// 무슨 요일인지
		System.out.println(dayOfWeek);
		
		boolean isLeapYear = localDate.isLeapYear();	// 윤년 판별 해줌
		System.out.println(isLeapYear);
		
		int hour = localDateTime.getHour();
		int minute = localDateTime.getMinute();
		int second = localDateTime.getSecond();
		int nano = localDateTime.getNano();
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		System.out.println(nano);
				
//		특정 날짜 및 시간 변경 (직접 변경, 더하기, 빼지)
//		직접 변경 : withXXX(int 타입 데이터);
//		더하기 - 빼기 : plusXXX(long 타입 데이터), minusXXX(long 타입 데이터)
		localDateTime = localDateTime.withYear(2012).plusWeeks(4).minusHours(9);
		localDateTime = localDateTime.withDayOfYear(1).plusMinutes(50).minusNanos(50000);
		
		Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
		Date datetime = Date.from(instant);
		
		System.out.println(datetime);
		
		
	}

}
