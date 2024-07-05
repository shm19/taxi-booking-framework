package com.taxi.user.dto;

public class ExtendedUserActionDTO {
    private String username;
    private String action;

    public ExtendedUserActionDTO(String username, String action) {
        this.username = username;
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
