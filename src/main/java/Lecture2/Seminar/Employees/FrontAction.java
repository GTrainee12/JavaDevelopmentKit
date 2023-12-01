package Lecture2.Seminar.Employees;

public interface FrontAction {
    void front();
    default void cofee() {
        System.out.println("Drink");
    };
}
