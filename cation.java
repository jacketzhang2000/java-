/*
public class cation{
//计算n的位数，n一定为正数	
public static int calcDigitNum (long n) {
int  digitNum=0;
while (n>0)
{
	n=n/10;
	digitNum++;
}
return digitNum;
}

//pubilc stactic int factorial(int n)
public static void main (String[] args)
{
	//long n=Long.parseLong(long 
int m =calcDigitNum(1234);
System.out.printf("%d",m);
}
}
*/
/*
public class cation{
//计算n阶乘
public static int calcDigitNum1 (int n) {
if (n==1){
	return 1;
}
else {
	return n*calcDigitNum1(n-1);
}
}
public static long calcDigitNum2 (int n) {
	long fact=1;
for (int i=1;n>=i;i++)
{
	fact =fact*i;
}
return fact;
}
public static void main (String[] args)
{
long m =calcDigitNum1(5);
System.out.printf("%d",m);
long fact =calcDigitNum2(5);
System.out.printf("%d",fact);

}
}
*/
/*
public class cation{
//计算e=1+1/1!+1/2!+…+1/n!

public static long factorial (int n){
//求阶乘1.递归 2.循环
if (n==1|n==0){
	return 1;
}
else {
	return n*factorial(n-1);
}
}
public static double calcE(int n) {
//加法
double sum =0.0;
int j=1;
for (int i=0;i<n;i++)
{
	sum =j*(sum+1.0/factorial( i)) ;
	j=j*-1;
}
return sum;
}

public static void main (String[] args){
long m=factorial(5);
System.out.printf("%d%n",m);
double sum=calcE(5);
System.out.printf("%f",sum);
}
}
*/

public class cation{
//反转字符串

public static String reverse (String s){
	int length=s.length();
	String r="";
	for (int i=length-1 ;i>=0;i--)
	{
		char ch =s.charAt(i);
		r=r+ch;
	}
	return r;
}
public static String decToHex(int dec ) {
	//10进制变为16进制
	String hex ="";
	while (dec>=16)
	{
		int remainder =dec%16;
		dec=dec/16;
		if(remainder<10) {
			hex=hex+remainder;
		}
		else {
			char ch=(char )('A'+(remainder-10));
			hex=hex+ch;
		}
		
	}
	return reverse (hex);
}

public static void main (String[] args){
String message ="Hello";
String r=reverse (message);
System.out.printf(r);
//反转为“olleH"
System.out.printf(decToHex(212324));
}
}