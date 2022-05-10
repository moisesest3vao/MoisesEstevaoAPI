package br.com.moisesestevao.api.controller;

import br.com.moisesestevao.api.dto.MensagemDto;
import br.com.moisesestevao.api.form.MensagemForm;
import br.com.moisesestevao.api.model.Mensagem;
import br.com.moisesestevao.api.model.enums.StatusLiberacao;
import br.com.moisesestevao.api.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemRepository repository;
    StatusLiberacao status = StatusLiberacao.LIBERADO;

    @CrossOrigin(origins = "localhost:4200")
    @PostMapping
    public ResponseEntity<?> recebeMensagem(@RequestBody @Valid MensagemForm form){
        if(!this.validaSpam()){
            return ResponseEntity.badRequest().build();
        }
        Mensagem mensagem = new Mensagem(form);
        repository.save(mensagem);
        return ResponseEntity.ok(new MensagemDto(mensagem));
    }

    private boolean validaSpam() {
        if (this.status == StatusLiberacao.LIBERADO){
            this.status = StatusLiberacao.BLOQUEADO;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    status = StatusLiberacao.LIBERADO;
                }
            }, 5*1000);
            return true;
        }
        return false;
    }

    @GetMapping
    public ResponseEntity<?> getAllMensagem(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size
    ){
        Page<Mensagem> all = this.repository.findAll(PageRequest.of(page, size));
        List<MensagemDto> allDto = new ArrayList<>();
        all.forEach(mensagem -> {
            allDto.add(new MensagemDto(mensagem));
        });
        return ResponseEntity.ok(allDto);
    }
}
