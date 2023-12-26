package Lecture6;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

public class Main {
    static double[] numberList = new double[]{6d, 4d, 12d, 16d, 100d};




    public static void main(String[] args) {
        System.out.println(ArithmeticUtils.factorial(5));
        System.out.println(ArithmeticUtils.lcm(8, 8));
        System.out.println(ArithmeticUtils.gcd(2, 6));
        System.out.println(ArithmeticUtils.isPowerOfTwo(18));
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(numberList);

        System.out.println(descriptiveStatistics.getMean());

    }
}