import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

interface CommandSet {
    void execute(int temp);
    void undo();
}

class Light {
    void turnOn() {
        System.out.println("Światło włączone");
    }
    void turnOff() {
        System.out.println("Światło wyłączone");
    }
}

class Shades{

    void pauseGoingSomewhere() {
        System.out.println("rolety zatrzymajcie sie");
    }

    void goingDown() {
        System.out.println("rolety do dolu");
    }
    void goingUp() {
        System.out.println("rolety do gory");
    }
}







class Memento {
    private final int state;

    public Memento(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}










class Thermostat{

    private int temp;


    public void setTemp(int temp  ) {
        System.out.println("temperature set to " + temp);
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public Memento save() {
        return new Memento(temp);
    }

    public void restore(Memento memento) {
        temp = memento.getState();
        System.out.println("temperature reset to " + temp);
    }

}




class HistoryOfThermostat {
    private List<Memento> history = new ArrayList<>();
    public int size;

    public Memento getLastVersion()
    {
        return history.getLast();
    }

    public void add(Memento memento) {
        history.add(memento);
        size++;
    }

    public void delete(Memento memento) {
        if ( history.contains(memento) )
        {
            history.remove(memento);
            size--;
        }

    }

    public Memento get(int index) {
        return history.get(index);
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

}










class TurnOnLightCommand implements Command {
    private final Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}



class TurnOffLightCommand implements Command {
    private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}








class TurnOnShadesCommand implements Command {
    private final Shades shades;

    TurnOnShadesCommand(Shades shades) {
        this.shades = shades;
    }

    @Override
    public void execute() {
        shades.goingUp();
    }

    @Override
    public void undo() {
        shades.goingDown();
    }
}



class TurnOffShadesCommand implements Command {
    private final Shades shades;

    TurnOffShadesCommand(Shades shades) {
        this.shades = shades;
    }

    @Override
    public void execute() {
        shades.goingDown();
    }

    @Override
    public void undo() {
        shades.goingUp();
    }
}



class StopShadesCommand implements Command {
    private final Shades shades;

    StopShadesCommand(Shades shades) {
        this.shades = shades;
    }

    @Override
    public void execute() {
        shades.pauseGoingSomewhere();
    }

    @Override
    public void undo() {
        shades.pauseGoingSomewhere();
    }
}





class SetTemperatureCommand implements CommandSet {
    Thermostat thermostat;
    HistoryOfThermostat history;


    SetTemperatureCommand(Thermostat thermostat ,HistoryOfThermostat history ) {
        this.thermostat = thermostat;
        this.history = history;
    }

    @Override
    public void execute(int temp) {
        history.add(thermostat.save()); // zapisanie aktualnego stanu przed zapisem
        thermostat.setTemp(temp);
    }

    @Override
    public void undo() {
        thermostat.setTemp(history.getLastVersion().getState());
        history.delete(history.getLastVersion());
    }
}







class RemoteControl {
    private Command command1;
    private Command command2;
    private Command command3;

    private CommandSet commandSet;

    public void setCommand1(Command command) {
        this.command1 = command;
    }

    public void setCommand2(Command command) {
        this.command2 = command;
    }

    public void setCommand3(Command command) {
        this.command3 = command;
    }

    public void setCommandSet(CommandSet command) {
        this.commandSet = command;
    }


    public void pressButton1() {
        command1.execute();
    }

    public void pressButton2() {
        command2.execute();
    }

    public void pressButton3() {
        command3.execute();
    }

    public void SetValue(int value) {
        commandSet.execute(value);
    }

    public void undoLastCommandSet() {
        commandSet.undo();
    }


}














public class ConcreteCommand {

    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl();



        Light light = new Light();

        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);


        remote.setCommand1(turnOn);
        remote.pressButton1();

        remote.setCommand2(turnOff);
        remote.pressButton2();








        Shades shades = new Shades();


        Command goUp = new TurnOnShadesCommand(shades);
        Command goDown = new TurnOffShadesCommand(shades);
        Command stop = new StopShadesCommand(shades);


        remote.setCommand1(goUp);
        remote.pressButton1();

        remote.setCommand2(goDown);
        remote.pressButton2();

        remote.setCommand3(stop);
        remote.pressButton3();






        Thermostat thermostat = new Thermostat();
        HistoryOfThermostat history = new HistoryOfThermostat();

        CommandSet commandSet = new SetTemperatureCommand(thermostat,history);
        remote.setCommandSet(commandSet);



        remote.SetValue(18);
        remote.SetValue(20);
        remote.SetValue(22);
        remote.undoLastCommandSet();
        remote.undoLastCommandSet();
        remote.SetValue(30);








    }

}











