package sk.viawebtour.www.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 操作时间工具类
 * @author cjduan
 *
 */
public class TimeUtil {
	
	/**
	 * 进行日期增加操作
	 * 
	 * @param currDate
	 * @param addDate
	 * @return
	 */
	public static Date addNMonth(Date currDate, Integer addDate) {
		Calendar now = Calendar.getInstance();
		now.setTime(currDate);
		now.add(Calendar.MONTH, addDate);
		return now.getTime();
	}
	
	/**
	 * 进行日期增加操作
	 * 
	 * @param currDate
	 * @param addDate
	 * @return
	 */
	public static Date addNDate(Date currDate, Integer addDate) {
		Calendar now = Calendar.getInstance();
		now.setTime(currDate);
		now.add(Calendar.DAY_OF_YEAR, addDate);
		return now.getTime();
	}

	/**
	 * 进行时间增加操作
	 * 
	 * @param currDate
	 * @param addHour
	 * @return
	 */
	public static Date addHour(Date currDate, Integer addHour) {
		Calendar now = Calendar.getInstance();
		now.setTime(currDate);
		now.add(Calendar.HOUR_OF_DAY, addHour);
		return now.getTime();
	}

	/**
	 * 进行时间增加操作
	 * 
	 * @param currDate
	 * @param addHour
	 * @return
	 */
	public static Date addYear(Date currDate, Integer addYear) {
		Calendar now = Calendar.getInstance();
		now.setTime(currDate);
		now.add(Calendar.YEAR, addYear);
		return now.getTime();
	}

	/**
	 * 进行时间增加操作
	 * 
	 * @param currDate
	 * @param addHour
	 * @return
	 */
	public static Date addMinute(Date currDate, Integer addMinute) {
		Calendar now = Calendar.getInstance();
		now.setTime(currDate);
		now.add(Calendar.MINUTE, addMinute);
		return now.getTime();
	}

	/**
	 * 进行秒钟增加操作
	 * 
	 * @param currDate
	 * @param addHour
	 * @return
	 */
	public static Date addSecond(Date currDate, Integer addSecond) {
		Calendar now = Calendar.getInstance();
		now.setTime(currDate);
		now.add(Calendar.SECOND, addSecond);
		return now.getTime();
	}
	
	/**
	 * 获取每天的0点
	 * 
	 * @return
	 */
	public static Date initCurrZeroDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date aDate = cal.getTime();
		cal = null;
		return aDate;
	}
	
	/**
	 * 时间格式化显示用
	 * 
	 * @param date
	 * @return 毫秒
	 */
	public static String formatDate(Date date) {
		if (null == date) {
			return null;
		}
		return String.valueOf(date.getTime());
	}
	
	/**
	 * Date to String
	 * @param date
	 * @param format
	 * @return
	 */
	public static String parseStr(Date date, String...format) {
		String time = new SimpleDateFormat(StringUtils.isEmpty(format) ? "yyyy-MM-dd HH:mm:ss" : format[0]).format(date);
		return time;
	}
	
	/**
	 * string to date
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date, String...format) throws ParseException {
		return new SimpleDateFormat(StringUtils.isEmpty(format) ? "yyyy-MM-dd HH:mm:ss" : format[0]).parse(date);
	}
	
	/**
	 * 格式化 字符串时间
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static String formatStr(String date, String...format) throws ParseException {
		return parseStr(parseDate(date, "yyyy-MM-dd HH:mm:ss"), format);
	}
	
	/**
	 * 获取当前分钟数
	 * @return
	 */
	public static int currMin() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.SECOND);
	}
	
	/**
	 * 格式化当前时间
	 * @param format
	 * @return
	 */
	public static String currDateStr(final String format) {
		String time = new SimpleDateFormat(format).format(new Date());
		return time;
	}

	public static String currDateStr() {
		String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return time;
	}
	
	public static String currDateStr2SS(Date date) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return time;
	}

	public static String currDateStr2SS(long timeLong) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(timeLong));
		return time;
	}
	
	/**
	 * 返回时间
	 * @param strValue
	 * @return
	 */
	public static Date stringToDate(String strValue) {
		if (StringUtils.isEmpty(strValue)) {
			return new Date();
		}
		SimpleDateFormat clsFormat = null;
		if (strValue.length() == 19)
			clsFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
		else if(strValue.length() > 19)
			clsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		else if (strValue.length() == 19)
			clsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		else if (strValue.length() == 10)
			clsFormat = new SimpleDateFormat("yyyy-MM-dd");
		else if (strValue.length() == 14)
			clsFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		else if (strValue.length() == 8)
			clsFormat = new SimpleDateFormat("yyyyMMdd");
		else if (strValue.length() == 16)
			clsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		else if (strValue.length() == 17)
			clsFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
		ParsePosition pos = new ParsePosition(0);
		if (!StringUtils.isEmpty(clsFormat)) {
			return clsFormat.parse(strValue, pos);
		}
		return new Date();
	}
	
	public static String convertEnMonthToDigital(String str) {
		if ("jan".equalsIgnoreCase(str)) {
			return "01";
		} else if ("feb".equalsIgnoreCase(str)) {
			return "02";
		} else if ("mar".equalsIgnoreCase(str)) {
			return "03";
		} else if ("apr".equalsIgnoreCase(str)) {
			return "04";
		} else if ("may".equalsIgnoreCase(str)) {
			return "05";
		} else if ("jun".equalsIgnoreCase(str)) {
			return "06";
		} else if ("jul".equalsIgnoreCase(str)) {
			return "07";
		} else if ("aug".equalsIgnoreCase(str)) {
			return "08";
		} else if ("sep".equalsIgnoreCase(str)) {
			return "09";
		} else if ("oct".equalsIgnoreCase(str)) {
			return "10";
		} else if ("nov".equalsIgnoreCase(str)) {
			return "11";
		} else {
			return "12";
		}
	}
	
	/**
	 * UTC 日期转换
	 * @param date
	 * @return
	 */
	public static Date getUTCDate(Date date) {
		return TimeUtil.addHour(date, 8); 
	}
	
	public static int daysBetween(String smdate, String bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate 较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		int day = Integer.parseInt(String.valueOf(between_days));
		return day >= 0 ? day + 1 : day;
	}
	
	public static int getSecInDay(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(time));
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min  = cal.get(Calendar.MINUTE);
		int sec  = cal.get(Calendar.SECOND);
		return hour * 3600 + min * 60 + sec;
	}
	
}
