package oshi;

import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;


public class SystemInfoTest {

    private JFrame mainFrame;
    private JButton jmenu;

    private SystemInfo si = new SystemInfo();

    public static void main(String[] args) {

        JFrame j= new JFrame();
        JTextField txt1 = new JTextField();
        add(java.awt.TrayIcon);
        txt1.setBounds(120,150,120,40);
        JButton b = new JButton("click");
        b.setBounds(130,200,100,40);
        j.add(b);
        j.add(txt1);
        j.setSize(400,500);
        j.setLayout(null);
        j.setVisible(true);
