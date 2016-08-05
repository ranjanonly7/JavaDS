package LinkedInQuestions;

/**
 * Created by rmukherj on 7/24/16.
 */
public class PrintFactorMultiplier {

    public int printFactorMul(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("value cannot be 0");

        }

        for (int i = 1; value >= i * i; i++) {
            int j = 0;
            if ((value) % i == 0) {
                j = value / i;
                System.out.println("i = " + i + " j is " + j);
            }
        }

        return value;
    }

    private static void printFactor(int n) {
        if (n <= 0) {
            System.out.print("Wrong input!");
            return;
        }
        if (n == 1) {
            System.out.print("1");
            return;
        }
        long[] a = new long[n / 2];
        findFactor(n / 2, n, a, 0);

    }

    private static void findFactor(long i, long n, long[] arr, int index) {
        if (i == 1) {
            if (n == 1) {
                for (int k = 0; k < index - 1; k++) {
                    System.out.print(arr[k]);
                    if (k < index - 2) {
                        System.out.print("*");
                    }
                }

                System.out.println();

            }
            return;
        }
        for (long k = i; k >= 1; k--) {
            if (n % k == 0) {
                arr[index] = k;
                findFactor(k, n / k, arr, index + 1);
            }
        }
    }


    public static void PrintFactors(int number) {
        if (number <= 1) {
            return;
        }

        // Print the first set of factors
        System.out.println("" + number + " * 1");

        printFactorsHelper("", number, number);
    }

    private static void printFactorsHelper(String currExpression, int dividend, int previousFactor) {
        for (int factor = dividend - 1; factor >= 2; --factor) {
            if (dividend % factor == 0 && factor <= previousFactor) {
                // found 2 factors
                int nextFactor = dividend / factor;

                // try printing only if secondfactor is smaller (i.e. descending order)
                if (nextFactor <= factor) {
                    System.out.println(currExpression + factor + " * " + nextFactor);
                }

                printFactorsHelper(currExpression + factor + " * ", nextFactor, factor);
            }
        }
    }


    public static void main(String[] args) {
        PrintFactorMultiplier p = new PrintFactorMultiplier();
        p.printFactorMul(100);
       p.printFactor(100);
       //PrintFactors(100);


    }
}

