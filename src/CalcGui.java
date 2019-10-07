import javax.swing.*;
import java.awt.*;
public class CalcGui {
    public static void main(String[] args) {
        final float[] num1 = new float[1];
        final float[] num2 = new float[1];
        final float[] result = new float[1];
        //Create Frame
        JFrame frame = new JFrame("Alec's Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400,400);

        //Different Panels and Containers Initialization
        JPanel panel = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JButton clear = new JButton("Clear");
        JButton add = new JButton("Add");
        JButton sub = new JButton("Subtract");
        JButton mul = new JButton("Multiply");
        JButton div = new JButton("Divide");
        JTextField input = new JTextField(10);
        JTextField input2 = new JTextField(10);
        JLabel label = new JLabel("Enter Input");
        JLabel label2 = new JLabel("Enter Input");
        JLabel label3 = new JLabel("Result");
        JTextArea end = new JTextArea(1,20);
        end.setEditable(false);
        add.addActionListener(e -> {
            try {
                num1[0] = Float.parseFloat(input.getText());
                num2[0] = Float.parseFloat(input2.getText());
                result[0] = num1[0] + num2[0];
                end.setText(String.valueOf(result[0]));
            }
            catch(Exception a) {
                end.setText("Please Enter Valid Inputs");
            }
        });
        sub.addActionListener(e -> {
            try {
                num1[0] = Float.parseFloat(input.getText());
                num2[0] = Float.parseFloat(input2.getText());
                result[0] = num1[0] - num2[0];
                end.setText(String.valueOf(result[0]));
            }
            catch(Exception a){
                end.setText("Please Enter Valid Inputs");
            }
        });
        mul.addActionListener(e -> {
            try {
                num1[0] = Float.parseFloat(input.getText());
                num2[0] = Float.parseFloat(input2.getText());
                result[0] = num1[0] * num2[0];
                end.setText(String.valueOf(result[0]));
            }
            catch(Exception a){
                end.setText("Please Enter Valid Inputs");
            }
        });
        div.addActionListener(e -> {
            try {
                num1[0] = Float.parseFloat(input.getText());
                num2[0] = Float.parseFloat(input2.getText());
                if (num2[0] == 0) {
                    end.setText("Please Enter Non-Zero Dividend");
                } else {
                    result[0] = num1[0] / num2[0];
                    end.setText(String.valueOf(result[0]));
                }
            } catch (Exception a) {
                end.setText("Please Enter Valid Inputs");
            }
        });
        clear.addActionListener(e -> {
            input.setText("");
            input2.setText("");
            end.setText("");
        });
        //Panel for Inputs
        panel.add(label);
        panel.add(input);
        panel.add(label2);
        panel.add(input2);
        panel3.add(BorderLayout.CENTER,clear);
        panel3.add(BorderLayout.EAST,add);
        panel3.add(BorderLayout.EAST,sub);
        panel3.add(BorderLayout.WEST,mul);
        panel3.add(BorderLayout.WEST,div);
        //Panel for Result
        panel4.add(label3);
        panel4.add(end);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, panel3);
        frame.getContentPane().add(BorderLayout.SOUTH, panel4);
        frame.setVisible(true);
    }
}
