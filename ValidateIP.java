package LinkedInQuestions.Networking;

import java.util.regex.Pattern;

/**
 * Created by rmukherj on 8/10/16.
 */
public class ValidateIP {

        public static final String DELIM = "\\.";

        private boolean isValidIP(String ip) {
            if(ip == null || "".equals(ip.trim())) {
                return false;
            }

            String[] parts = ip.split(DELIM);

            if(parts.length != 4) {
                return false;
            }

            for(String part : parts) {
                try {
                    int intVal = Integer.parseInt(part);
                    if(intVal < 0 || intVal > 255) {
                        return false;
                    }

                } catch(NumberFormatException nfe) {
                    return false;
                }
            }

            return true;
        }

        /*
        Based on regex
         */
        private static final Pattern PATTERN = Pattern.compile(
                "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }

        public static void main(String[] args) {
            String ip1 = "128.0.0.1";
            String ip2 = "125.16.100.1";
            String ip3 = "125.512.100.1";
            String ip4 = "125.512.100.abc";
            String ip5 = " ";
            String ip6 = null;
            ValidateIP validator = new ValidateIP();
            System.out.println(validator.isValidIP(ip1));
            System.out.println(validator.isValidIP(ip2));
            System.out.println(validator.isValidIP(ip3));
            System.out.println(validator.isValidIP(ip4));
            System.out.println(validator.isValidIP(ip5));
            System.out.println(validator.isValidIP(ip6));
        }

    }

