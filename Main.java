package Oshi;

import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;
import java.util.Stack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import oshi.SystemInfo;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Sensors;
import oshi.driver.windows.LogicalProcessorInformation;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Main  {
    Label LabelCPUtemp;    // Declare a Label component
    TextField CPUTemp; // Declare a TextField component
    TextField NetInfo;
    Button refreshBtn;   // Declare a Button component
    int count = 0;     // Counter's value

    @ThreadSafe
    public Main() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        Sensors sensors = hal.getSensors();

        PopupMenu popup = new PopupMenu();
        Stack<Double> set = new Stack();


        TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("C:/Users/vihan/IdeaProjects/Java/src/download.png"), "Tray Popup Menu", popup);
        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        trayIcon.setPopupMenu(popup);

        //Frame

        JTabbedPane tab = new JTabbedPane();
        JPanel CPU = new JPanel();
        LabelCPUtemp = new Label("CPU Temp");
        //add(LabelCPUtemp);
        CPUTemp = new TextField(hal.getSensors().toString()); //Arrays.toString(sensors.getFanSpeeds()
        CPUTemp.setEditable(false);
        //add(CPUTemp);
        //add(NetInfo);
        refreshBtn = new Button("Refresh");
        tab.addTab("CPU",CPU);


        CPU.add(LabelCPUtemp);
        CPU.add(CPUTemp);
        CPU.add(refreshBtn);

        JFrame frame = new JFrame();
        frame.setSize(500,200);
        frame.add(tab,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel Sensor = new JPanel();
        Sensor.setLayout(new BorderLayout());
        JLabel label2 = new JLabel("CPU Threads");
        try {
            label2.setText(label2.getText() + ": " + cpu.());
        }
        catch (Exception e){
            System.out.println("test");
        }
        JTextField textField2 = new JTextField(20);
        Sensor.add(label2, BorderLayout.NORTH);
        Sensor.add(textField2, BorderLayout.SOUTH);
        tab.addTab("Sensor", Sensor);

        //Popup menu
        MenuItem CPUTem = new MenuItem(Double.toString(sensors.getCpuTemperature()));
        MenuItem restore = new MenuItem("Restore");
        MenuItem exit = new MenuItem("Exit");

        popup.add(CPUTem);

        popup.add(exit).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        popup.add(restore).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(JFrame.NORMAL);

            }
        });



    }


    // The entry main() method
    public static void main(String[] args) {


        Main app = new Main();


    }

}

