package br.com.moisesestevao.api.dto;

import br.com.moisesestevao.api.model.Mensagem;

public class MensagemDto {
    private Long id;
    private String telefone;
    private String email;
    private String nome;
    private String assunto;
    private String mensagem;
    public MensagemDto(Mensagem mensagem) {
        this.id = mensagem.getId();
        this.telefone = mensagem.getTelefone();
        this.nome = mensagem.getNome();
        this.assunto = mensagem.getAssunto();
        this.mensagem = mensagem.getMensagem();
        this.email = mensagem.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getMensagem() {
        return mensagem;
    }
}
