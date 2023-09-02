import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {
    Random random = new Random();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] buttons = new JButton[3][3];
    boolean P1_turn;

    TicTacToe(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.getContentPane().setBackground(new Color(20,20,20));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setTitle("TicTcToe");
        this.setForeground(new Color(40,40,40));

        ImageIcon image = new ImageIcon("img.png");
        this.setIconImage(image.getImage());

        textfield.setBackground(new Color(10,10,10));
        textfield.setForeground(new Color(123,50,250));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic_Tac_Toe");
        textfield.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,700,100);
        title.add(textfield);
        this.add(title,BorderLayout.NORTH);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(0,0,0));
        this.add(button);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j] = new JButton();
                button.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("CHALK DUST",Font.BOLD,150));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
            }
        }
        playerTurn();
    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(e.getSource() == buttons[i][j]){
                    if(P1_turn){
                        if(Objects.equals(buttons[i][j].getText(), "")){
                            buttons[i][j].setForeground(new Color(200,0,0));
                            buttons[i][j].setText("X");
                            P1_turn = false;
                            textfield.setText("Player: O turn");
                            winCondition();
                        }
                    }
                    else{
                        if(Objects.equals(buttons[i][j].getText(), "")){
                            buttons[i][j].setForeground(new Color(0,0,200));
                            buttons[i][j].setText("O");
                            P1_turn = true;
                            textfield.setText("Player: X turn");
                            winCondition();
                        }
                    }
                }
            }
        }
    }
    public void playerTurn(){
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(0,2)==0){
            P1_turn = true;
            textfield.setText("Player: X turn");
        }
        else{
            P1_turn = false;
            textfield.setText("Player: O turn");
        }
    }
    public void winCondition(){
        //X's Win Condition
        if((Objects.equals(buttons[0][0].getText(), "X"))&&
                (Objects.equals(buttons[0][1].getText(), "X"))&&
                (Objects.equals(buttons[0][2].getText(), "X")))
        {
            xWins(0,0,0,1,0,2);
        }
        if((Objects.equals(buttons[1][0].getText(), "X"))&&
                (Objects.equals(buttons[1][1].getText(), "X"))&&
                (Objects.equals(buttons[1][2].getText(), "X")))
        {
            xWins(1,0,1,1,1,2);
        }
        if((Objects.equals(buttons[2][0].getText(), "X"))&&
                (Objects.equals(buttons[2][1].getText(), "X"))&&
                (Objects.equals(buttons[2][2].getText(), "X")))
        {
            xWins(2,0,2,1,2,2);
        }
        if((Objects.equals(buttons[0][0].getText(), "X"))&&
                (Objects.equals(buttons[1][0].getText(), "X"))&&
                (Objects.equals(buttons[2][0].getText(), "X")))
        {
            xWins(0,0,1,0,2,0);
        }
        if((Objects.equals(buttons[0][1].getText(), "X"))&&
                (Objects.equals(buttons[1][1].getText(), "X"))&&
                (Objects.equals(buttons[2][1].getText(), "X")))
        {
            xWins(0,1,1,1,2,1);
        }
        if((Objects.equals(buttons[0][2].getText(), "X"))&&
                (Objects.equals(buttons[1][2].getText(), "X"))&&
                (Objects.equals(buttons[2][2].getText(), "X")))
        {
            xWins(0,2,1,2,2,2);
        }
        if((Objects.equals(buttons[0][0].getText(), "X"))&&
                (Objects.equals(buttons[1][1].getText(), "X"))&&
                (Objects.equals(buttons[2][2].getText(), "X")))
        {
            xWins(0,0,1,1,2,2);
        }
        if((Objects.equals(buttons[0][2].getText(), "X"))&&
                (Objects.equals(buttons[1][1].getText(), "X"))&&
                (Objects.equals(buttons[2][0].getText(), "X")))
        {
            xWins(0,2,1,1,2,0);
        }
        //O's Win Condition
        if((Objects.equals(buttons[0][0].getText(), "O"))&&
                (Objects.equals(buttons[0][1].getText(), "O"))&&
                (Objects.equals(buttons[0][2].getText(), "O")))
        {
            oWins(0,0,0,1,0,2);
        }
        if((Objects.equals(buttons[1][0].getText(), "O"))&&
                (Objects.equals(buttons[1][1].getText(), "O"))&&
                (Objects.equals(buttons[1][2].getText(), "O")))
        {
            oWins(1,0,1,1,1,2);
        }
        if((Objects.equals(buttons[2][0].getText(), "O"))&&
                (Objects.equals(buttons[2][1].getText(), "O"))&&
                (Objects.equals(buttons[2][2].getText(), "O")))
        {
            oWins(2,0,2,1,2,2);
        }
        if((Objects.equals(buttons[0][0].getText(), "O"))&&
                (Objects.equals(buttons[1][0].getText(), "O"))&&
                (Objects.equals(buttons[2][0].getText(), "O")))
        {
            oWins(0,0,1,0,2,0);
        }
        if((Objects.equals(buttons[0][1].getText(), "O"))&&
                (Objects.equals(buttons[1][1].getText(), "O"))&&
                (Objects.equals(buttons[2][1].getText(), "O")))
        {
            oWins(0,1,1,1,2,1);
        }
        if((Objects.equals(buttons[0][2].getText(), "O"))&&
                (Objects.equals(buttons[1][2].getText(), "O"))&&
                (Objects.equals(buttons[2][2].getText(), "O")))
        {
            oWins(0,2,1,2,2,2);
        }
        if((Objects.equals(buttons[0][0].getText(), "O"))&&
                (Objects.equals(buttons[1][1].getText(), "O"))&&
                (Objects.equals(buttons[2][2].getText(), "O")))
        {
            oWins(0,0,1,1,2,2);
        }
        if((Objects.equals(buttons[0][2].getText(), "O"))&&
                (Objects.equals(buttons[1][1].getText(), "O"))&&
                (Objects.equals(buttons[2][0].getText(), "O")))
        {
            oWins(0,2,1,1,2,0);
        }
    }
    public void xWins(int A,int a,int B,int b,int C,int c){
        buttons[A][a].setBackground(new Color(0x8D1827));
        buttons[B][b].setBackground(new Color(0x8D1827));
        buttons[C][c].setBackground(new Color(0x8D1827));

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setEnabled(false);
            }
            textfield.setText("Player: X wins");
        }
    }
    public void oWins(int A,int a,int B,int b,int C,int c){
        buttons[A][a].setBackground(new Color(0x123456));
        buttons[B][b].setBackground(new Color(0x123456));
        buttons[C][c].setBackground(new Color(0x123456));

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setEnabled(false);
            }
            textfield.setText("Player: O wins");
        }
    }
}