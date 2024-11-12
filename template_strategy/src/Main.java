//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        int[] smallArray = {5, 3, 8, 4, 2, 9, 1, 7};
        int[] mediumArray = new int[150];
        int[] largeArray = new int[1200];

        for (int i = 0; i < mediumArray.length; i++) {
            mediumArray[i] = 1 + (int) (Math.random() * 1000); // Wartości od 1 do 1000
        }

        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = 1 + (int) (Math.random() * 1000); // Wartości od 1 do 1000
        }

        ISort adaptiveSort = new AdaptiveSort();

        System.out.println("Przed sortowaniem (mała tablica):");
        printArray(smallArray);
        adaptiveSort.sort(smallArray);
        System.out.println("Po sortowaniu:");
        printArray(smallArray);

        System.out.println("\nPrzed sortowaniem (średnia tablica):");
        printArray(mediumArray);
        adaptiveSort.sort(mediumArray);
        System.out.println("Po sortowaniu:");
        printArray(mediumArray);

        System.out.println("\nPrzed sortowaniem (duża tablica):");
        printArray(largeArray);
        adaptiveSort.sort(largeArray);
        System.out.println("Po sortowaniu:");
        printArray(largeArray);

        /*
        PokomonWaterType wodniak = new PokomonWaterType("wodniak" , 2,3,5,1) ;
        PokemonFireType ogniak = new PokemonFireType("ogniak" , 3,3,1,3) ;

        System.out.println(wodniak);
        System.out.println(ogniak);

        System.out.println(wodniak.calcDamage(ogniak));
        System.out.println(ogniak.calcDamage(wodniak));

         */
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}