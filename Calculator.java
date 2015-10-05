import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener{
	
	/** Main method */
	public static void main(String[] args) {
	   Calculator calculator = new Calculator();
	   calculator.setTitle("Calculator");
	   calculator.setSize(400, 400);
	   calculator.setLocationRelativeTo(null); // Center the frame
	   calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   calculator.setVisible(true);
	}
	
	JTextField number_field = new JTextField("0");
	String number_string = "";
	double number;
	char jbutton[] = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.','=','+'};
	JButton button[] = new JButton[16];
	char operator;
	boolean point;
  
	public Calculator(){
	   JPanel panel = new JPanel();
	   Container container = getContentPane();
	   container.setLayout(new BorderLayout());
    	   panel.setLayout(new GridLayout(4,4));
	   number_field.setHorizontalAlignment(JTextField.RIGHT);
		
	   for(int i=0;i<16;i++){
              button[i]=new JButton(jbutton[i]+"");
              panel.add(button[i]);
              button[i].addActionListener(this);
           }
	   container.add("North",number_field);
           container.add("Center",panel);
	}
	
  public void actionPerformed(ActionEvent event){   
     if(((JButton)event.getSource()).getText().charAt(0)=='.'){
        if(!point){
           if(number_string.equals(""))
              number_string="0";
              number_string+=".";
              number_field.setText(number_string);
              point=true; 
        }
     }else if(((JButton)event.getSource()).getText().charAt(0)<='9' && ((JButton)event.getSource()).getText().charAt(0)>='0'){
        number_string+=((JButton)event.getSource()).getText().charAt(0)+"";
        number_field.setText(number_string);    
     }else{
        point=false;
        number_string="";
        number_field.setText(operation(number,Double.parseDouble(number_field.getText()),operator)+"");
        operator = ((JButton)event.getSource()).getActionCommand().charAt(0);
            
        if(((JButton)event.getSource()).getText().charAt(0)!='=')                  
            number=Double.parseDouble(number_field.getText());               
     }         
 }
   
    public double operation(double number1,double number2,char operator){      
        switch(operator)
        {        
            case '+':
                return number1+number2;
            case '-':
                return number1-number2;
            case '*':
                return number1*number2;
            case '/':
                return number1/number2;
            default:
                return number2; 
        }
    } 
}
