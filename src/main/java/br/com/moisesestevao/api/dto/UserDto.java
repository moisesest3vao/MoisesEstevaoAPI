package br.com.moisesestevao.api.dto;

import br.com.moisesestevao.api.model.User;

public class UserDto {
    private String nome;
    private String username;

    public UserDto(User usuario) {
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
