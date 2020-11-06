import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {
    TicTacToeModel ttt;
    @Test
    public void getStatus() {
        ttt = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED,ttt.getStatus());

        //test diagonal
        // x o o
        //   x
        //     x
        ttt = new TicTacToeModel();
        ttt.play(0,0);//x
        ttt.play(0,1);//o
        ttt.play(1,1);//x
        ttt.play(0,2);//o
        ttt.play(2,2);//x
        assertEquals(TicTacToeModel.Status.X_WON,ttt.getStatus());

        //test reverdiagonal
        // x x o
        //   o
        // o   x
        ttt = new TicTacToeModel();
        ttt.play(0,0);//x
        ttt.play(0,2);//o
        ttt.play(0,1);//x
        ttt.play(1,1);//o
        ttt.play(2,2);//x
        ttt.play(2,0);//o
        assertEquals(TicTacToeModel.Status.O_WON,ttt.getStatus());


        //test column
        // x o x
        // x o
        //   o
        ttt = new TicTacToeModel();
        ttt.play(0,0);//x
        ttt.play(0,1);//o
        ttt.play(0,2);//x
        ttt.play(1,1);//o
        ttt.play(1,0);//x
        ttt.play(2,1);//o
        assertEquals(TicTacToeModel.Status.O_WON,ttt.getStatus());

        //test row
        // x x x
        //   o
        //   o
        ttt = new TicTacToeModel();
        ttt.play(0,0);//x
        ttt.play(1,1);//o
        ttt.play(0,2);//x
        ttt.play(2,1);//o
        ttt.play(0,1);//x
        assertEquals(TicTacToeModel.Status.X_WON,ttt.getStatus());

        //test full
        // x o x
        // x o x
        // o x o
        ttt = new TicTacToeModel();
        ttt.play(0,0);//x
        ttt.play(0,1);//o
        ttt.play(0,2);//x
        ttt.play(1,1);//o
        ttt.play(1,0);//x
        ttt.play(2,2);//o
        ttt.play(1,2);//x
        ttt.play(2,0);//o
        ttt.play(2,1);//x
        assertEquals(TicTacToeModel.Status.TIE,ttt.getStatus());

    }
}