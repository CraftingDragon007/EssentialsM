package ch.gamepowerx.essentialsm;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        if(!GraphicsEnvironment.isHeadless())
            JOptionPane.showMessageDialog(null, "Dies ist ein Minecraft Plugin, keine Java Application! Du musst das Plugin auf den Server hochladen und dann den Server neustarten um diese Plugin zu verwenden!", "EssentialsM", JOptionPane.ERROR_MESSAGE);
        System.out.println("ERROR: Dies ist ein Minecraft Plugin, keine Java Application! Du musst das Plugin auf den Server hochladen und dann den Server neustarten um diese Plugin zu verwenden!");
    }
}
