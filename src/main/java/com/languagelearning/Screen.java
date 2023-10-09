package com.languagelearning;

public interface Screen {

    public int sceneX = 1000;
    public int sceneY = 500;

    void navigateToScreen(Screen nextScreen);
}

