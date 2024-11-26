



interface Rower {
    String getDescription();
}

class RowerBasic implements Rower {
    String description = "Rower bazowy :";

    @Override
    public String getDescription() {
        return description;
    }
}



abstract class RowerDecorator implements Rower {
    protected Rower rower;

    RowerDecorator(Rower rower) {
        this.rower = rower;
    }

    @Override
    public String getDescription() {
        return rower.getDescription();
    }

}

class DzwonekDecorator extends RowerDecorator {
    DzwonekDecorator(Rower rower) {
        super(rower);
    }

    @Override
    public String getDescription() {
        return rower.getDescription();
    }
}

class SwiatloTylneDecorator extends RowerDecorator {
    SwiatloTylneDecorator(Rower rower) {
        super(rower);
    }

    @Override
    public String getDescription() {
        return rower.getDescription() + "\n-Swiatlo tylne";
    }
}


class SwiatloPrzednieDecorator extends RowerDecorator {
    SwiatloPrzednieDecorator(Rower rower) {
        super(rower);
    }


    @Override
    public String getDescription() {
        return rower.getDescription() + "\n-Swiatlo przednie";
    }

}



class LepszeSiodelkoDecorator extends RowerDecorator {
    LepszeSiodelkoDecorator(Rower rower) {
        super(rower);
    }

    @Override
    public String getDescription() {
        return rower.getDescription() + "\n-Lepsze siodelko";
    }
}



public class Main {
    public static void main(String[] args) {

            Rower basic = new RowerBasic();
            System.out.println(basic.getDescription());
            System.out.println();

            Rower rowerek = new RowerBasic();
            rowerek = new DzwonekDecorator(rowerek);
            rowerek = new SwiatloPrzednieDecorator(rowerek);
            rowerek = new SwiatloTylneDecorator(rowerek);
            rowerek = new LepszeSiodelkoDecorator(rowerek);


            System.out.println(rowerek.getDescription());


            System.out.println();
            System.out.println();System.out.println();System.out.println();
            System.out.println();



            Employee employee1 = new Employee("em1"  );
            Employee employee2 = new Employee("em2"  );
            Employee employee3 = new Employee("em3"  );
            Employee employee4 = new Employee("em4"  );
            Employee employee5 = new Employee("em5"  );
            Employee employee6 = new Employee("em6"  );

            employee1.work_n_hours(9);
            employee2.work_n_hours(8);
            employee3.work_n_hours(7);
            employee4.work_n_hours(6);
            employee5.work_n_hours(5);
            employee6.work_n_hours(4);

            Unit Wydzial = new Unit("Wydzial majzy");
            Unit Chair1 = new Unit("Katedra infy");
            Unit Chair2 = new Unit("Katedra majcy");
            Unit Zaklad1 = new Unit("Zaklad miesny");
            Unit Zaklad2 = new Unit("Zaklad inteligencji");


            Wydzial.add(Chair1);
            Wydzial.add(Chair2);

            Chair1.add(employee1);
            Chair2.add(employee2);

            Chair1.add(employee3);
            Chair2.add(employee4);

            Wydzial.add(Zaklad1);
            Zaklad1.add(employee5);

            Chair1.add(Zaklad2);
            Zaklad2.add(employee6);

            Wydzial.showDetails(0);


    }

}