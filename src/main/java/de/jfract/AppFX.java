package de.jfract;


import de.jfract.gui.IconHolder;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: kesper
 * Date: 16.01.14
 * Time: 13:59
 */
public class AppFX extends javafx.application.Application implements EventHandler<WindowEvent> {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryStage.getIcons().add(SwingFXUtils.toFXImage((BufferedImage)IconHolder.getIcon(IconHolder.APP_ICON_16),null));
            primaryStage.getIcons().add(SwingFXUtils.toFXImage((BufferedImage)IconHolder.getIcon(IconHolder.APP_ICON_32),null));
            primaryStage.getIcons().add(SwingFXUtils.toFXImage((BufferedImage)IconHolder.getIcon(IconHolder.APP_ICON_64),null));
            primaryStage.setOnCloseRequest(this);
            primaryStage.setTitle("jFract FX - v1.0 alpha");
            URL url = ClassLoader.getSystemClassLoader().getResource("mainFrame.fxml");
            Pane myPane = FXMLLoader.load(url);
            Scene myScene = new Scene(myPane);
            primaryStage.setScene(myScene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void handle(WindowEvent windowEvent) {
        if (windowEvent.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
            System.exit(0);
        }
    }
}
