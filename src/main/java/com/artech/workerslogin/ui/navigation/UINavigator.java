package com.artech.workerslogin.ui.navigation;

import com.artech.workerslogin.ui.MainWindow;

import java.util.Dictionary;
import java.util.Hashtable;

public class UINavigator implements IUINavigator {

    private final Dictionary<String, IUINavigationEntry> entries;
    private final MainWindow window;

    public UINavigator(MainWindow window) {
        this.window = window;
        this.entries = new Hashtable<>();
    }

    @Override
    public void register(String name, IUINavigationEntry entry) {
        this.entries.put(name, entry);
    }

    @Override
    public void navigate(String name) {
        this.window.setView(this.entries.get(name).getView());
    }
}
