package com.desktop.simple_app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    private ResourceBundle resourceBundle;

    private boolean isEnglish = true;

    @FXML
    private Label helloWorldLabel;

    @FXML
    private Button sayHelloButton;

    @FXML
    private Label languageLabel;

    @FXML
    private Button changeLanguageButton;

    @FXML
    void initialize() {
        loadLanguage("en");
    }

    @FXML
    private void changeLanguage() {
        if(isEnglish){
            isEnglish = false;
            loadLanguage("fra");
        } else {
            isEnglish = true;
            loadLanguage("en");
        }

    }

    @FXML
    private void sayHelloWorld() {
        helloWorldLabel.setText(resourceBundle.getString("helloWorldLabel"));
    }

    private void loadLanguage(String lang) {
        Locale locale = new Locale(lang);
        resourceBundle = ResourceBundle.getBundle("com/desktop/simple_app/language", locale);
        helloWorldLabel.setText("");
        initializeElements();
    }

    private void initializeElements() {
        sayHelloButton.setText(resourceBundle.getString("sayHelloButton"));
        changeLanguageButton.setText(resourceBundle.getString("changeLanguageButton"));
        languageLabel.setText(resourceBundle.getString("languageLabel"));
    }
}