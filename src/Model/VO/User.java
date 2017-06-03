/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.util.Properties;

/**
 *
 *
 */
public class User {
    private final String dbUrl;
    private String user;
    private String password;

    public User(String dbUrl) {
        this.dbUrl = dbUrl;
        this.user = null;
        this.password = null;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", password);
        return properties;
    }
}
