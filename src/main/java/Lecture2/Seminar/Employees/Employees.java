package Lecture2.Seminar.Employees;

import java.util.ArrayList;

public class Employees {
    private final ArrayList<Developer> developers = new ArrayList<>();
    public void Employees() {

        developers.add(new FrontEnder());
        developers.add(new BackEnder());
        developers.add(new FullStack());
        developers.add(new FrontEnder());

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i) instanceof FrontEnder) {
                (developers.get(i)).developGUI();
            }
        }
    }
}
