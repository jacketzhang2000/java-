import java.util.Arrays;

public class Seqlist {
	
	private int[]array;
	private int size;
	public Seqlist(){
		//this.array和array不同
		//申请空间至少要array.length长
		array=new int[11];	
		size=0;
	}
	public  void pushFront(int element){
		ensureCapacity();
		for(int i=size-1;i>=0;i--){
			array[i+1]=array[i];
		}
		array[0]=element;
		size++;
	}
	public void pushBack(int element){
		ensureCapacity();
		array[size++]=element;
	}
	
		//中间插入
		//要将[index,size-1]数据往后搬一格
		//倒着遍历
	public void insert (int index,int element){
		if (index<0||index>size){
			System.out.println("下标非法");
			return ;
		}
		
		for(int i=size;i>index;i--){
			array[i]=array[i-1];
		}
	array[index]=element;
	size++;
	}
	
			
		
	/*	
	public void insert (int index,int element){
	//先判断插入合法[0-size-1]
	if(index>size||index<0){
		System.out.println("index非法");
		return;
	}
		ensureCapacity();
		for (int i=size;i>index;i--){
			array[i]=array[i-1];//i空间的下标     数据：【i-1】
		}
		array[index]=element;
		size++;
			/*for (int i=0;i<size-index,i++){
			array[size-i]=array[size-i-1];//
			size++;
			头插：o(n)
			尾插：o(1)
			中间：o(n)
			*/
			*/
			
	}
	//头删
	public void popFront(){
		if(size==0){
			System.out.println("顺序表为空，无法删除");
		}
		for(int i=0;i<size-1;i++){
		array[i]=array[i+1];
		}
		array[--size]=0;//？
	} 
	//尾删
	public void popback(){
		if(size==0){
			System.out.println("顺序表为空，无法删除");
			return ;
		}
		array[--size]=0;
	}
	//中间删除
	public void erase(int index){
		if(size==0){
			System.out.println("顺序表为空，无法删除");
		}//?
		for (int i=index+1;i<size;i++){
			array[i-1]=array[i];//i空间的下标     数据：【i-1】
		}
		size--;
	}
	/*
		public void erase(int index){
	if (index<0||index>=size){
			System.out.println("下标非法");
			return ;	
	}
	for(i=index;i<size-1;i++){
		array[i]=array[i+1];
	}
	size--;
	array[size]=0;
	}
		*/
	//查找
	public int indexOf(int element){
		 for(int i=0;i<size;i++){
			 if(element==array[i]){
				 return i;
			 }
		 }
		 return (-1);
	}
	//根据下标，获取元素
	public int get(int index){
		if(index<0||index>=size){
			System.out.println("下标错误");
		}
		return array[index];
	}
	//给定下标，修改下标所在元素的值
	public void set(int index,int element){
		array[index]=element;
	}
	public int size(){
	return size;//防止用户修改长度？
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int capacity(){
		return array.length;
	}
	//便于打印，显示顺序表中已有元素
	public String toString(){
		return Arrays.toString(
		    Arrays.copyOf(array,size)
            );	
			
	}
	public void removeAll(int element){
		int j=0;
		for(int i=0;i<size;i++){
			if (array[i]!=element){
				array[j++]=array[i];
			}
		}
		size=j;
	}
	//内部使用方法  扩容
	private void ensureCapacity(){
		if(size<array.length){
			return ;
		}
		int newCapacity = array.length+array.length/2;
		int[] newArray=new int[newCapacity];
		for(int i=0;i<array.length;i++){
			newArray[i]=array[i];
		}
		this.array=newArray;
		
			
	}

	
	
	public static void main (String[] args){
	Seqlist seqlist=new Seqlist();
	System.out.println(seqlist.toString());
	seqlist.pushBack(1);
	seqlist.pushBack(2);
	seqlist.pushBack(3);
	//[1,2,3]
	System.out.println(seqlist.toString());
	seqlist.pushFront(8);
	seqlist.pushFront(9);
	seqlist.pushFront(10);
	System.out.println(seqlist.toString());
	//[10,9,8,1,2,3]
	seqlist.insert(2,5);
	seqlist.insert(5,7);
	System.out.println(seqlist.toString());
	//[10,9,5,8,1,7,2,3]
	
	
	
	
	
	
	}
}