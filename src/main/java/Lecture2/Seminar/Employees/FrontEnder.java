package Lecture2.Seminar.Employees;

public class FrontEnder extends Developer implements FrontAction{
    @Override
    public void front() {
        System.out.println("Sleep");
    }

    @Override
    public void developGUI() {
        System.out.println("FrontEnder GUI method");
    }
}
