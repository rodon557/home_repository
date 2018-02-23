package com.lemon.auto.day05;

public class MaopaoDemo {
	public  void Sort(){
		int a[]={4,1,3,2,5};
		for(int i=1;i<a.length;i++){
			for(int j=0;i<a.length-i;j++){
				if(a[j]>a[j+1]){
				 int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int i=1;i<a.length;i++){
			System.out.println(i);
		}
	}
   public static void main(String[] args){
	   MaopaoDemo mp = new MaopaoDemo();
	   mp.Sort();
	   
   }
}
