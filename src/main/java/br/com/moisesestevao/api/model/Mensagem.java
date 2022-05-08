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
}
