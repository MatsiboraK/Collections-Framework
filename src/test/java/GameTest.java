import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Game;
import ru.netology.javaqa.NotRegisteredException;
import ru.netology.javaqa.Player;

public class GameTest {
    Game set = new Game();
    Player player1 = new Player(1, "Антон", 10);
    Player player2 = new Player(2, "Женя", 9);
    Player player3 = new Player(3, "Коля", 10);
    Player player4 = new Player(4, "Максим", 8);
    Player player5 = new Player(5, "Саша", 7);
    Player player6 = new Player(6, "Ксюша", 6);

    @Test
    public void shouldCheckThatPl1StrongerThanPl2() {
        set.register(player1);
        set.register(player2);
        set.register(player3);
        set.register(player4);
        set.register(player5);
        set.register(player6);

        int expected = 1;
        int actual = set.round("Саша", "Ксюша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckThatPl2StrongerThanPl1() {
        set.register(player1);
        set.register(player2);
        set.register(player3);
        set.register(player4);
        set.register(player5);
        set.register(player6);

        int expected = 2;
        int actual = set.round("Саша", "Максим");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckThatPl2EqualThanPl1() {
        set.register(player1);
        set.register(player2);
        set.register(player3);
        set.register(player4);
        set.register(player5);
        set.register(player6);

        int expected = 0;
        int actual = set.round("Антон", "Коля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckThatPl1IsRegister() {
        set.register(player1);
        set.register(player2);
        set.register(player3);
        set.register(player4);
        set.register(player5);
        set.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            set.round("Миша", "Коля");
        });
    }

    @Test
    public void shouldCheckThatPl2IsRegister() {
        set.register(player1);
        set.register(player2);
        set.register(player3);
        set.register(player4);
        set.register(player5);
        set.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            set.round("Ксюша", "Марк");
        });
    }
}
