import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

public class hw4_cal extends JFrame implements ActionListener{ 
	public static final int NUMBER_OF_DIGITS=20;
	private JLabel Result,Operand;
	private JTextField output,input;
	private double result=0.0;
	private boolean divmsg=false;
	private boolean notPlace=true;
	
	public hw4_cal() {
		// super();
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);

		JPanel top=new JPanel(new GridLayout(2,2));
		this.add(top,BorderLayout.NORTH);
		JPanel center=new JPanel(new GridLayout(1,2));
		this.add(center,BorderLayout.CENTER);
		JPanel down=new JPanel(new GridLayout(4,4));
		this.add(down,BorderLayout.SOUTH);

		Result=new JLabel("Result");
		top.add(Result);
		Operand=new JLabel("Operand");
		top.add(Operand);
		output=new JTextField(Double.toString(0.0),NUMBER_OF_DIGITS);
		output.setEditable(false);
		output.setBackground(Color.WHITE);
		top.add(output);
		input=new JTextField("",NUMBER_OF_DIGITS);
		input.setEditable(false);
		input.setBackground(Color.WHITE);
		top.add(input);
        
		JButton Reset=new JButton("Reset");
		center.add(Reset);
		Reset.addActionListener(this);
		JButton Clear=new JButton("Clear");
		center.add(Clear);
		Clear.addActionListener(this);
		JButton click[]=new JButton[10];
		for(int i=0;i<10;i++) {
			click[i]=new JButton(""+i);
			click[i].addActionListener(this);
			down.add(click[i]);
		}
		JButton dot=new JButton(".");
		dot.addActionListener(this);
		down.add(dot);
		JButton add=new JButton("+");
		add.addActionListener(this);
		down.add(add);
		JButton minus=new JButton("-");
		minus.addActionListener(this);
		down.add(minus);
		JButton mul=new JButton("*");
		mul.addActionListener(this);
		down.add(mul);
		JButton div=new JButton("/");
		div.addActionListener(this);
		down.add(div);
	}
	public void thrower() throws DivisionByZeroException{
		throw new DivisionByZeroException();
	}
	private class DivisionByZeroException extends Exception{
		public DivisionByZeroException() {
			input.setText("Division By Zero");
			divmsg=true;
		}
	}
	
	public static void main(String[] args) {
		hw4_cal c=new hw4_cal();
		c.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		for(int i=0;i<10;i++) {
			if(command.equals(""+i)) {
				if(divmsg) {
					input.setText("");
					divmsg=false;
				}
				else{
					input.setText(input.getText()+i);
				}
			}
			if(command.equals(".")) {
				if(divmsg) {
					input.setText("");
					divmsg=false;
				}
				else{
					if(notPlace) {
						input.setText(input.getText()+".");
						notPlace=false;
					}
				}
			}
			else if(command.equals("+")) {
				try {
					double op= Double.parseDouble(input.getText());
					if(op >=-1.0e-10 && op <=1.0e-10) {
						op=0;
					}
					result=result+op;
					output.setText(""+result);
					input.setText("");
					notPlace=true;
				}catch(Exception mismatch) {}
				
			}
			else if(command.equals("-")) {
				try {
					double op= Double.parseDouble(input.getText());
					if(op>=-1.0e-10 &&op<=1.0e-10) {
						op=0;
					}
					result=result-op;
					output.setText(""+result);
					input.setText("");
					notPlace=true;
				}catch(Exception mismatch) {}
			}
			else if(command.equals("*")) {	
				try {
					double op= Double.parseDouble(input.getText());
					if(op>=-1.0e-10 &&op<=1.0e-10) {
						op=0;
					}
					result=result*op;
					output.setText(""+result);
					input.setText("");
					notPlace=true;
				}catch(Exception mismatch) {}
			}
			else if(command.equals("/")) {
				try {
					double op= Double.parseDouble(input.getText());
					if(op>=-1.0e-10 &&op<=1.0e-10) {
						output.setText("0.0");
						input.setText("");
						thrower();
						op=0;
					}
					result=result/op;
					output.setText(""+result);
					input.setText("");
					notPlace=true;
				}catch(Exception mismatch) {}
			}
			else if(command.equals("Reset")) {
				result=0.0;
				output.setText("0.0");
				input.setText("");
			}else if(command.equals("Clear")) {
				input.setText("");
				notPlace=true;
			}
			else {
				output.setText("0.0");
			}
		}
	}
}