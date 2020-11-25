package com.csy.www.exercise;


import java.util.Scanner;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

public class SingleNum {
    Scanner scanner = new Scanner(System.in);

    public Integer getText(){
        String inputText = scanner.nextLine().toString();

            String arrayText = inputText.substring(1,inputText.length()-1);
            String[] arr  = arrayText.split(",");
            int[] array = new int[ arr.length];
            for (int i = 0; i <  arr.length; i++) {
                array[i] = Integer.parseInt(arr[i]);
            }

            if(array.length==1){
                return array[0];
            }

            int sample = array[0];
            for (int j = 0; j < array.length; j++) {


            for (int i = 0; i < array.length; i++) {
                if(array[i]==sample ){
                    if(i==j&&i!=array.length-1){
                        continue;
                    }else if(i!=j){
                        sample = array[j+1];
                        break;
                    }else if(i==array.length-1){
                        return sample;
                    }
                }
                if(i!=array.length-1){
                  continue;
                }
                return sample;
                }

            }
            return null;
        }

    public static void main(String[] args) {
        SingleNum test = new SingleNum();

        System.out.println(test.getText());

    }


}
