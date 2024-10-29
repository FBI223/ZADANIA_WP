import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

interface Mediator {
    void notify(Component sender ,String event);
}



abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

class OrderReciever extends Component {
    public OrderReciever(Mediator mediator) {
        this.mediator = mediator;
    }

    public void OrderRecieved() {
        mediator.notify(this, "Order Recieved");
    }

}

class OrderVerifier extends Component {
    public OrderVerifier(Mediator mediator) {
        this.mediator = mediator;
    }

    public void OrderVerified() {
        mediator.notify(this, "Order Verified");
    }


}

class OrderMaker extends Component {
    public OrderMaker(Mediator mediator) {
        this.mediator = mediator;
    }
    public void OrderMade() {
        mediator.notify(this, "Order Made");
    }


}

class OrderLogger extends Component {
    List<String> logs = new ArrayList<>();  // Przypisujemy listę do pola klasy

    public OrderLogger(Mediator mediator) {
        this.mediator = mediator;
    }

    public void OrderSaved() {
        mediator.notify(this, "saving logs");
    }

    public void SaveLogs() {
        try (FileWriter writer = new FileWriter("logs.txt", true)) {
            String content = String.join(",", logs);
            writer.write(content + "\n");
            System.out.println("Logs appended to logs.txt successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while saving logs: " + e.getMessage());
        }
    }
}

class OrderMediator implements Mediator {

    private OrderVerifier verifier;
    private OrderMaker maker;
    private OrderReciever reciever;
    private OrderLogger logger;


    OrderMediator(OrderVerifier verifier , OrderMaker maker , OrderReciever reciever , OrderLogger logger) {
        this.verifier = verifier;
        this.maker = maker;
        this.reciever = reciever;
        this.logger = logger;
    }

    @Override
    public void notify(Component sender ,String event){
        if (sender instanceof OrderMaker && event.equals("Order Made")) {
            this.logger.logs.add("Order was Made");
            this.logger.SaveLogs();
        } else if  ( sender instanceof OrderVerifier && event.equals("Order Verified") ) {
            this.logger.logs.add("Order was Verified");
            this.logger.SaveLogs();
        } else if ( sender instanceof OrderReciever && event.equals("Order Recieved") ) {
            this.logger.logs.add("Order was Recieved");
            this.logger.SaveLogs();
        }

    }
}

