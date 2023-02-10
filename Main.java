package oshi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Sensors;
import oshi.driver.windows.LogicalProcessorInformation;



public class Main extends Frame {
    Label LabelCPUtemp;    // Declare a Label component
    TextField CPUTemp; // Declare a TextField component
    Button refreshBtn;   // Declare a Button component
    int count = 0;     // Counter's value

    public Main () {
        SystemInfo si =new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        Sensors sensors = hal.getSensors();


        PopupMenu popup = new PopupMenu(); //taskbar popup menu


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



        setLayout(new FlowLayout());

        LabelCPUtemp = new Label("CPU Temp");
        add(LabelCPUtemp);

        CPUTemp = new TextField(hal.getSensors().toString()); //Arrays.toString(sensors.getFanSpeeds()
        CPUTemp.setEditable(false);
        add(CPUTemp);
        refreshBtn = new Button("Refresh");
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.super.repaint();
            }
        });
        add(refreshBtn);

        setTitle("NetMeter");
        setSize(300, 100);
        setVisible(true);
    }


    // The entry main() method
    public static void main(String[] args) {

        Main app = new Main();

    }

}
