

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.List;


record DataEntry(LocalDate date, int value1, int value2, int value3) {}

interface Observer {
    void update();
}


interface Subject {

    public void addObserver(Observer observer) ;
    public void removeObserver(Observer observer) ;

    public void notifyObservers() ;
    public int getHumidity();
    public int getTemperature();
    public int getPressure();

}


class ForecastDisplay implements Observer {

    Subject subject;

    public ForecastDisplay(Subject subject) {
        this.subject = subject;
    }


    public void displayPredictions(){
        System.out.println("Forecast Display");
        System.out.println("Date: " + LocalDate.now().toString() );
        System.out.println("it will rain!!! Bring umbrella!");
    }

    public void update()
    {
        System.out.println("");
        displayPredictions();
    }

}



class CurrentConditions implements Observer {

    Subject subject;

    public CurrentConditions(Subject subject) {
        this.subject = subject;
    }


    public void display()
    {
        System.out.println("Current conditions: ");
        System.out.println(subject.getHumidity());
        System.out.println(subject.getTemperature());
        System.out.println(subject.getPressure());
    }

    public void update()
    {
        display();
    }

}

class StatisticsDisplay implements Observer {


    Subject subject;
    List<DataEntry> dataList = new ArrayList<>();

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
        dataList.add(new DataEntry(LocalDate.now(), 0, 0, 0));
    }

    public void displayStats()
    {
        for ( int i = 0 ; i < dataList.size() ; i++ )
        {
            System.out.println( dataList.get(i) );
        }
    }

    public void update()
    {
        dataList.add(new DataEntry(LocalDate.now(), subject.getHumidity(), subject.getPressure(), subject.getTemperature()));
    }

}


class WeatherData implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private int Humidity = 0;
    private int Temperature = 0;
    private int Pressure = 0;


    public void notifyObservers()
    {
        int n = observers.size();
        for ( int i = 0; i < n; i++ )
        {
            observers.get(i).update();
        }
    }



    public void ChangeHumidity(int humidity)
    {
        this.Humidity = humidity;
        notifyObservers();
    }

    public void ChangeTemperature(int temperature)
    {
        this.Temperature = temperature;
        notifyObservers();
    }

    public void Changepreassure(int preassure)
    {
        this.Pressure = preassure;
        notifyObservers();
    }



    public int getHumidity(){
        return Humidity;
    }
    public int getTemperature(){
        return Temperature;
    }
    public int getPressure(){
        return Pressure;
    }


    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }


}






