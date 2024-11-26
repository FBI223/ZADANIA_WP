import java.util.ArrayList;
import java.util.List;

interface JagiellonianComponent
{
    int getHoursWorked();
    void showDetails(int depth);
}



class Employee implements JagiellonianComponent {
    String name;
    int hoursWorked;

    Employee(String name) {
        this.name = name;
        this.hoursWorked = 0;
    }


    void work_n_hours(int n_hours) {
        hoursWorked += n_hours;
    }

    @Override
    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public void showDetails(int depth) {
        String indent = " ".repeat(depth ); // Wcięcie: każda głębokość = 4 spacje
        System.out.println(indent + "Name of employee: " + name + " hours worked: " + hoursWorked + "\n" );
    }

}


class Unit implements JagiellonianComponent {
    String name;
    private List<JagiellonianComponent> components = new ArrayList<>();


    Unit(String name) {
        this.name = name;
    }

    void add(JagiellonianComponent component) {
        components.add(component);
    }

    void remove(JagiellonianComponent component) {
        components.remove(component);
    }

    @Override
    public int getHoursWorked() {
        int result = 0;
        for (JagiellonianComponent component : components) {
            result += component.getHoursWorked();
        }
        return result;
    }

    @Override
    public void showDetails(int depth) {
        String indent = " ".repeat(depth ); // Wcięcie: każda głębokość = 4 spacje
        System.out.println( indent + "Unit name : " + name + " contains " + components.size() + " components :\n");
        for (JagiellonianComponent component : components) {
            component.showDetails(depth+2);
        }
    }

}



