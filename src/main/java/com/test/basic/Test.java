package com.test.basic;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1171853  2014-04-04 15:48:32
		System.out.println(new DateTime(1396756800000l,DateTimeZone.forID("US/Pacific")));  //1396756800000
		
		System.out.println(new DateTime(1396756800000l,DateTimeZone.UTC));  //1396756800000
		
		DateTime dateTime=new DateTime(DateTimeZone.UTC);
		Date date=dateTime.toDate();
		System.out.println(dateTime+"  "+date.getTime());
		System.out.println(new DateTime(date.getTime(),DateTimeZone.forID("US/Pacific")));
		
		 long stMills=System.currentTimeMillis();
		 long endMills=System.currentTimeMillis();
		 System.out.println(endMills-stMills);
		
	}

}
