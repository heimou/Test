package TestSocket;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * ���ڹ�����
 * 
 */
public class DateUtil {

	// private static Logger log = LoggerFactory.getLogger(DateUtil.class);

	private static String datePattern = "yyyy-MM-dd";

	private static String timePattern = "HH:mm";

	/**
	 * Return ȱʡ�����ڸ�ʽ (yyyy/MM/dd)
	 * 
	 * @return ��ҳ������ʾ�����ڸ�ʽ
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * �������ڸ�ʽ���������ڰ�datePattern��ʽת������ַ���
	 * 
	 * @param aDate
	 *            ���ڶ���
	 * @return ��ʽ��������ڵ�ҳ����ʾ�ַ���
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * �������ڸ�ʽ�����ַ�������Ϊ���ڶ���
	 * 
	 * @param aMask
	 *            �����ַ����ĸ�ʽ
	 * @param strDate
	 *            һ����aMask��ʽ���е����ڵ��ַ�������
	 * @return Date ����
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		// if (log.isDebugEnabled()) {
		// log.debug("converting '" + strDate + "' to date with mask '"
		// + aMask + "'");
		// }

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: yyyy/MM/dd HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: yyyy-MM-dd
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			// log.error("aDate is null!");
			return "aDate is null!";
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * �������ڸ�ʽ���������ڰ�datePattern��ʽת������ַ���
	 * 
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}

	/**
	 * �������ڸ�ʽ�����ַ�������Ϊ���ڶ���
	 * 
	 * @param strDate
	 *            (��ʽ yyyy-MM-dd)
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;

		try {
			// if (log.isDebugEnabled()) {
			// log.debug("converting date with pattern: " + datePattern);
			// }

			aDate = convertStringToDate(datePattern, strDate);
		} catch (ParseException pe) {
			// log.error("Could not convert '" + strDate
			// + "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}

		return aDate;
	}

	/**
	 * ʱ�����
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date dateAdd(Date date, int day) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}

	/**
	 * ��ȡ��������֮�������
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long dateDiffer(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / (1000 * 3600 * 24);
	}

	/**
	 * ȡ��ǰ����ʱ��
	 * 
	 * @return yyyy-mm-dd hh:mm:ss 2009-12-12 12:12:12
	 */
	public static String getNowDateTime() {
		DateFormat dataAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar rightNow = Calendar.getInstance();
		return dataAndTime.format(rightNow.getTime());
	}

	/**
	 * ȡ��ǰ����ʱ��
	 * 
	 * @return yyyy-mm-dd hh:mm:ss 2009-12-12 12:12:12
	 */
	public static String getNowDateTime(String pattern) {
		DateFormat dataAndTime = new SimpleDateFormat(pattern);
		Calendar rightNow = Calendar.getInstance();
		return dataAndTime.format(rightNow.getTime());
	}

	/**
	 * ȡ��ǰ����
	 * 
	 * @return yyyy 2009
	 */
	public static String getNowYear() {
		try {
			return getToday().get(Calendar.YEAR) + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * ȡ��ǰ����
	 * 
	 * @return yyyy 12
	 */
	public static String getNowMonth() {
		try {
			return getToday().get(Calendar.MONTH) + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * ȡ��ǰ����
	 * 
	 * @return yyyy 12
	 */
	public static String getNowDay() {
		try {
			return getToday().get(Calendar.DAY_OF_MONTH) + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * ��ȡһ������б�
	 * 
	 * @param startYear
	 * @param endYear
	 * @return List 2001 2002,2003,2004
	 */
	public static List<String> getConditionYearList(int startYear, int endYear) {
		List<String> list = new ArrayList<String>();
		if (startYear > endYear) {
			return list;
		}
		list.add(Integer.toString(startYear));
		for (int i = 1; i <= (endYear - startYear); i++) {
			list.add(Integer.toString(startYear + i));
		}
		return list;
	}

	/**
	 * 
	 * ��ȡ��ǰʱ��
	 * 
	 * @return
	 */
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}
	
	public static void main(String[]args){
		//ʱ���ʽת�� ����
		String req="[152]";
	
		System.out.println(req.replace("[", " ").replace("]", "").trim());
	}
}
