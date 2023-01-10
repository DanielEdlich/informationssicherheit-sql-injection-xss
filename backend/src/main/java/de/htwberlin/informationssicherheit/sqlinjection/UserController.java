package de.htwberlin.informationssicherheit.sqlinjection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.net.URI;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserDAO userDAO;

    public UserController(UserRepository userRepository, UserDAO userDAO){
        this.userRepository = userRepository;
        this.userDAO = userDAO;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<Object> fetchAllPersons(){
        List<UserModel> userModel = userRepository.findAll();
        return userModel.size() > 0 ? ResponseEntity.ok(userModel.stream().map(UserModel::toUserDTO).toList()) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDTO> fetchPersonById(@PathVariable String id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(model -> ResponseEntity.ok(model.toUserDTO())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/users/auth", consumes = {"application/json"})
    public ResponseEntity<UserDTO> authUser(@RequestBody UserDTO user){
        UserModel userModel = userDAO.authByNamePassword(user);
//        user.setId(id);
        var userDTO = userModel.toUserDTO();
        return userModel.getId() != null ? ResponseEntity.ok(userDTO) : ResponseEntity.badRequest().build();
    }

    @PostMapping(path = "/users", consumes = {"application/json"})
    public ResponseEntity<Void> createUser(@RequestBody UserDTO user) throws URISyntaxException {
        UserModel userModel = new UserModel(user.getName(), user.getPassword());
        userModel = userRepository.save(userModel);
        URI uri = new URI("/api/v1/users/" + userModel.getId());
        return ResponseEntity.created(uri).build();
    }

}
