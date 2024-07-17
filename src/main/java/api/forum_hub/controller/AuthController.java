package api.forum_hub.controller;

import api.forum_hub.domain.user.User;
import api.forum_hub.domain.user.UserAuth;
import api.forum_hub.security.TokenDto;
import api.forum_hub.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@Valid @RequestBody UserAuth userAuth) {
        var authToken = new UsernamePasswordAuthenticationToken(userAuth.username(), userAuth.password());
        var auth =  authenticationManager.authenticate(authToken);

        var tokenJWT = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDto(tokenJWT));
    }
}