package LinkedInQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ranjan on 7/24/16.
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 add(input) – Add the number input to an internal data structure.
 find(value) – Find if there exists any pair of numbers which sum is equal to the value.

 */
public class TwoSumFind {
    private Map<Integer, Integer> table = new HashMap<>();
    HashMap<Integer, Integer> hm = new HashMap<>();


    public void add(int input){
        int count = table.containsKey(input)?table.get(input):0;
        table.put(input,count+1);
    }

    public boolean find(int val){
        for(Map.Entry<Integer,Integer> entry: table.entrySet()){
            int num = entry.getKey();
            int y = val - num;
            if(y==num){
                if(entry.getValue()>=2){
                    return true;
                } else if(table.containsKey(y)){
                    return true;
                }

            }

        }

        return false;
    }

    /*
    Second Solution working
     */

    public void two_sum_prob_sum(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], arr[i]);
        }
    }

    public void two_sum_prob_find(int arr[], int sum){
        for(int i = 0; i<arr .length;i++){
            int lookFor = sum-arr [i];
            boolean hasValue = hm.containsValue(lookFor);
            if(hasValue){
                System.out.println("Found: "+arr[i]+"+"+ lookFor + "="+sum);
            }
        }
    }

    public static void main(String[] args){
        TwoSumFind tsw = new TwoSumFind();
        tsw.add(11);
        tsw.add(3);
        tsw.add(5);
        tsw.add(9);
        System.out.println(tsw.find(20));

        int[] arr = {1,3,5,9};
        int sum = 8;
        tsw.two_sum_prob_sum(arr);
        tsw.two_sum_prob_find(arr,sum);;
    }


}
