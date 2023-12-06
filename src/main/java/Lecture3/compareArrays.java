package Lecture3;

public class compareArrays {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {1, 2, 3, 4, 5};
        System.out.println(compareArrays(array1, array2));

        String[] array3 = {"Hello", "World"};
        String[] array4 = {"Hello", "Java"};
        System.out.println(compareArrays(array3, array4));
    }
}