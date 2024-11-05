#include <iostream>
#include <string>
#include <vector>

using namespace std;





class Multimedia {
protected:
    string title;
    int *id;

public:
    virtual Multimedia* clone() const = 0 ;
    virtual void print() const  = 0;

    Multimedia(){
        title = "title";
        id = new int(0);
    }

    ~Multimedia(){
        delete id;
    }

    explicit Multimedia(const string& name){
        title = name;
        id = new int(0);
    }

    Multimedia(const string& name, int int_in){
        title = name;
        id = new int(int_in);
    }

    Multimedia(const Multimedia& other ){
        this->title = other.title;
        id = new int;
        *this->id = *other.id ;
    }

};


class Picture : public Multimedia {
public:
    Picture(const std::string& title, int int_in) : Multimedia(title,int_in) {}
    Picture(const Picture& other) : Multimedia(other) {}

    Multimedia* clone() const override {
        return new Picture(*this);
    }

    void print() const override {
        std::cout << "picture : " << title << " moje id to " << *id << std::endl;
    }
};

class Movie : public Multimedia {
public:
    Movie(const std::string& title , int int_in) : Multimedia(title,int_in) {}
    Movie(const Movie& other) : Multimedia(other) {}

    Multimedia* clone() const override {
        return new Movie(*this);
    }

    void print() const override {
        std::cout << "movie : " << title << " moje id to " << *id << std::endl;
    }
};


class Music : public Multimedia {
public:
    Music(const std::string& title , int int_in) : Multimedia(title,int_in) {}
    Music(const Music& other) : Multimedia(other) {}

    Multimedia* clone() const override {
        return new Music(*this);
    }

    void print() const override {
        std::cout << "music : " << title << " moje id to " << *id << std::endl;
    }
};




int main() {

    std::vector<Multimedia*> my_multimedia;

    Picture* zdjecie = new Picture("zdjecie",10) ;
    Movie* film =  new Movie("film",20) ;
    Music* muzyka = new Music("muzyka",30) ;



    my_multimedia.push_back(zdjecie);
    my_multimedia.push_back(film);
    my_multimedia.push_back(muzyka);
    std::vector<Multimedia*> multimedia_copy;
    for(std::vector<Multimedia*>::iterator it = my_multimedia.begin();
        it != my_multimedia.end();
        ++it)
    {
        multimedia_copy.push_back( (*it)->clone() );
    }
    for(std::vector<Multimedia*>::iterator it2 = my_multimedia.begin();
        it2 != my_multimedia.end();
        ++it2)
    {
        (*it2)->print();
    }
    return 0;



    cout << "Hello, World!" << endl;
    return 0;
}
