package propensi.myjisc.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propensi.myjisc.user.model.User;
import propensi.myjisc.user.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private  UserRepository userRepository;

    @GetMapping("/user")
    public Map<String, String > helloWorld() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "This is a template");
        return response;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
}

    @PutMapping("/user/update/{id}")
    public Map<String, String> updateData() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "This is a template with id");
        return response;
    }
}
