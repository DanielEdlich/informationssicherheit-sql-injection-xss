package de.htwberlin.informationssicherheit.sqlinjection;

import jakarta.validation.constraints.Size;

public class UserDTO {

    String id;

    @Size(min = 3, message = "Please provide a Username with 3 characters or more.")
    private String name;

    public UserDTO(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserDTO() {
    }

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", name:'" + name + '\'' +
                ", password:'" + password + '\'' +
                '}';
    }
}
