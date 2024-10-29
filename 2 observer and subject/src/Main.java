//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        WeatherData wd = new WeatherData();

        wd.Changepreassure(1000);
        wd.ChangeHumidity(15);
        wd.ChangeTemperature(20);

        CurrentConditions cc = new CurrentConditions(wd);
        ForecastDisplay fd = new ForecastDisplay(wd);
        StatisticsDisplay sd = new StatisticsDisplay(wd);

        wd.addObserver(cc);
        wd.addObserver(fd);
        wd.addObserver(sd);


        wd.ChangeHumidity(90);
        System.out.println();
        wd.ChangeTemperature(22);


    }
}