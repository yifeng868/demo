package t1;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	/*1. 查询出当前星期的星期日是几号？*/
	@Test
	public void test() {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,1);//调整星期
		System.out.println("-----------------");
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String str=df.format(c.getTime());//c.getTime将日历转成日期
		////////////////////
		System.out.println(str);
	}
	
	/*5. 现有一个银行系统需要计算客户的还款日期，比如，客户贷
	款100万元从今天开始算起，分10期（还款频率为3个月一次）还清，请
	你设计一个方法计算出每个还款的日期是多少,并把日期显示为 
	“yyyy年MM月dd日” 的样子*/
	
	@Test
	public void test3() throws Exception {
		Calendar c=Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < 10; i++) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.MONTH, 3);//调整日期到3个月后的今天
		}
	}
	
/*	1. 在控制台打印出本月所有星期六的日期,按照yyyy年MM月dd日的格式输出!
	3. 计算得到今年的所有星期三的日期（显示为 “yyyy年MM月dd日” ）?*/
	@Test
	public void test1() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		//2018-8-13
		Calendar c=Calendar.getInstance();
		c.set(Calendar.MONTH,0);//8 改成1
		c.set(Calendar.DATE, 1);//13改成1
		//本月注释掉28行，while 取月份 判断是否7
		while (c.get(Calendar.YEAR)==2018) {
			if (c.get(Calendar.DAY_OF_WEEK)==4) {
				System.out.println(df.format(c.getTime()));
			}			
			c.add(Calendar.DATE, 1);//天数+1
		}
		
	}

	/*2. 将字符串"2011-7-18"表示的日期数据，使用java.util.Date进行封装，并继续下面要求 
	  （1）	格式化后的输出字符串"2011/07/18"，并输出为星期几
	  （2）	计算上面"2011-7-18"日期距离今天有多少天*/
	@Test
	public void test2() throws Exception {
		String str="2011-07-18";
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date  d=df.parse(str);//将字符串转成日期
		df=new SimpleDateFormat("yyyy/MM/dd");//重新设置日期格式
		System.out.println(df.format(d));//输出
		Calendar c=Calendar.getInstance();
		c.setTime(d);//将日期转成日历
		System.out.println(c.get(Calendar.DAY_OF_WEEK));//打印是星期几
	
	
	   //相隔多少天
		Date mydate=new Date();//今天
		long t=(mydate.getTime()-d.getTime())/(24*60*60*1000);
		System.out.println(t);
		
	
	}

	
}
