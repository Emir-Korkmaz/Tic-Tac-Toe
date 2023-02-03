import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
public class TicTacToe extends JFrame implements ActionListener{

    JFrame frame = new JFrame();
    Random rnd = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton [] buttons = new JButton[9];
    boolean player1_turns;
   
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(new Color(50,50,50));;
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,25));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turns){
                    if(buttons[i].getText()==""){
                        buttons[i].setText("X");
                        player1_turns=false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else{
                    if((buttons[i].getText()=="")){
                        buttons[i].setText("O");
                        player1_turns = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
        
    }
    public void firstTurn(){

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(rnd.nextInt(2)==0){
            player1_turns=true;
            textfield.setText("X turn");
        }
        else{
            player1_turns=false;
            textfield.setText("O turn");
        }
    }

    public void check(){
        if(buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X"){
          
            Player1Win(0,1,2);
        }
        if(buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X"){
          
            Player1Win(3,4,5);
        }
        if(buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X"){
          
            Player1Win(6,7,8);
        }
        if(buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X"){
           
            Player1Win(0,4,8);
        }
        if(buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X"){
          
            Player1Win(2,4,6);
        }
        if(buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X"){
          
            Player1Win(0,3,6);
        }
        if(buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X"){
          
            Player1Win(1,4,7);
        }
        if(buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X"){
          
            Player1Win(2,5,8);
        }

        if(buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O"){
          
            Player2Win(0,1,2);
        }
        if(buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O"){
          
            Player2Win(3,4,5);
        }
        if(buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O"){
            
            Player2Win(6,7,8);
        }
        if(buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O"){
        
            Player2Win(0,4,8);
        }
        if(buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O"){
         
            Player2Win(2,4,6);
        }
        if(buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O"){
           
            Player2Win(0,3,6);
        }
        if(buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O"){
            
            Player2Win(1,4,7);
        }
        if(buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O"){
          
            Player2Win(2,5,8);
        }
     }
   
     public void Player1Win(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player 1 Win");
     }

     public void Player2Win(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player 2 Win");
    }
}
