package com.potato.interfaceStudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by allstarvirgo on 17-3-12.
 */
public class ClassInMethod {
    private int interval;

    private boolean beep;

    public ClassInMethod(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        class TimePrinter implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now=new Date();

                System.out.println("At the tone,the time is"+now);

                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener=new TimePrinter();

        Timer t=new Timer(interval,listener);

        t.start();
    }

    public static void main(String[] args) {
        ClassInMethod classInMethod=new ClassInMethod(10000,true);

        classInMethod.start();

        JOptionPane.showMessageDialog(null,"Quit program?");

        System.exit(0);
    }
}
