package LinkedInQuestions;

/**
 * Created by rmukherj on 7/24/16.
 */
public class PrintFactorMultiplier {

    public int printFactorMul(int value){
        if(value <1){
            throw new IllegalArgumentException("value cannot be 0");

        }

        for(int i=1;value >=i*i;i++){
            int j = 0;
            if((value)%i==0){
                j=value/i;
                //Console.WriteLine("{0}*{1}",i,j);
                System.out.println("i = "+i + "j is "+j);
            }
        }

        return value;
    }
}
