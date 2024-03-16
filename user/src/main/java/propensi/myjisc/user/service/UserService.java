package propensi.myjisc.user.service;

import propensi.myjisc.user.dto.RegisterRequest;
import propensi.myjisc.user.model.User;
import propensi.myjisc.user.repository.UserRepository;

public class UserService {

    private  UserRepository userRepository;
    
    public void updateUser(RegisterRequest registerRequest) {
        User user = userRepository.findByEmail(registerRequest.getEmail())
        .orElseThrow(() -> new RuntimeException("User not found"));

    user.setUsername(registerRequest.getUsername());
    user.setEmail(registerRequest.getEmail());
    // update other fields...

    userRepository.save(user);
    }

    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

    public void changePassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(newPassword);
        userRepository.save(user);
    }

    


}
