package com.artech.workerslogin;

import com.artech.workerslogin.config.SettingsXMLLoader;
import com.artech.workerslogin.core.IApplication;
import com.artech.workerslogin.core.ISettings;
import com.artech.workerslogin.core.query.DatabaseHandle;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.database.storage.ApplicationStorage;
import com.artech.workerslogin.ui.MainWindow;
import com.artech.workerslogin.ui.login.LoginView;
import com.artech.workerslogin.ui.navigation.IUINavigator;
import com.artech.workerslogin.ui.navigation.UINavigator;
import com.artech.workerslogin.ui.profile.ProfileView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class WorkersApplication extends Application implements IApplication {
    private static WorkersApplication instance;
    private final String settingsPath;
    private IStorage storage;
    private ISettings settings;
    private Stage primaryStage;
    private IUINavigator navigator;

    /**
     * Конструктор приложения
     */
    public WorkersApplication() {
        this.settingsPath = "config.xml";

        instance = this;
    }

    @Override
    public void start(Stage stage) throws IOException {
        run(stage);
    }

    public static void main(String[] args) {
        WorkersApplication.launch();
    }

    @Override
    public ISettings getSettings() {
        return this.settings;
    }

    @Override
    public IStorage getStorage() {
        return this.storage;
    }

    @Override
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    @Override
    public IUINavigator getNavigator() {
        return this.navigator;
    }

    public static WorkersApplication getInstance() {
        return instance;
    }

    /**
     * Запускает приложение
     * @param stage Контейнер приложения
     */
    private void run(Stage stage) {
        loadConfig();
        createStorage();
        createUI(stage);
    }

    /**
     * Создает пользователский интерфейс
     * @param stage онтейнер приложения
     */
    private void createUI(Stage stage) {
        primaryStage = stage;

        MainWindow window = new MainWindow(stage, 480, 340, "Login");
        this.navigator = new UINavigator(window);
        this.navigator.register("login", () -> new LoginView(this.storage));
        this.navigator.register("profile", () -> new ProfileView(this.storage));
        this.navigator.navigate("login");
        window.run();
    }

    /**
     * Загружает конфигурацию приложения
     */
    private void loadConfig() {
        SettingsXMLLoader loader = new SettingsXMLLoader(new File(this.settingsPath));
        this.settings = loader.Load();
    }

    /**
     * Создает хранилище данных
     */
    private void createStorage() {
        DatabaseHandle handle = connectDatabase();
        try {
            this.storage = new ApplicationStorage(handle);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Error during initializing data storage");
        }

    }

    /**
     * Создает дескриптор БД
     * @return Дескриптор БД
     */
    private DatabaseHandle connectDatabase() {
        try {
            return new DatabaseHandle(
                    this.settings.getDatabasePath(),
                    this.settings.getDatabaseUsername(),
                    this.settings.getDatabasePassword());
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Error connecting to database");
        }
    }
}