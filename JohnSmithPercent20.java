package LinkedInQuestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rmukherj on 8/6/16.
 */
public class JohnSmithPercent20 {

    private void replaceSpace(String rep){
        Pattern p = Pattern.compile(" ");
        Matcher m = p.matcher(rep);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,"%20");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());

    }

    public void replacer(char[] str, int length){
        int spacecount =0, index;
        for(int i=0;i<length;i++){
            if(str[i] == ' '){
                spacecount++;
            }
        }

        index = length+ spacecount *2;
        if(length<str.length){
            str[length]= '\0';

        }

        for(int i=length-1;i>=0; i--){
            if(str[i] == ' '){
                str[index -1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }


    }

    public static String replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (int i=0 ; i< length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = length + 2 * spaceCount;

        str[newLength-1] = '\0'; // always forget here
        int step = 2;
        for(int i=length-1; i>=0 ; i--) {
            if(str[i] != ' ') {
                str[newLength-step] = str[i];
                step++;
            } else {
                str[newLength-step] = '0';
                str[newLength-step-1] = '2';
                str[newLength-step-2] = '%';
                step = step + 3;
            }
        }
        return new String(str);
    }

    public static void main(String[] args){
        String s = "Mr John Smith";
        System.out.println(s.replace(" ", "%20"));
        JohnSmithPercent20 js = new JohnSmithPercent20();
        js.replaceSpace(s);
        //js.replacer(s.toCharArray(),s.length());
        js.replaceSpaces(s.toCharArray(),s.length());
    }
}
