package tryingsomething;

import java.util.Scanner;

/**
 * Created by rmukherj on 8/8/16.
 * Given an arry A of N integers, print each element in reverse order as a single line of
 * space separated integers.
 */
public class ArraysPractice {

    public static void main(String[] args){
        /*
        The below function is take the number of inouts into an array as per console.readline
        and then print reverse.
         */
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        s.nextLine();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i]= s.nextInt();
        }

        for(int i=size-1;i>0;i--){
            System.out.println(a[i]+" ");
        }
        System.out.println(a[0]);

        /*
        2D Array
        1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 9 2 -4 -4 0
0 0 0 -2 0 0
0 0 -1 -2 -4 0

         */

        int arr[][] = new int[6][6];
        Scanner sin = new Scanner(System.in);
        int max =  -10000;
        for (int i=0;i<6;i++)
        {
            for(int j =0 ;j<6;j++)
            {
                arr[i][j] = sin.nextInt();
            }

        }

        for (int i=0;i<4;i++)
        {
            for(int j =0 ;j<4;j++)
            {
                int output = sum(arr,i,j);
                max = max > output ? max: output ;
            }

        }

        System.out.println(max);

    }

    public static int sum(int[][] a,int i,int j)
    {
        int sum;
        sum = a[i][j] +
                a[i][j+1] +
                a[i][j+2] +
                a[i+1][j+1] +
                a[i+2][j] +
                a[i+2][j+1] +
                a[i+2][j+2];
        return sum;
    }



}
