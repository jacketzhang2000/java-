/*//1.功能
  //如何设计一个日期类
  //按年月日构造日期类
  //在当前日期上增加多少天
  //在当前日期上减少多少天
  /  /可以返回字符串  eg:"2019-05-20"
  //支持范围：1900-2100年
  //如果给定两个日期，算出所差天数
2.设计属性
int型 年月日

*/
public class Date{
	private int year;
	private int month;
	private int day;

	
	public Date(int year ,int month,int day){
		if(year<1900||year>2100){
			System.out.println("年不合法"+year);
			return;
		}
		if(month<1 ||month>12){
			System.out.println("月不合法"+month);
			return;
		}
		if(day<1||day>getDayofMonth(year,month)){
			System.out.println("日不合法"+day);
			return;
		}
		this.year=year;
		this.month=month;
		this.day=day;
	}
	private  Date (Date other){
		this(other.year,other.month,other.day);
	}
	public  void add(int days){
		if(days<0){
			System.out.println("days不合法"+days);
			return;
		}
		day+=days;
		 while (day >getDayofMonth(year,month)){
			 day-=getDayofMonth(year,month);
			 month++;
			 if(month>12){
				 month=1;
				 year++;
			 }
		 }
	}
	public void sub(int days){
		if(days<0){
			System.out.println("days不合法"+days);
			return;
		}
		day-=days;
		 while (day<1){
			 month--;
			 if(month<1){
				 month=12;
				 year--;
			 }
			 day+=getDayofMonth(year,month);
		 }
	}
	public String toString(){
		return String.format("%04d-%02d-%02d",year,month,day);
		
	}
	public static int differ(Date d1,Date d2){
		if(!isGreatThan(d1,d2)){
			System.out.println("d1必须大于d2");
			return (-1);
		}
		int days=0;
		Date tmp = new Date (d1);
		while (isGreatThan(tmp,d2)){
			tmp.sub(1);
			days++;
		}
		return days;
	}
	//内部使用方法
	
	private static final int[] DAY_OF_MONTH= {31,28,31,30,31,30,31,31,30,31,30,31};
    private static int getDayofMonth(int year,int month){
		int days=DAY_OF_MONTH[month-1];
		if (month==2&&isLeapYear(year)){
			days=29;
		}
		return days;
	}
	private static boolean isLeapYear(int year){
		if (year%4==0&&year%100!=0|| year%400==0){
			return true;
		}
		return false;
	}
	private static boolean isGreatThan (Date d1,Date d2){
		if (d1.year>d2.year){
			return true;
		}
		if(d1.year==d2.year&&d1.month>d2.month){
			return true;
		}
		if (d1.year==d2.year&&d1.month==d2.month&&d1.day>d2.day){
			return true;
		}
		return false;
	}
	public static void main (String[] args){
		Date date =new Date(2019,5,21);
		System.out.println(date.toString());
		date.add(10);
		System.out.println(date.toString());
		date.sub(50);
		System.out.println(date.toString());
		Date today=new Date (2019,5,21);
		Date intern=new Date (2019,10,1);
		System.out.printf("距国庆还有%d天%n",Date.differ(intern,today));
	}
}