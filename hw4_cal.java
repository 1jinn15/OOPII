import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class MyJFrame extends JFrame{
    JPanel nums=new JPanel();
    JPanel syms=new JPanel();
    JTextArea text = new JTextArea(3,9);
    String symString = "";
    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hello JFrame");
        setBounds(100,100,450,300);
        setVisible(true);

        //contentPane.setLayout(new GridLayout(3,3,5,5));

        JButton[] num = { new JButton("7"), new JButton("8"), new JButton("9"), new JButton("4"), new JButton("5"), new JButton("6"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("0"), new JButton("."), new JButton("=")}; 
        JButton[] sym = { new JButton("*"), new JButton("-"), new JButton("+"), new JButton("/")};

        nums.setLayout(new GridLayout(4,3));
        syms.setLayout(new GridLayout(4,1));
        
        for(JButton x: num){
            x.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(!e.getActionCommand().equals("=")){
                        text.setText(text.getText()+e.getActionCommand());
                    }else{
                        try{
                            String[] parts = text.getText().split("\\"+symString);
                            double firstNum = Double.parseDouble(parts[0]);
                            double secondNum = Double.parseDouble(parts[1]);
                            text.setText("");
                            
                            if(symString.equals("+")){

                                text.setText("="+(firstNum+secondNum));
                            }else if(symString.equals("-")){

                                text.setText("="+(firstNum-secondNum));
                            }else if(symString.equals("*")){

                                text.setText("="+(firstNum*secondNum));
                            }else if(symString.equals("/")){

                                text.setText("="+(firstNum/secondNum));
                            }

                        }catch(Exception exp){
                            System.out.println(exp.getMessage());
                        }
                        
                    }
                }
            });
        nums.add(x);
        }

        for(JButton x: sym){
            
            x.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    symString=e.getActionCommand();
                    text.setText(text.getText()+e.getActionCommand());
                    System.out.println(e.getActionCommand());
                }
            });
        syms.add(x);
        }
        this.add(nums);
        this.add(syms, BorderLayout.EAST);
        this.add(text, BorderLayout.NORTH);
    }

    }


public class hw4_cal {
    public static void main(String[] args) {
      MyJFrame f1 = new MyJFrame();  
    }
}