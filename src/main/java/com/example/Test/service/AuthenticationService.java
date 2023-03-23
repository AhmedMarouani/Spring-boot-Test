    package com.example.Test.service;

    import com.example.Test.model.AuthenticationRequest;
    import com.example.Test.model.Client;
    import com.example.Test.model.ERole;
    import com.example.Test.model.RegisterRequest;
    import com.example.Test.repository.ClientRepository;
    import com.example.Test.response.AuthenticationResponse;
    import com.example.Test.security.jwt.JwtService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class AuthenticationService {

        private final ClientRepository clientRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
            var user = Client.builder()
                    .nom(request.getNom())
                    .prenom(request.getPrenom())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .erole(ERole.CLIENT)
                    .build();
            if(!clientRepository.existsByEmail(request.getEmail())){
                clientRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder().token(jwtToken).build();
            }else{
                throw new RuntimeException("Email already exists");
            }

        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );//get user
            var user = clientRepository.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);//generate token
            return AuthenticationResponse.builder().token(jwtToken).build();
        }
    }
