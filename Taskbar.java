import java.awt.*;
import java.awt.event.*;
import java.awt.TrayIcon.*;

public class TrayPopupMenu {
    public static void main(String[] args) throws AWTException {
        // Check if the system supports tray icons
        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported on this platform");
            return;
        }

        // Create a popup menu
        PopupMenu popup = new PopupMenu();
        MenuItem item = new MenuItem("Exit");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        popup.add(item);

        // Create a tray icon and add it to the system tray
        TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("icon.png"), "Tray Popup Menu", popup);
        SystemTray tray = SystemTray.getSystemTray();
        tray.add(trayIcon);
    }
}