public class java519{
public static int max(int[] array) {
	System.out.println(array.length) ;
	int count=Integer.MIN_VALUE;// 初始化赋值为数组最小值
	for(int i=0;i<array.length-1;i++){
	if (array[i]<array[i+1])
	count=array[i+1];
	}
	return count;
	
}
public static int indexOf (int[] array,int key){
	System.out.println(array.length) ;
	for(int i=0;i<array.length-1;i++){
	if (array[i]=key)
		return i;
	else 
		return -1;
	}
	
}
public static double average (int[] scores){
	System.out.println(array.length) ;
	int sum=0;
	double avg;
	for(int i=0;i<array.length-1;i++){
	sum+=array[i];
	}
	avg=sum/length;
	return avg;
}

public static void main (String[] args){
int [] array={1,3,5,7,9,2,4,6,8,19};
int maxValue=max(array);
System.out.println("最大值是"+maxValue);
int index=indexOf(array,19);
System.out.println("19的下标是"+index);

double averageScore= average(array);
System.out.println("平均分是"+averageScore);


}
}