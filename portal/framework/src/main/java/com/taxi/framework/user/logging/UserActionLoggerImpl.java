package com.taxi.user.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UserActionLoggerImpl implements UserActionLogger {

    @Autowired
    private Connection sqliteConnection;

    @Override
    public void logUserAction(String username, String action) {
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
