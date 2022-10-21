package com.artech.workerslogin.ui.login;

import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.captcha.CaptchaDialog;
import com.artech.workerslogin.ui.controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
        String login = loginField.getText();
        String password = passwordField.getText();

        if (password.isEmpty() || login.isEmpty()) {
            statusLabel.setText("Вы должны заполнить учетные данные, чтобы войти");
            return;
        }
        else {
            statusLabel.setText("");
        }

        new CaptchaDialog(this.storage).ask();

        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());
    }
}
