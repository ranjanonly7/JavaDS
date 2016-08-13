package tryingsomething;

/**
 * Created by rmukherj on 8/3/16.
 */
public class PalindromeNo {

    public int reverse(int num){
        assert num>=0;
        int rev = 0;
        while (num!=0){
            rev = rev*10+num%10;
            num = num/10;

        }

        return rev;
    }

    public static void main(String[] args){
        PalindromeNo p = new PalindromeNo();
        int nn = 1441;
         nn = p.reverse(1442);
        System.out.println(nn);

    }
}
