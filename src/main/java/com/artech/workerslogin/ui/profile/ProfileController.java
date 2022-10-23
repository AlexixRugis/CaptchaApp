package com.artech.workerslogin.ui.profile;

import com.artech.workerslogin.WorkersApplication;
import com.artech.workerslogin.core.model.WorkerModel;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProfileController extends Controller {

    @FXML
    private Label nameLabel;
    @FXML
    private Label specialityLabel;
    @FXML
    private Button exitButton;

    /**
     * Конструктор контроллера
     *
     * @param storage Зранилище данных
     */
    public ProfileController(IStorage storage) {
        super(storage);
    }

    @FXML
    private void initialize() {

        WorkerModel model = this.storage.loginManager().getCurrentAccount();
        nameLabel.setText(model.name());
        specialityLabel.setText(model.speciality());

        exitButton.setOnAction((e) -> handleExitButton());
    }

    private void handleExitButton() {
        this.storage.loginManager().setCurrentAccount(null);
        WorkersApplication.getInstance().getNavigator().navigate("login");
    }
}
