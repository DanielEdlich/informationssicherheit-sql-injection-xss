package de.htwberlin.informationssicherheit.sqlinjection;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, String> {

    @Query("select u from UserModel u where u.name = :name AND u.password = :password")
    public UserModel authByNameEmail(@Param("name") String name, @Param("password") String password);

//    @Override
//    @Query("select UserModel from UserModel user where user.id = :s")
//    Optional<UserModel> findById(String s);
}
