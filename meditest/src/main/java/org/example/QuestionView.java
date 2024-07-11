package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuestionView {
    private JFrame frame;
    private JPanel panelMain, panelQuestions, panelResults, panelDetails;
    private CardLayout cardLayout;
    private JLabel questionLabel;
    private JPanel buttonPanel;
    private JTextArea resultsArea;
    private JTextArea detailsArea;
    private JButton[] ratingButtons;
    private JButton nextButton, finishButton, nextDetailButton, finishDetailButton;

    public QuestionView() {
        frame = new JFrame("Mental Health Management System");
        cardLayout = new CardLayout();
        panelMain = new JPanel(cardLayout);

        createQuestionsPanel();
        createResultsPanel();
        createDetailsPanel();

        frame.add(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private void createQuestionsPanel() {
        panelQuestions = new JPanel();
        panelQuestions.setLayout(new BorderLayout(10, 10));
        panelQuestions.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelQuestions.setBackground(new Color(230, 240, 255));

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelQuestions.add(questionLabel, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(230, 240, 255));

        ratingButtons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            ratingButtons[i] = new JButton(String.valueOf(i + 1));
            ratingButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            ratingButtons[i].setBackground(new Color(173, 216, 230));
            buttonPanel.add(ratingButtons[i]);
        }
        panelQuestions.add(buttonPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton.setBackground(new Color(100, 149, 237));
        nextButton.setForeground(Color.WHITE);
        JPanel nextButtonPanel = new JPanel();
        nextButtonPanel.setLayout(new BoxLayout(nextButtonPanel, BoxLayout.X_AXIS));
        nextButtonPanel.add(Box.createHorizontalGlue());
        nextButtonPanel.add(nextButton);
        panelQuestions.add(nextButtonPanel, BorderLayout.SOUTH);

        panelMain.add(panelQuestions, "Questions");
    }

    private void createResultsPanel() {
        panelResults = new JPanel();
        panelResults.setLayout(new BorderLayout(10, 10));
        panelResults.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelResults.setBackground(new Color(255, 228, 196));

        JLabel resultsLabel = new JLabel("Results", SwingConstants.CENTER);
        resultsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelResults.add(resultsLabel, BorderLayout.NORTH);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        resultsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelResults.add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        finishButton = new JButton("Finish");
        finishButton.setFont(new Font("Arial", Font.PLAIN, 16));
        finishButton.setBackground(new Color(244, 164, 96));
        finishButton.setForeground(Color.WHITE);
        JPanel finishButtonPanel = new JPanel();
        finishButtonPanel.setLayout(new BoxLayout(finishButtonPanel, BoxLayout.X_AXIS));
        finishButtonPanel.add(Box.createHorizontalGlue());
        finishButtonPanel.add(finishButton);
        panelResults.add(finishButtonPanel, BorderLayout.SOUTH);

        panelMain.add(panelResults, "Results");
    }

    private void createDetailsPanel() {
        panelDetails = new JPanel();
        panelDetails.setLayout(new BorderLayout(10, 10));
        panelDetails.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelDetails.setBackground(new Color(240, 255, 240));

        JLabel detailsLabel = new JLabel("Details", SwingConstants.CENTER);
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelDetails.add(detailsLabel, BorderLayout.NORTH);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelDetails.add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        nextDetailButton = new JButton("Next Detail");
        nextDetailButton.setFont(new Font("Arial", Font.PLAIN, 16));
        nextDetailButton.setBackground(new Color(152, 251, 152));
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
}

