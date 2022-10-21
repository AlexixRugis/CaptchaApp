package com.artech.workerslogin.ui;

import com.artech.workerslogin.WorkersApplication;
import com.artech.workerslogin.core.ISettings;
import com.artech.workerslogin.ui.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Главное окно приложения
 */
public class MainWindow {

    private final int width;
    private final int height;
    private final String title;

    private Scene scene;
    private AnchorPane rootPane;

    public MainWindow(int width, int height, String title) {

        this.width = width;
        this.height = height;
        this.title = title;

        initialize();
    }

    /**
     * Запускает приложение
     *
     * @param stage Главный контейнер приложения
     */
    public void run(Stage stage) {
        stage.setTitle(this.title);
        stage.setScene(this.scene);
        stage.show();
    }

    public void setView(View view) {
        this.rootPane.getChildren().clear();

        Node content = view.getContent();

        AnchorPane.setTopAnchor(content, 0.0);
        AnchorPane.setBottomAnchor(content, 0.0);
        AnchorPane.setLeftAnchor(content, 0.0);
        AnchorPane.setRightAnchor(content, 0.0);

        this.rootPane.getChildren().add(content);
    }

    private void initialize() {
        String FXML = "window-layout.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(WorkersApplication.class.getResource(FXML));
        try {
            ISettings settings = WorkersApplication.getInstance().getSettings();
            this.scene = new Scene(fxmlLoader.load(),
                    this.width,
                    this.height);
            this.rootPane = (AnchorPane)this.scene.lookup("#root_pane");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
