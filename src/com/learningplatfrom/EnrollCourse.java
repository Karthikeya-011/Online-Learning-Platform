package com.learningplatfrom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EnrollCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Enter your User ID:");
            int userId = scanner.nextInt();
            System.out.println("Enter Course ID you want to enroll in:");
            int courseId = scanner.nextInt();

            // Check for existing enrollment
            String checkSql = "SELECT * FROM enrollments WHERE user_id = ? AND course_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, userId);
            checkStmt.setInt(2, courseId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("⚠️ User is already enrolled in this course.");
            } else {
                String sql = "INSERT INTO enrollments (user_id, course_id) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
                pstmt.setInt(2, courseId);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("🎯 Enrollment Successful!");
                } else {
                    System.out.println("❌ Enrollment Failed!");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}


