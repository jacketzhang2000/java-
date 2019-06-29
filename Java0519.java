public class java0519{
public static int binarySearch(int[] array, int key){
//二分
for (int i=0,j=array.length-1;j>i;){
	int half=(i+j)/2;
	//int half=i+(i+j)/2;
	if (array[half]>key){
	j=half-1;
	}
	else if (array[half]<key){
	i=half+1;
	}
	else {
		return half;
	}
}
return (-1);
}
public static void swap(int[] array1,int i,int j){
	int t=array1[j];
	array1[j]=array1[i];
	array1[i]=t;
}
public static void bubbleSort(int[] array1 ){
	int count=0;
	int leg=array1.length;
	for (int j=0;j<leg;j++){
		boolean isSwapped=false;//提升冒泡效率
		for (int i=0;i<leg-j-1;i++){
			if (array1[i]>array1[i+1]){
			//count=array1[j];
			//array1[j]=array1[i];
			//array1[i]=count;
			swap(array1,i,i+1);
			isSwapped=true;
			}
		}
		if(!isSwapped){
			return ;
		}
	}
}
public static void main (String[] args){
int [] array={1,3,5,7,9,15,20};
int [] array1=new int[]{9,8,7,6,5};
int index=binarySearch(array,7);
System.out.println("7所在的下标是："+index);
bubbleSort(array1);

for(int i=0;i<array1.length;i++)
{
	System.out.println(array1[i]);
}

}
}