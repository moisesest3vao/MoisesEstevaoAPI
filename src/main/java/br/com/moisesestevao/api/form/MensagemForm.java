package br.com.moisesestevao.api.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MensagemForm {
    @NotNull @NotBlank
    private String telefone;
    @NotNull @NotBlank
    private String email;
    @NotNull @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String assunto;
    @NotNull @NotBlank
    private String mensagem;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "MensagemForm{" +
                "telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", assunto='" + assunto + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
