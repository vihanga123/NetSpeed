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


        MenuItem CPUTem = new MenuItem(Double.toString(sensors.getCpuTemperature()));
        CheckboxMenuItem cb1 = new CheckboxMenuItem("tooltip");
        MenuItem error = new MenuItem("Error");

        popup.add(CPUTem);
        popup.add(cb1);
        popup.add(error);

        TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("C:/Users/vihan/IdeaProjects/Java/src/download.png"), "Tray Popup Menu", popup);
        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        trayIcon.setPopupMenu(popup);


        JFrame frame = new JFrame();
        JPanel CPU = new JPanel();
        JTabbedPane CPUtab = new JTabbedPane();
        LabelCPUtemp = new Label("CPU Temp");
        //add(LabelCPUtemp);
        CPUTemp = new TextField(hal.getSensors().toString()); //Arrays.toString(sensors.getFanSpeeds()
        CPUTemp.setEditable(false);
        //add(CPUTemp);
        NetInfo = new TextField();
        NetInfo.setEditable(false);
        //add(NetInfo);
        refreshBtn = new Button("Refresh");
        //add(refreshBtn);
        CPU.add(LabelCPUtemp);
        CPU.add(CPUTemp);
        CPU.add(NetInfo);
        CPU.add(refreshBtn);
        CPUtab.addTab("CPU",CPU);
        frame.setSize(500,200);
        frame.add(CPU,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel Sensor = new JPanel();
        Sensor.setLayout(new BorderLayout());
        JLabel label2 = new JLabel("This is Label 2");
        JTextField textField2 = new JTextField(20);
        Sensor.add(label2, BorderLayout.NORTH);
        Sensor.add(textField2, BorderLayout.SOUTH);
        CPUtab.addTab("Sensor", Sensor);





    }


    // The entry main() method
    public static void main(String[] args) {


        Main app = new Main();


    }

}



