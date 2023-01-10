package de.htwberlin.informationssicherheit.sqlinjection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public UserModel authByNamePassword(UserDTO user) {
        String jql = "from UserModel where name = '" + user.getName() + "' AND password = '" + user.getPassword() + "'";
        TypedQuery<UserModel> q = em.createQuery(jql, UserModel.class);
        return q.getSingleResult();

    }
}
