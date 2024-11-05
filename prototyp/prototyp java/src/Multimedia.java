

public abstract class Multimedia {
    protected String title;
    protected int[] data;

    protected abstract Multimedia clone();
    protected abstract void print();


    Multimedia(String title) {
        this.title = title;
        this.data = new int[1];
        this.data[0] = -1;
    }


    Multimedia(String title, int[] data_in) {
        this.title = title;
        this.data = new int[data_in.length];
        this.data = data_in.clone();
    }


    public Multimedia(Multimedia other) {
        this.title = other.title;
        this.data = new int[other.data.length];
        for ( int i = 0; i < other.data.length; i++ ) {
            data[i] = other.data[i];
        }
    }

    public Multimedia() {
        this.title = "name";
        this.data = new int[] {0};
    }
}



class Music extends Multimedia {


    public Music(String title)
    {
        super(title);
    }


    public Music(Music other)
    {
        super(other);
    }

    @Override
    public Music clone() {
        return new Music(this);
    }

    @Override
    public void print() {
        System.out.println("muzyka : "+this.title + " moje id to " + this.data[0] );
    }

}

class Picture extends Multimedia {

    public Picture(String title)
    {
        super(title);
    }


    public Picture(Picture other)
    {
        super(other);
    }

    @Override
    public Picture clone() {
        return new Picture(this);
    }


    @Override
    public void print() {
        System.out.println("picture : " +this.title + " moje id to " + this.data[0] );
    }

}

class Movie extends Multimedia {


    public Movie(String title)
    {
        super(title);
    }

    public Movie(Movie other)
    {
        super(other);
    }

    @Override
    public Movie clone() {
        return new Movie(this);
    }

    @Override
    public void print() {
        System.out.println("movie : " +this.title + " moje id to " + this.data[0] );
    }

}

