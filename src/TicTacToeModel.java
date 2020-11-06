import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {


    public static int SIZE = 3;
    public static boolean X = true;
    public static boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;

    private List<TicTacToeView> ticTacToeViewList;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;

        ticTacToeViewList = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView ticTacToeView){
        ticTacToeViewList.add(ticTacToeView);
    }

    public void removeTicTacToeView(TicTacToeView ticTacToeView){
        ticTacToeViewList.remove(ticTacToeView);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private Status updateStatus() {

        boolean rowwin = false;
        boolean colwin = false;
        boolean diagonwin = false;
        boolean reverDiagonwin = false;
        boolean isFull = true;

        int reverDiagoncount = 0;
        int diagoncount = 0;

        char checkwho = ' ';
        if(getTurn()){
            checkwho =  'X';
        }
        else
            checkwho = 'O';


        for (int i = 0; i < SIZE; i++) {
            int rowcount = 0;
            for (int j = 0; j < SIZE; j++) {

                if(grid[i][j]==checkwho)
                    rowcount++;
                else
                    break;
                if(rowcount == SIZE)
                    rowwin = true;
                else
                    rowwin = false;
            }

        }
        for (int i = 0; i < SIZE; i++) {
            int colcount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (grid[j][i]==checkwho)
                    colcount++;
                else
                    break;

                if(colcount == SIZE)
                    colwin = true;
                else
                    colwin = false;

            }

        }
        for (int i = 0; i < SIZE; i++) {

            if (grid[i][i] == checkwho)
                diagoncount++;
            if (grid[i][SIZE-1-i] == checkwho)
                reverDiagoncount++;

        }
        if (diagoncount == SIZE)
            diagonwin= true;

        if (reverDiagoncount == SIZE)
            reverDiagonwin = true;


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] ==' '){
                    isFull = false;
                }
            }
        }
        if (rowwin||colwin||diagonwin||reverDiagonwin){
            if(getTurn())
                status = Status.X_WON;
            else
                status = Status.O_WON;
        }
        else if (isFull)
            status = Status.TIE;
        else
            status = Status.UNDECIDED;

        return status; //TODO
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        for(TicTacToeView ticTacToeView:ticTacToeViewList)ticTacToeView.handleTicTacToeUpdate(new TicTacToeEvent(this,status,x,y));
        changeTurn();
    }
}
