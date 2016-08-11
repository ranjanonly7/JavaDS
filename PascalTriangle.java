package tryingsomething;

/**
 * Created by rmukherj on 8/4/16.
 */
public class PascalTriangle {
    public static void print(int n){
        for(int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                System.out.println(pascal(i,j) + " ");
            }

            System.out.println();
        }
    }

    public static int pascal(int i, int j){
        if(j==0) {
            return 1;
        } else if(j==i){
            return 1;
        } else{
            return pascal(i-1,j-1)+pascal(i-1,j);
        }


    }

    public static void main(String[] args) {
        PascalTriangle pc = new PascalTriangle();
        pc.print(5);
    }
}
