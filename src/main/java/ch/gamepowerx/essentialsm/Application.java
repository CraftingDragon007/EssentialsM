package ch.gamepowerx.essentialsm;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        if(!GraphicsEnvironment.isHeadless())
            System.out.println("ERROR: Dies ist ein Minecraft Plugin, keine Java Application!");
        JOptionPane.showMessageDialog(null, "Dies ist ein Minecraft Plugin, keine Java Application!", "EssentialsM", JOptionPane.ERROR_MESSAGE);
    }
}
