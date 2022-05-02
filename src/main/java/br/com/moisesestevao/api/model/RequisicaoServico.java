package br.com.moisesestevao.api.model;

import br.com.moisesestevao.api.form.RequisicaoServicoForm;
import br.com.moisesestevao.api.repository.UserRepository;

import javax.persistence.*;

@Entity
public class RequisicaoServico {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private User usuario;
    private String message;
    private String telefone;
    private String email;

    public RequisicaoServico(){

    }

    public RequisicaoServico(RequisicaoServicoForm form, UserRepository repository){
        this.message = form.getMessage();
        this.email = form.getEmail();
        this.telefone = form.getTelefone();
        this.usuario = repository.getById(form.getUserId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
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
