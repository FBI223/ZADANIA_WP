import java.util.Stack;

interface Command {
    void execute();
}

interface CommandSet {
    void execute(int temp);
}

// Odbiorca
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









// Klasa Memento przechowuje stan
class Memento {
    private final int state;

    public Memento(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}

// Klasa Originator tworzy i przywraca Memento
class ThermostatEditor {
    private int content;

    public void setContent(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        content = memento.getState();
    }
}







class Thermostat{

    private int content;

    public void setContent(int content) {
        System.out.println("temperature set to " + content);
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        content = memento.getState();
    }
}




class History {
    private Stack<Memento> history = new Stack<>();

    public void save(Memento memento) {
        history.push(memento);
    }

    public Memento restoreLast() {
        if (!history.isEmpty()) {
            System.out.println(  "ustawienie ostatniej temp = " +  history.pop().getState());
            return history.pop();
        } else
        {
            System.out.println("no history");
        }
        return null;
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
}





class SetTemperatureCommand implements CommandSet {
    Thermostat thermostat;
    SetTemperatureCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public void execute(int temp) {
        thermostat.setContent(temp);
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

        CommandSet commandSet = new SetTemperatureCommand(thermostat);
        remote.setCommandSet(commandSet);











    }

}











