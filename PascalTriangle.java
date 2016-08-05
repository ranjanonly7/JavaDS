package tryingsomething;

/**
 * Created by rmukherj on 8/4/16.
 */
public class PascalTriangle {
    public static void print(int n){
        for(int i=0;i<n;i++){
            for (int j=0j<=i;j++){
                System.out.println(pascal(i,j) + " ");
            }

            System.out.println();
        }
    }

    public static int pascal(int i, int j){
        if(j==0) {
            return i;
        } else if(j==i){
            return i;
        }
        else
        {

        }
    }
}
