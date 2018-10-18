package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class StartScreen extends JFrame {

    static JFrame frame;
    int user_Input;

    @Autowired
    Stops stops;


    public void mainFrame() {
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
        JList list;
        list = new JList(stops.outputStations().toArray(new String[0]));

        JLabel instruction2 = new JLabel("Input METROLINK STATION #");

        JTextField input = new JTextField(2);
        input.setBorder(new LineBorder(Color.red, 1));

        JTextArea output = new JTextArea(1, 40);
        output.setBorder(new LineBorder(Color.red, 1));

        JButton jb1;
        jb1 = new JButton("Click here to get the Arrival Time");


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (inputConversion(input) == true) {

                    output.setText(getNextStationArrival(user_Input));

                }
            }
        });


        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(instruction);
        frame.add(list);
        frame.add(instruction2);
        frame.add(input);
        frame.add(output);
        frame.add(jb1);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        input.requestFocusInWindow();
    }


    public boolean inputConversion(JComponent input) {

        String user_Input_Text = ((JTextField) input).getText();
        try {
            user_Input = Integer.parseInt(user_Input_Text);
        } catch (NumberFormatException e) {
            JOptionPane.showOptionDialog(null, "Not a Number", "Not a Number", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            return false;
        }
        if (verifyRange(user_Input) == true)
            return true;

        return false;
    }


    public boolean verifyRange(int user_Input) {
        int MAX = 35;
        int MIN = 0;

        if (user_Input <= MAX && user_Input >= MIN) {
            return true;
        } else {
            JOptionPane.showOptionDialog(null, "Invalid input. Please make your METROLINK Station selection from 0-35.", "Not a Valid Number", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            return false;


        }
    }

    public String getNextStationArrival(int user_Input) {

        String stationName = stops.getStationName(user_Input);
        String nextArrival = stops.getNextArrival(user_Input);
        String nextStationArrival = " The next arrival at " + stationName + " is at " + nextArrival;
        return nextStationArrival;

    }

    public void setStops(Stops stops) {//for mock object
        this.stops = stops;
    }
}




