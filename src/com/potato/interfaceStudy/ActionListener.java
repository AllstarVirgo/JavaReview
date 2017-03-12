package com.potato.interfaceStudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by allstarvirgo on 17-3-12.
 */


class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        Date now=new Date();
        System.out.println("At the tone,the time is"+now);
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        ActionListener listener=new TimePrinter();
        Timer timer=new Timer(10000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");

        System.exit(0);
    }
}

