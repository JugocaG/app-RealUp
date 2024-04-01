package com.example.RealUpCotizador.configuration;

import com.example.RealUpCotizador.dto.SignupDTO;
import com.example.RealUpCotizador.dto.UserDTO;


public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
