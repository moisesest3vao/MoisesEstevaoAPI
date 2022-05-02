package br.com.moisesestevao.api.form;

import br.com.moisesestevao.api.repository.UserRepository;

public class RequisicaoServicoForm {
    private Long userId;
    private String message;
    private String telefone;
    private String email;

    public static boolean valida(RequisicaoServicoForm form, UserRepository userRepository){
        return
                form.email != null &&
                        form.message != null &&
                        form.telefone != null &&
                        userRepository.existsById(form.userId);

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
