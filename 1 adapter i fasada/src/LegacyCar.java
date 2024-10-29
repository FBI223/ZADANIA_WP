public class LegacyCar
{
    public int x;
    public int y;

    public LegacyCar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drive(int x1, int y1) {
        this.x += x1;
        this.y += y1;
    }

}
