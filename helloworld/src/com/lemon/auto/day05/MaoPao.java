package com.lemon.auto.day05;

public class MaoPao {
	public static void main(String[] args){
	 int score[] = {4,1,3,2,5};
       for (int i = 0; i < score.length -1; i++){//最多做n-1趟排序
          for(int j = 0 ;j < score.length - i - 1; j++){
	         if(score[j] > score[j + 1]){ //把小的值交换到前面
                  int temp = score[j];
                  score[j] = score[j + 1];
                  score[j + 1] = temp;
            }
        }            
       }     
//         for(int a = 0; a < score.length; a++){
//         System.out.println(score[a]);
//	}
       for(int a:score){
    	   System.out.println(a);
    
      }

}
}
