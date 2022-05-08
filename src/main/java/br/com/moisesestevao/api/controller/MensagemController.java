package br.com.moisesestevao.api.controller;

import br.com.moisesestevao.api.form.MensagemForm;
import br.com.moisesestevao.api.model.Mensagem;
import br.com.moisesestevao.api.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemRepository repository;

    @PostMapping
    public ResponseEntity<?> recebeMensagem(@RequestBody @Valid MensagemForm form){
        Mensagem mensagem = new Mensagem(form);
        repository.save(mensagem);
        return ResponseEntity.ok(form);
    }
}
