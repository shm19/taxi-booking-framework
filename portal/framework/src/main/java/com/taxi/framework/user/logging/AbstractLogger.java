package com.taxi.user.logging;

import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractLogger {

    @Autowired
    private Connection sqliteConnection;

    protected void logUserAction(String username, String action) {
        String sql = "INSERT INTO user_logs(username, action) VALUES(?, ?)";
        try (PreparedStatement pstmt = sqliteConnection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, action);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
