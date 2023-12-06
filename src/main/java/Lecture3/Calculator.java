package Lecture3;

public class Calculator {
    public static <T extends Number> T sum(T num1, T num2) {
    if (num1 instanceof Integer) {
        return (T) Integer.valueOf(num1.intValue() + num2.intValue());
    } else if (num1 instanceof Double) {
        return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
    } else if (num1 instanceof Float) {
        return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
    }

    throw new IllegalArgumentException("Unsupported number type");
}

        public static <T extends Number> T multiply(T num1, T num2) {
            if (num1 instanceof Integer) {
                return (T) Integer.valueOf(num1.intValue() * num2.intValue());
            } else if (num1 instanceof Double) {
                return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
            } else if (num1 instanceof Float) {
                return (T) Float.valueOf(num1.floatValue() * num2.floatValue());
            }

            throw new IllegalArgumentException("Unsupported number type");
        }

        public static <T extends Number> T divide(T num1, T num2) {
            if (num1 instanceof Integer) {
                return (T) Integer.valueOf(num1.intValue() / num2.intValue());
            } else if (num1 instanceof Double) {
                return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
            } else if (num1 instanceof Float) {
                return (T) Float.valueOf(num1.floatValue() / num2.floatValue());
            }

            throw new IllegalArgumentException("Unsupported number type");
        }

        public static <T extends Number> T subtract(T num1, T num2) {
            if (num1 instanceof Integer) {
                return (T) Integer.valueOf(num1.intValue() - num2.intValue());
            } else if (num1 instanceof Double) {
                return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
            } else if (num1 instanceof Float) {
                return (T) Float.valueOf(num1.floatValue() - num2.floatValue());
            }

            throw new IllegalArgumentException("Unsupported number type");
        }

    public static void main(String[] args) {
        Integer sumResult = Calculator.sum(25, 3);
        Double multiplyResult = Calculator.multiply(8.5, 2.5);
        Float divideResult = Calculator.divide(10.0f, 2.0f);
        Integer subtractResult = Calculator.subtract(8, 3);


        System.out.println("Sum: " + sumResult);
        System.out.println("Multiply: " + multiplyResult);
        System.out.println("Divide: " + divideResult);
        System.out.println("Subtract: " + subtractResult);
    }
}




