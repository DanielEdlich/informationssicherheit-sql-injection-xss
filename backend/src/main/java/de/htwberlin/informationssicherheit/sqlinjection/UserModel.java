package de.htwberlin.informationssicherheit.sqlinjection;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "USER")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
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

    public UserDTO toUserDTO() {
        return new UserDTO(id, name, password);
    }
}
