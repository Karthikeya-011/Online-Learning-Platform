package com.learningplatfrom;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineLearningPlatform {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Online Learning Platform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create a label and text field for user input (User ID)
        JLabel userIdLabel = new JLabel("Enter User ID:");
        JTextField userIdTextField = new JTextField(20);

        // Create a button for course recommendations
        JButton recommendButton = new JButton("Get Course Recommendations");
        recommendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the User ID input as an integer
                    int userId = Integer.parseInt(userIdTextField.getText());

                    // Call method to get recommendations
                    CourseRecommendation recommend = new CourseRecommendation();
                    List<String> recommendedCourses = recommend.getRecommendedCourses(userId);

                    // Display the recommended courses
                    if (recommendedCourses.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "No recommendations found for User " + userId);
                    } else {
                        String courseList = String.join(", ", recommendedCourses);
                        JOptionPane.showMessageDialog(frame, "Recommended Courses for User " + userId + ": " + courseList);
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid user ID input
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric User ID.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(userIdLabel);
        panel.add(userIdTextField);
        panel.add(recommendButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}



