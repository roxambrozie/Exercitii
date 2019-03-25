package interfete;

public class GameRunner {

    public static void main(String[] args) {

        //POLYMORPHISM
        GamingConsole[] games = {new MarioGame(), new ChessGame()};

        for (GamingConsole game : games) {
            game.up();
            game.down();
            game.left();
            game.right();
        }
    }
}
