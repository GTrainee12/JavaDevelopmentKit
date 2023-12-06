package Lecture3;

public record Pair<T, U>(T first, U second) {

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "Hello");
        System.out.println(pair1.first());
        System.out.println(pair1.second());
        System.out.println(pair1);

        Pair<String, Double> pair2 = new Pair<>("Java", 3.14);
        System.out.println(pair2.first());
        System.out.println(pair2.second());
        System.out.println(pair2);
    }
}

