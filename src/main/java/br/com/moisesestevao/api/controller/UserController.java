package br.com.moisesestevao.api.controller;

import br.com.moisesestevao.api.dto.UserDto;
import br.com.moisesestevao.api.form.UserForm;
import br.com.moisesestevao.api.model.User;
import br.com.moisesestevao.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> criaUsuario(@RequestBody UserForm form){
        if(UserForm.valida(form, userRepository)){
            User usuario = new User(form);
            userRepository.save(usuario);
            return ResponseEntity.ok(new UserDto(usuario));
        }
        return ResponseEntity.badRequest().build();
    }
}
