package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

@Component
public class StartScreen extends JFrame {

    static JFrame frame;

    @Autowired
    Stops stops;
    @Autowired
    Validation validation;

    public void mainFrame() {
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
    }

    void displayJFrame() {
        frame = new JFrame("METROLINK STATION ARRIVAL TIMES");

        // create components
        JLabel instruction = new JLabel("Input the number for the METROLINK STATION that you wish to see the next arrival time for");
        instruction.setForeground(Color.RED);
        //instruction.setBorder(new LineBorder(Color.red, 1));
        JList list;
        list = new JList(stops.outputStations().toArray(new String[0]));

        JLabel instruction2 = new JLabel("Input METROLINK STATION #");

        JTextField input = new JTextField(2);
        //input.setText("0-35");
        input.setBorder(new LineBorder(Color.red, 1));
        //input.setEditable(false);
        input.setInputVerifier(new InputVerifier() {
            int MAX = 35;
            int MIN = 0;
            @Override

            public boolean verify(JComponent input) {//adding Validator for integers in the correct range
                String text = ((JTextField) input).getText();
                int num = 0;
                try {
                    num = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    JOptionPane.showOptionDialog(null, "Not a Number", "Not a Number", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);

                }
                if (text.equals("")||
                        num <= MAX && num >= MIN)
                    return true;
                JOptionPane.showOptionDialog(null, "Invalid input. Please make your METROLINK Station selection from 0-35.", "Not a Valid Number", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);

                return false;
            }
        });



        JTextArea output = new JTextArea(1, 40);
        output.setBorder(new LineBorder(Color.red, 1));

        JButton jb1;
        jb1 = new JButton("Click here to get the Arrival Time");

        // add the listener to the jbutton to handle the "pressed" event
        jb1.addActionListener((ActionEvent e) -> {
            int user_Input = Integer.parseInt(input.getText());

            String nextStationArrival = validation.getNextStationArrival(user_Input);

            output.setText(nextStationArrival); //display station and time in the output textarea


        });

        // put the components on the frame
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(instruction);
        frame.add(list);
        frame.add(instruction2);
        frame.add(input);
        frame.add(output);
        frame.add(jb1);

        // set up the jframe, then display it
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        input.requestFocusInWindow() ;
    }
}






