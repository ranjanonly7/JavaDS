package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/12/16.
 */
public class ArrayRotation {

    public void rotateLeft(){
        int[] arr = {1,2,3,4,5,6,7,8};
        int orderToRotate = 2;

        for(int i=0;i<orderToRotate;i++){
            for(int j=arr.length-1;j>0;j--){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }

        }

        for(int j=0;j<arr.length;j++){
            System.out.println(arr[j]);
        }
    }

    private void optimizedRotateLeft(){
        int[] arr = {1,2,3,4,5,6,7,8};
        int order =2;

        int offset = arr.length - order%arr.length;
        if(offset>0){
            int[] copy = arr.clone();
            for(int i=0;i<arr.length;++i){
                int j= (i+offset)%arr.length;
                arr[i] = copy[j];
                System.out.print(arr[i]);
            }

        }


    }

    //rotate array using reverse strategy

    public void rotate(int[] nums, int k){
        k= k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);



    }

    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        ArrayRotation arr = new ArrayRotation();
        //arr.rotateLeft();
        //arr.optimizedRotateLeft();
        //arr.optimizedRotateLeft();
        int[] a = {1,2,3,4,5,6,7,8};
        arr.rotate(a,2);
        for(int j=0;j<a.length;j++){
            System.out.print(a[j]);
        }

    }
}
