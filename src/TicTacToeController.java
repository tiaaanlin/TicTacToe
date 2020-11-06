import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {
    private TicTacToeModel ticTacToeModel;

    public TicTacToeController(TicTacToeModel ticTacToeModel){
        this.ticTacToeModel = ticTacToeModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] coordinates = e.getActionCommand().split(" ");
        ticTacToeModel.play(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
    }
}
