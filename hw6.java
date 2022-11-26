import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class MyJFrame extends JFrame implements ActionListener{
    private JPanel pan1,pan2,pan3;
    private JList<String> jl1;
    private JTextArea jta;

    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HW6");
        setBounds(50,50,280,200);
        setLayout(null);
        
        JLabel lb1City = new JLabel("找個地名山:");
        jta = new JTextArea("可選取地區...");
        jta.setBounds(50,200,200,100);
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        add(pan1);
        add(pan2);
        add(pan3);
        pan1.setBounds(0,20,150,120);
        pan2.setBounds(100,20,150,200);
        pan3.setBounds(0,110,300,100);
        //pan.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        String[] city = {"台北","台中","嘉義","台南","高雄","屏東"};
        jl1 = new JList<>(city);
        pan1.add(lb1City);
        pan2.add(jl1);
        //pan1.add(jl2);
        pan3.add(jta);
        jl1.setVisibleRowCount(6);
        JScrollPane jsp = new JScrollPane(jl1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(150,7,60,60);
        add(jsp);
        jl1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                //set the text of the label to the selected value of lists.
                if(!e.getValueIsAdjusting()){
                    String lbShow= "";
                    String[] mountains ={"七星山", "鳶嘴山" , "玉山" ,"桂子山","壽山","霧頭山"};
                    for(int i=0;i<jl1.getSelectedValuesList().size();i++){
                        for(int j=0;j<city.length;j++){
                            if(city[j]==jl1.getSelectedValuesList().get(i)){
                                lbShow+=jl1.getSelectedValuesList().get(i)+"名山 :  "+mountains[j]+"\n";
                            }
                        }
                    }
                    jta.setText(lbShow);
                }
            }
        });
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

public class hw6 {
    public static void main(String[] args) throws Exception {
        MyJFrame f1 = new MyJFrame();
    }
}
