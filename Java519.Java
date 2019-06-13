public class java519{
public static int max(int[] array) {
	int count=Integer.MIN_VALUE;// 初始化赋值为数组最小值
	for(int i=0;i<array.length;i++){
	if (array[i]>count)
	count=array[i];
	}
	return count;
	
}
public static int indexOf (int[] array,int key){
	for(int i=0;i<array.length;i++){
	if (array[i]==key){
		return i;
		}
	}
		return (-1);
}
public static double average (int[] array){
	int sum=0;
	double avg;
	int max=Integer.MAX_VALUE;
	int min=Integer.MIN_VALUE;
	//for(int i=0;i<array.length;i++){
	//if (array[i]>max)
	//max=array[i];
	//}
	//for(int i=0;i<array.length;i++){
	//if (array[i]<min)
	//min=array[i];
	//}
	for(int i=0;i<array.length-1;i++){
	sum+=array[i];
	}
	sum=sum-min-max;
	int leg=array.length-2;
	avg=((double)sum /leg);
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