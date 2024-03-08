package propensi.myjisc.user.service;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import propensi.myjisc.user.dto.AuthRequestDTO;
import propensi.myjisc.user.dto.AuthResponseDTO;
import propensi.myjisc.user.dto.RegisterRequest;
import propensi.myjisc.user.model.User;
import propensi.myjisc.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponseDTO register(RegisterRequest request) {
        var user = User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseDTO.builder()
            .token(jwtToken)
            .build();
        
        
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
         authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        var user = userRepository.findByUsername(request.getUsername())
            .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
            return AuthResponseDTO.builder()
            .token(jwtToken)
            .build();
    }
}
