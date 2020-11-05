import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController {
    private TicTacToe model;
    private TicTacToeView view;
    public static int SIZE = 3;

    public TicTacToeController(){
        this.view = new TicTacToeView();
        this.model = new TicTacToe();

        this.view.addButtonActionListener(new TTTButtonActionListener());
    }

    private class TTTButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i =0; i< SIZE;i++){
                for (int j =0;j < SIZE;j++){
                    if (e.getSource() == view.getButton()[i][j]){
                        if(view.getButton()[i][j].getText().isEmpty()){
                            if(model.getTurn())
                                view.getButton()[i][j].setText("X");
                            else
                                view.getButton()[i][j].setText("O");
                            model.play(i,j);
                            view.changeInfo(model.getTurn());

                            if(model.getStatus() == TicTacToe.Status.X_WON){
                                view.popWin("X");
                                System.exit(0);
                            }

                            else if(model.getStatus() == TicTacToe.Status.O_WON){
                                view.popWin("O");
                                System.exit(0);
                            }

                            else if(model.getStatus() == TicTacToe.Status.TIE){
                                view.popEnd();
                                System.exit(0);
                            }

                            else
                                return;
                        }
                        else
                            view.popFull();


                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        TicTacToeController controller = new TicTacToeController();
    }
}
