public abstract class Pokemon {

    protected String pokemonName;
    protected String pokemonOwner;
    protected String pokemonType;
    protected int level;

    protected int strenght_base;
    protected int attack_base;
    protected int defense_base;
    protected int speed_base;


    Pokemon( String name ,int strenght , int atack , int def , int spd )
    {
        this.defense_base = def;

        this.strenght_base = strenght;
        this.attack_base = atack;
        this.speed_base = spd;

        pokemonName = name;
        pokemonOwner = "";
        pokemonType = "";
        level = 0;

    }

    @Override
    public String toString()
    {
        return "pokemon name: " + pokemonName + ", type: " + pokemonType  ;
    }

    int calcDamage(Pokemon other ){

        int wynik = this.calcImpact() ;
        wynik -= other.defense_base;

        if ( wynik < 0  )
        {
            wynik = 0;
        }

        return  wynik;
    }


    abstract int calcImpact( );

}

class PokomonWaterType extends Pokemon{

    PokomonWaterType(String name, int strenght , int atack , int def , int spd )
    {
        super( name ,strenght, atack, def , spd);
    }

    @Override
    int calcImpact() {
        int wynik = 2*this.attack_base + 2*this.speed_base + this.strenght_base ;
        return wynik;
    }
}


class PokemonFireType extends Pokemon{


    PokemonFireType( String name, int strenght , int atack , int def , int spd )
    {
        super(name ,strenght, atack, def , spd);
    }

    @Override
    int calcImpact() {
        int wynik = 2*this.attack_base + 2*this.speed_base + this.strenght_base ;
        return wynik;
    }
}

