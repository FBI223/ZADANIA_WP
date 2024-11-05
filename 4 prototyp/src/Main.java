

import java.util.Vector;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        Vector<Multimedia> my_multimedia = new Vector<>();

        Picture zdjecie = new Picture("zdjecie.jpg");
        zdjecie.data[0] = 10;
        my_multimedia.add(zdjecie);

        Movie film = new Movie("film.mov");
        film.data[0] = 20;
        my_multimedia.add(film);

        Music muzyka = new Music("muzyka.mp3");
        muzyka.data[0] = 30;
        my_multimedia.add(muzyka);


        Vector<Multimedia> my_multimedia_copy = new Vector<>();

        for (Iterator<Multimedia> it = my_multimedia.iterator(); it.hasNext();) {
            my_multimedia_copy.add(it.next().clone());
        }

        for (Iterator<Multimedia> it = my_multimedia_copy.iterator(); it.hasNext();) {
            it.next().print();
        }




    }
}