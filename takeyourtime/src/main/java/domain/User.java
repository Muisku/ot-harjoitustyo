/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * Järjestelmän käyttäjää edustava luokka
 */
public class User {

    String name;
    String username;

    public User(String name, String username) {

        this.name = name;
        this.username = username;

    }

    public String getUsername() {

        return username;

    }

    public String getName() {

        return name;

    }
}
