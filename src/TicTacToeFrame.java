import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView {

    private JButton[][] buttons;

    public TicTacToeFrame(){
        super("Tic Tac Toe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE,TicTacToeModel.SIZE));
        TicTacToeModel ticTacToeModel = new TicTacToeModel();
        ticTacToeModel.addTicTacToeView(this);
        TicTacToeController ticTacToeController = new TicTacToeController(ticTacToeModel);
        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];
        for(int i=0; i<TicTacToeModel.SIZE; i++){
            for(int j=0; j<TicTacToeModel.SIZE;j++){
                JButton b = new JButton("");
                buttons[i][j] = b;
                b.addActionListener(ticTacToeController);
                b.setActionCommand(i+" "+j);
                this.add(b);
            }
        }
        this.setSize(500,500);
        this.setVisible(true);
    }
    @Override
    public void handleTicTacToeUpdate(TicTacToeEvent e) {
        int x = e.getX();
        int y = e.getY();
        TicTacToeModel ticTacToeModel = (TicTacToeModel)e.getSource();
        String label = ticTacToeModel.getTurn()? "X" : "O";
        buttons[x][y].setText(label);

        TicTacToeModel.Status status = ticTacToeModel.getStatus();
        if(status == TicTacToeModel.Status.UNDECIDED)
            return;
        else if(status == TicTacToeModel.Status.TIE)
            JOptionPane.showMessageDialog(this,"End of the game, no one won the game");
        else if (status == TicTacToeModel.Status.X_WON)
            JOptionPane.showMessageDialog(this,"X won.");
        else
            JOptionPane.showMessageDialog(this,"O won.");
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
