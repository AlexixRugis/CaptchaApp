package com.artech.workerslogin.ui.views;

import com.artech.workerslogin.ui.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

/**
 * Предстваление на основе FXML файла
 */
public abstract class FXMLView extends View {

    @Override
    protected Node build() {
        FXMLLoader loader = new FXMLLoader(getFXMLResourceURL());
        loader.setController(getController());

        try {
            Scene scene = new Scene(loader.load());
            return scene.getRoot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получает путь к FXML файлу
     * @return Путь к FXML файлу
     */
    protected abstract URL getFXMLResourceURL();

    /**
     * Получает контроллер представления
     * @return Контроллер представления
     */
    protected abstract Controller getController();

}

