package com.garfild63.coffee;

public class User {
    public String login;
    public String password;
    public String token;
    public int tokenLifeTime;
    public User(String login, String password) { this.login = login; this.password = password; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getToken() { return token; }
    public int getTokenLifeTime() { return tokenLifeTime; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }
    public void setToken(String token) { this.token = token; }
    public void setTokenLifeTime(int tokenLifeTime) { this.tokenLifeTime = tokenLifeTime; }
}
