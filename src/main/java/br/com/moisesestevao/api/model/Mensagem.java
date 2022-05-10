package br.com.moisesestevao.api.model;

import br.com.moisesestevao.api.form.MensagemForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Mensagem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String telefone;
    private String email;
    private String nome;
    private String assunto;
    private String mensagem;

    public Mensagem(){

    }
    public Mensagem(String telefone, String email, String nome, String assunto, String mensagem) {
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public Mensagem(MensagemForm form) {
        this.telefone = form.getTelefone();
        this.email = form.getEmail();
        this.nome = form.getNome();
        this.assunto = form.getAssunto();
        this.mensagem = form.getMensagem();
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", assunto='" + assunto + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
