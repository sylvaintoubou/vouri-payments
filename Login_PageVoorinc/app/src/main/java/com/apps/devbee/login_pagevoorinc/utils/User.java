package com.apps.devbee.login_pagevoorinc.utils;

public class User {
    private String username;
    private String user_image_url;
    private String user_email;
    private String user_password;
    private String user_id;
    private long created_time;
    private long updated_time;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public void setUpdated_time(long updated_time) {
        this.updated_time = updated_time;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_id() {
        return user_id;
    }

    public long getCreated_time() {
        return created_time;
    }

    public long getUpdated_time() {
        return updated_time;
    }

    public User() {
        this.username = "Test";
    }
}
