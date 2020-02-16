package com.mypayrollmaster.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {

	private static String dateFormat = "dd/MM/yyyy";
	
	
	public static String convertDateToString(Date date)
	{
		return DateFormatUtils.format(date, dateFormat);
		 
	}
	public static Date convertStringToDate(String date) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		return sdf.parse(date);
		 
	}
}
