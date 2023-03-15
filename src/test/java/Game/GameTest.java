package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void firstPlayerIsStronger(){
        Game game = new Game();
        Player greg = new Player(1, "Greg", 10);
        Player mark = new Player(2, "Mark", 15);

        game.register(greg);
        game.register(mark);
        int actual = game.round("Mark","Greg");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void secondPlayerIsStronger(){
        Game game = new Game();
        Player greg = new Player(1, "Greg", 10);
        Player mark = new Player(2, "Mark", 15);

        game.register(greg);
        game.register(mark);
        int actual = game.round("Greg", "Mark");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenEqual(){
        Game game = new Game();
        Player greg = new Player(1, "Greg", 10);
        Player mark = new Player(2, "Mark", 10);

        game.register(greg);
        game.register(mark);
        int actual = game.round("Greg", "Mark");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenFirstPlayerDoesNotExist(){
        Game game = new Game();
        Player greg = new Player(1, "Greg", 10);
        Player mark = new Player(2, "Mark", 10);

        game.register(greg);
        game.register(mark);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Tom","Mark"));
    }
    @Test
    public void whenSecondPlayerDoesNotExist(){
        Game game = new Game();
        Player greg = new Player(1, "Greg", 10);
        Player mark = new Player(2, "Mark", 10);

        game.register(greg);
        game.register(mark);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Greg","Tom"));
    }
    @Test
    public void whenBothPlayersDoesNotExist(){
        Game game = new Game();
        Player greg = new Player(1, "Greg", 10);
        Player mark = new Player(2, "Mark", 10);

        game.register(greg);
        game.register(mark);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Mike","Tom"));
    }
}
