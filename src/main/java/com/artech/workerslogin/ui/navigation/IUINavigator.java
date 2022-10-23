package com.artech.workerslogin.ui.navigation;

public interface IUINavigator {
    void register(String name, IUINavigationEntry entry);
    void navigate(String name);
}
