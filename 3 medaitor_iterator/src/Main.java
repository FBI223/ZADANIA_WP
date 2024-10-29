

import java.util.Iterator;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        // Tworzymy komponenty
        OrderLogger logger = new OrderLogger(null);  // Ustawimy mediator po utworzeniu instancji
        OrderVerifier verifier = new OrderVerifier(null);
        OrderMaker maker = new OrderMaker(null);
        OrderReciever reciever = new OrderReciever(null);

        // Tworzymy mediator i ustawiamy mediator dla komponentów
        OrderMediator mediator = new OrderMediator(verifier, maker, reciever, logger);
        verifier.setMediator(mediator);
        maker.setMediator(mediator);
        reciever.setMediator(mediator);
        logger.setMediator(mediator);

        // Testujemy przepływ zamówienia i logowanie
        reciever.OrderRecieved();  // Wywołuje zapis "Order was Recieved" do pliku
        verifier.OrderVerified();  // Wywołuje zapis "Order was Verified" do pliku
        maker.OrderMade();         // Wywołuje zapis "Order was Made" do pliku
    }
}


