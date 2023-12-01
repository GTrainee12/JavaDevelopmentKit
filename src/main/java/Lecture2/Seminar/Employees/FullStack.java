package Lecture2.Seminar.Employees;

public class FullStack extends Developer implements BackendAction, FrontAction{
    @Override
    public void back() {

    }

    @Override
    public void front() {

    }

    @Override
    public void developGUI() {
        System.out.println("FullStack GUI method");
    }
}
