package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuestionView {
    private JFrame frame;
    private JPanel panelMain, panelInitial, panelLogin, panelQuestions, panelResults, panelDetails, panelCreateUser;
    private CardLayout cardLayout;
    private JLabel questionLabel;
    private JPanel buttonPanel;
    private JTextArea resultsArea;
    private JTextArea detailsArea;
    private JButton[] ratingButtons;
    private JButton nextButton, finishButton, nextDetailButton, finishDetailButton;
    private JButton loginButton, createUserButton, initialLoginButton, initialCreateUserButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel loginMessageLabel;
    private JProgressBar progressBar;
    private JLabel usernameLabel;
    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JButton createButton;

    public QuestionView() {
        frame = new JFrame("Mental Health Management System");
        cardLayout = new CardLayout();
        panelMain = new JPanel(cardLayout);

        createInitialPanel(); // Add the initial panel
        createLoginPanel();
        createQuestionsPanel();
        createResultsPanel();
        createDetailsPanel();
        createCreateUserPanel(); // Add the create user panel

        frame.add(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        // Show the initial panel first
        cardLayout.show(panelMain, "Initial");
    }

    private void createInitialPanel() {
        panelInitial = new JPanel();
        panelInitial.setLayout(new BorderLayout(10, 10));
        panelInitial.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelInitial.setBackground(new Color(255, 248, 220));

        JLabel welcomeLabel = new JLabel("Welcome to Mental Health Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelInitial.add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(new Color(255, 248, 220));

        initialLoginButton = new JButton("Login");
        initialLoginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        initialLoginButton.setBackground(new Color(34, 139, 34));
        initialLoginButton.setForeground(Color.WHITE);
        buttonPanel.add(initialLoginButton);

        initialCreateUserButton = new JButton("Create a User");
        initialCreateUserButton.setFont(new Font("Arial", Font.PLAIN, 16));
        initialCreateUserButton.setBackground(new Color(34, 139, 34));
        initialCreateUserButton.setForeground(Color.WHITE);
        buttonPanel.add(initialCreateUserButton);

        panelInitial.add(buttonPanel, BorderLayout.CENTER);

        panelMain.add(panelInitial, "Initial");
    }

    private void createLoginPanel() {
        panelLogin = new JPanel();
        panelLogin.setLayout(new BorderLayout(10, 10));
        panelLogin.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelLogin.setBackground(new Color(255, 248, 220));

        JLabel loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelLogin.add(loginLabel, BorderLayout.NORTH);

        JPanel loginFieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        loginFieldsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        loginFieldsPanel.setBackground(new Color(255, 248, 220));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        loginFieldsPanel.add(usernameLabel);

        usernameField = new JTextField();
        loginFieldsPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        loginFieldsPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        loginFieldsPanel.add(passwordField);

        loginMessageLabel = new JLabel("", SwingConstants.CENTER);
        loginMessageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        loginMessageLabel.setForeground(Color.RED);
        loginFieldsPanel.add(loginMessageLabel);

        panelLogin.add(loginFieldsPanel, BorderLayout.CENTER);

        loginButton = new JButton("Start");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.setBackground(new Color(34, 139, 34));
        loginButton.setForeground(Color.WHITE);
        JPanel loginButtonPanel = new JPanel();
        loginButtonPanel.setLayout(new BoxLayout(loginButtonPanel, BoxLayout.X_AXIS));
        loginButtonPanel.add(Box.createHorizontalGlue());
        loginButtonPanel.add(loginButton);
        panelLogin.add(loginButtonPanel, BorderLayout.SOUTH);

        panelMain.add(panelLogin, "Login");
    }

    private void createCreateUserPanel() {
        panelCreateUser = new JPanel();
        panelCreateUser.setLayout(new BorderLayout(10, 10));
        panelCreateUser.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelCreateUser.setBackground(new Color(255, 248, 220));

        JLabel createUserLabel = new JLabel("Create a User", SwingConstants.CENTER);
        createUserLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelCreateUser.add(createUserLabel, BorderLayout.NORTH);

        JPanel createUserFieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        createUserFieldsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        createUserFieldsPanel.setBackground(new Color(255, 248, 220));

        JLabel newUsernameLabel = new JLabel("Username:");
        newUsernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        createUserFieldsPanel.add(newUsernameLabel);

        newUsernameField = new JTextField();
        createUserFieldsPanel.add(newUsernameField);

        JLabel newPasswordLabel = new JLabel("Password:");
        newPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        createUserFieldsPanel.add(newPasswordLabel);

        newPasswordField = new JPasswordField();
        createUserFieldsPanel.add(newPasswordField);

        panelCreateUser.add(createUserFieldsPanel, BorderLayout.CENTER);

        createButton = new JButton("Create");
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setBackground(new Color(34, 139, 34));
        createButton.setForeground(Color.WHITE);
        JPanel createButtonPanel = new JPanel();
        createButtonPanel.setLayout(new BoxLayout(createButtonPanel, BoxLayout.X_AXIS));
        createButtonPanel.add(Box.createHorizontalGlue());
        createButtonPanel.add(createButton);
        panelCreateUser.add(createButtonPanel, BorderLayout.SOUTH);

        panelMain.add(panelCreateUser, "CreateUser");
    }

    private void createQuestionsPanel() {
        panelQuestions = new JPanel();
        panelQuestions.setLayout(new BorderLayout(10, 10));
        panelQuestions.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelQuestions.setBackground(new Color(230, 240, 255));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(230, 240, 255));

        usernameLabel = new JLabel("", SwingConstants.LEFT);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        topPanel.add(usernameLabel, BorderLayout.WEST);

        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setValue(0);
        topPanel.add(progressBar, BorderLayout.CENTER);

        panelQuestions.add(topPanel, BorderLayout.NORTH);

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panelQuestions.add(questionLabel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(new Color(230, 240, 255));
        panelQuestions.add(buttonPanel, BorderLayout.SOUTH);

        ratingButtons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            ratingButtons[i] = new JButton((i + 1) + " = " + getRatingText(i + 1));
            buttonPanel.add(ratingButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton.setEnabled(false);
        panelQuestions.add(nextButton, BorderLayout.EAST);

        panelMain.add(panelQuestions, "Questions");
    }

    private String getRatingText(int rating) {
        switch (rating) {
            case 1:
                return "Never";
            case 2:
                return "Rarely";
            case 3:
                return "Sometimes";
            case 4:
                return "Often";
            case 5:
                return "Always";
            default:
                return "";
        }
    }

    private void createResultsPanel() {
        panelResults = new JPanel();
        panelResults.setLayout(new BorderLayout(10, 10));
        panelResults.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelResults.setBackground(new Color(255, 248, 220));

        JLabel resultsLabel = new JLabel("Results", SwingConstants.CENTER);
        resultsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelResults.add(resultsLabel, BorderLayout.NORTH);

        resultsArea = new JTextArea();
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        resultsArea.setLineWrap(true);
        resultsArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        panelResults.add(scrollPane, BorderLayout.CENTER);

        finishButton = new JButton("Finish");
        finishButton.setFont(new Font("Arial", Font.PLAIN, 16));
        panelResults.add(finishButton, BorderLayout.SOUTH);

        panelMain.add(panelResults, "Results");
    }

    private void createDetailsPanel() {
        panelDetails = new JPanel();
        panelDetails.setLayout(new BorderLayout(10, 10));
        panelDetails.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelDetails.setBackground(new Color(255, 248, 220));

        JLabel detailsLabel = new JLabel("Details", SwingConstants.CENTER);
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelDetails.add(detailsLabel, BorderLayout.NORTH);

        detailsArea = new JTextArea();
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);
        JScrollPane detailsScrollPane = new JScrollPane(detailsArea);
        panelDetails.add(detailsScrollPane, BorderLayout.CENTER);

        nextDetailButton = new JButton("Next");
        nextDetailButton.setFont(new Font("Arial", Font.PLAIN, 16));
        nextDetailButton.setBackground(new Color(144, 238, 144));
        nextDetailButton.setForeground(Color.WHITE);
        finishDetailButton = new JButton("Finish");
        finishDetailButton.setFont(new Font("Arial", Font.PLAIN, 16));
        finishDetailButton.setBackground(new Color(144, 238, 144));
        finishDetailButton.setForeground(Color.WHITE);
        JPanel detailButtonPanel = new JPanel();
        detailButtonPanel.setLayout(new BoxLayout(detailButtonPanel, BoxLayout.X_AXIS));
        detailButtonPanel.add(nextDetailButton);
        detailButtonPanel.add(Box.createHorizontalStrut(10));
        detailButtonPanel.add(finishDetailButton);
        panelDetails.add(detailButtonPanel, BorderLayout.SOUTH);

        panelMain.add(panelDetails, "Details");
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JLabel getQuestionLabel() {
        return questionLabel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JTextArea getResultsArea() {
        return resultsArea;
    }

    public JTextArea getDetailsArea() {
        return detailsArea;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public JButton getNextDetailButton() {
        return nextDetailButton;
    }

    public JButton getFinishDetailButton() {
        return finishDetailButton;
    }

    public JButton[] getRatingButtons() {
        return ratingButtons;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JLabel getLoginMessageLabel() {
        return loginMessageLabel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JButton getInitialLoginButton() {
        return initialLoginButton;
    }

    public JButton getInitialCreateUserButton() {
        return initialCreateUserButton;
    }

    public JTextField getNewUsernameField() {
        return newUsernameField;
    }

    public JPasswordField getNewPasswordField() {
        return newPasswordField;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void updateProgressBar(int current, int total) {
        progressBar.setMaximum(total);
        progressBar.setValue(current);
    }
}
