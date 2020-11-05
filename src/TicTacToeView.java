import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeView extends JFrame {

    private JButton button[][];
    public static int SIZE = 3;
    private JLabel label;
    private JPanel panel;


    public TicTacToeView(){
        this.button = new JButton[SIZE][SIZE];
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(SIZE,SIZE));

        label = new JLabel();
        label.setText("Welcome to TicTacToe.It's X's turn");
        label.setVisible(true);

        for (int i= 0; i < SIZE; i++){
            for (int j=0;j<SIZE;j++){
                this.button[i][j] = new JButton();
                this.button[i][j].setPreferredSize(new Dimension(100,100));
                panel.add(button[i][j]);
            }
        }

        this.getContentPane().add(label);
        this.getContentPane().add(panel,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    public void addButtonActionListener(ActionListener e){
        for(int i=0;i<SIZE;i++) {
            for(int j=0;j<SIZE;j++) {
                this.button[i][j].addActionListener(e);

            }
        }
    }
    public void popWin(String playerid){
        JOptionPane.showMessageDialog(this,"Player " + playerid + " won.");
    }
    public void popEnd(){
        JOptionPane.showMessageDialog(this,"End of the game, no one won the game");
    }
    public void popFull(){
        JOptionPane.showMessageDialog(this,"You can't click this button");
    }

    public JButton [][] getButton(){
        return this.button;
    }
    public void changeInfo(boolean turn){
        if(turn)
            this.label.setText("It's X's turn.");
        else
            this.label.setText("It's O's turn.");

    }

}
