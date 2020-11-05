import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {
    TicTacToe ttt;

    @Test
    public void getStatus() {

        ttt = new TicTacToe();
        assertEquals(TicTacToe.Status.UNDECIDED,ttt.getStatus());


        // x o o
        //   x
        //     x
        ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(0,1);
        ttt.play(1,1);
        ttt.play(0,2);
        ttt.play(2,2);
        assertEquals(TicTacToe.Status.X_WON,ttt.getStatus());


        // x o x
        // x o
        //   o
        ttt = new TicTacToe();
        ttt.play(0,0);//x
        ttt.play(0,1);//o
        ttt.play(0,2);//x
        ttt.play(1,1);//o
        ttt.play(1,0);//x
        ttt.play(2,1);//o
        assertEquals(TicTacToe.Status.O_WON,ttt.getStatus());

        // x o x
        // x o x
        // o x o
        ttt = new TicTacToe();
        ttt.play(0,0);//x
        ttt.play(0,1);//o
        ttt.play(0,2);//x
        ttt.play(1,1);//o
        ttt.play(1,0);//x
        ttt.play(2,2);//o
        ttt.play(1,2);//x
        ttt.play(2,0);//o
        ttt.play(2,1);//x
        assertEquals(TicTacToe.Status.TIE,ttt.getStatus());

    }
}