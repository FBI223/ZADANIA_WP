public class Adapter implements Vehicle {
    public LegacyCar legacyCar;

    public Adapter(LegacyCar legacyCar) {
        this.legacyCar = legacyCar;
    }
    @Override
    public void moveTo(int xx , int yy )  // przesuniecie do punktu
    {
        int x_przed = legacyCar.x;
        int y_przed = legacyCar.y;

        int x_w = xx - x_przed;
        int y_w = yy - y_przed;

        legacyCar.drive(x_w, y_w);
    }

}
