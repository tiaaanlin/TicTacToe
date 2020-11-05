public class TicTacToe {


    public static int SIZE = 3;
    public static boolean X = true;
    public static boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;


    public TicTacToe() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;

    }


    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private Status updateStatus() {
        boolean rowwin = false;
        boolean colwin = false;
        boolean adjwin = false;
        boolean reverAdjwin = false;

        int reverAdjcount = 0;
        int adjcount = 0;

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
                    adjcount++;
                if (grid[i][SIZE-1-i] == checkwho)
                    reverAdjcount++;

        }
        if (adjcount == SIZE)
            adjwin = true;

        if (reverAdjcount == SIZE)
            reverAdjwin = true;


        if (rowwin||colwin||adjwin||reverAdjwin){
            if(getTurn())
                status = Status.X_WON;
            else
                status = Status.O_WON;
        }
        else if (isFull())
            status = Status.TIE;
        else
            status = Status.UNDECIDED;

        return status; //TODO
    }
    public boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] ==' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        changeTurn();
    }
}

