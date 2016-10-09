package by.bsu;

import java.util.*;
public class Main {
    public static void main(String[] args){
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = sc.nextInt();
        int curr;
        while(number!= 0){
            arr[number%10]++;
            number/=10;
        }
        if(isPalindrome(arr)){
            System.out.println("Максимально возможный палиндром из цифр данного числа: ");
            System.out.println(setPalindrome(arr));
        }
        else{
            System.out.println("Составление палиндрома из цифр данного числа невозможно.");
        }

    }
    private static boolean isPalindrome(int []mas)
    {
        boolean check1 = true;
        boolean check2 = true;
        for(int i = 0; i<mas.length; i++) {
            if (mas[i]%2 == 1 && !check1) check2 = false;
            if( mas[i]%2 == 1) check1 = false;


        }
        return check2;
    }

    private static int setPalindrome(int []arr){
        int maxPalin = 0;
        int midValue = -1;

        for(int i = 9; i>=0; i--) {
            if (arr[i]%2 == 1) midValue = i;
            for (int j = 0; j < arr[i]/2; j++) {
                maxPalin = maxPalin * 10 + i;
            }
        }
        if(midValue != -1) {
            maxPalin = maxPalin * 10 + midValue;
        }
        for(int i = 0; i<=9; i++) {
            for (int j = 0; j < arr[i]/2; j++) {
                maxPalin = maxPalin * 10 + i;
            }
        }
        return maxPalin;
    }

}
