package abstractizare;

public class RecipeWithMicrowave extends AbstractRecipe {

    @Override
    void getReady() {
        System.out.println("Get the raw materials");
        System.out.println("Get the utensils.");
        System.out.println("Turn on microwave");
    }

    @Override
    void doTheDish(){
        System.out.println("Do the dish.");

    }

    @Override
    void cleanup(){
        System.out.println("Cleanup");
        System.out.println("Turn off microwave");

    }
}
