package com.artech.workerslogin.ui.login;

import com.artech.workerslogin.core.model.WorkerModel;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.captcha.CaptchaDialog;
import com.artech.workerslogin.ui.controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;

public class LoginController extends Controller {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submitButton;
    @FXML
    private Label statusLabel;

    /**
     * Конструктор контроллера
     *
     * @param storage Зранилище данных
     */
    public LoginController(IStorage storage) {
        super(storage);
    }

    @FXML
    private void initialize() {
        submitButton.setOnAction(e -> handleSubmit());
    }

    private void handleSubmit() {
        System.out.println(this.storage.workerManager().getAll());
        String login = loginField.getText();
        String password = passwordField.getText();

        if (password.isEmpty() || login.isEmpty()) {
            statusLabel.setText("Вы должны заполнить учетные данные, чтобы войти");
            return;
        }
        else {
            statusLabel.setText("");
        }

        if (!new CaptchaDialog(this.storage).ask()) {
            statusLabel.setText("Вы не прошли капчу");
            return;
        }

        WorkerModel model = this.storage.workerManager().getWorker(login, password);

        if (model == null) {
            statusLabel.setText("Неверный логин или пароль");
            return;
        }

        this.storage.workerManager().tryUpdate(new WorkerModel(
                model.id(),
                model.dbId(),
                model.speciality(),
                model.name(),
                model.login(),
                model.password(),
                new Date(),
                model.authStatus()
        ));

        System.out.println(model);
    }
}
