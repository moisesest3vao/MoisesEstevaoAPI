package br.com.moisesestevao.api.dto;

import br.com.moisesestevao.api.model.RequisicaoServico;

public class RequisicaoServicoDto {
    private Long id;
    private String usuarioNome;
    private String message;
    private String telefone;
    private String email;

    public RequisicaoServicoDto(RequisicaoServico servico) {
        this.id = servico.getId();
        this.usuarioNome = servico.getUsuario().getNome();
        this.message = servico.getMessage();
        this.telefone = servico.getTelefone();
        this.email = servico.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
