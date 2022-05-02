package br.com.moisesestevao.api.form;

import br.com.moisesestevao.api.repository.UserRepository;

public class UserForm {
    private String nome;
    private String email;
    private String senha;

    public static boolean valida(UserForm form, UserRepository userRepository) {
        if(form.email!= null && form.nome != null && form.senha != null){
            if(!userRepository.findByUsername(form.email).isPresent()) {
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
