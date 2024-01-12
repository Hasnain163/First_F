
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JTextField textField;
    JButton addButton,subButton,devButton,mulButton,pointButton,equButton,AButton,DButton;
     JButton[] OperatorButton = new JButton[8];
     JButton[] NumberButton =new JButton[10];
     double n1=0,n2=0,result =0;
     char operator;
   public Calculator(){
         JFrame frame =new JFrame("Calculator");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(315,470);
         frame.setLayout(null);
         textField =new JTextField();
         textField.setBounds(0,0,300,50);
         Font font = new Font("Arial", Font.ITALIC, 24);
         textField.setFont(font);
          textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        devButton = new JButton("/");
        pointButton = new JButton(".");
        equButton = new JButton("=");
        DButton = new JButton("D");
        AButton = new JButton("A");

        OperatorButton[0]= addButton;
        OperatorButton[1]= subButton;
        OperatorButton[2]= mulButton;
        OperatorButton[3]= devButton;
        OperatorButton[4]= pointButton;
        OperatorButton[5]= equButton;
        OperatorButton[6]= DButton;
        OperatorButton[7]= AButton;
        for (int i =0;i<8;i++ ){
            OperatorButton[i].addActionListener(this);
            OperatorButton[i].setFont(font);
            OperatorButton[i].setFocusable(false);

        }
        for (int i =0;i<10;i++ ){
            NumberButton[i] = new JButton(String.valueOf(i));
            NumberButton[i].addActionListener(this);
            NumberButton[i].setFont(font);
            NumberButton[i].setFocusable(false);

        }
        DButton.setBounds(225,60,75,70);
        AButton.setBounds(150,60,75,70);
        JPanel panel = new JPanel();
        panel.setBounds(0,130,300,300);
        panel.setLayout(new GridLayout(4,4,0,0));
        panel.setBackground(Color.GRAY);
        panel.add(NumberButton[7]);
        panel.add(NumberButton[8]);
        panel.add(NumberButton[9]);
        panel.add(OperatorButton[2]);
        panel.add(NumberButton[4]);
        panel.add(NumberButton[5]);
        panel.add(NumberButton[6]);
        panel.add(OperatorButton[0]);
        panel.add(NumberButton[1]);
        panel.add(NumberButton[2]);
        panel.add(NumberButton[3]);
        panel.add(OperatorButton[1]);
        panel.add(pointButton);
        panel.add(NumberButton[0]);
        panel.add(equButton);
        panel.add(devButton);
        frame.add(panel);
       frame.add(DButton);
        frame.add(AButton);
         frame.add(textField);
         frame.setLocation(400,300);
         frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource() == NumberButton[i]){
             textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==AButton){
            textField.setText("");
        }
        if(e.getSource()==DButton){
            String str =textField.getText();
            textField.setText("");
            for (int i=0;i<str.length()-1;i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==pointButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            n1 = Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            n1 = Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==devButton){
            n1 = Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            n1 = Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            n2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+' :
                    result = n1+n2;
                    break;
                case '-' :
                    result = n1-n2;
                    break;
                case '*' :
                    result = n1*n2;
                    break;
                case '/' :
                    result = n1/n2;
                    break;
            }
            textField.setText(String.valueOf(result));
            n1=result;
        }

    }
}

