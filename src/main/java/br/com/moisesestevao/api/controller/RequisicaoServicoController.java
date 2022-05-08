package br.com.moisesestevao.api.controller;

import br.com.moisesestevao.api.dto.RequisicaoServicoDto;
import br.com.moisesestevao.api.form.RequisicaoServicoForm;
import br.com.moisesestevao.api.model.RequisicaoServico;
import br.com.moisesestevao.api.repository.RequisicaoServicoRepository;
import br.com.moisesestevao.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class RequisicaoServicoController {

    @Autowired
    RequisicaoServicoRepository requisicaoServicoRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllMensagem(@RequestParam int p) {
        Pageable page = PageRequest.of(p, 10);

        List<RequisicaoServicoDto> servicos = new ArrayList<>();
        requisicaoServicoRepository.findAll(page).forEach(
                servico -> servicos.add(new RequisicaoServicoDto(servico))
        );
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMensagem(@PathVariable("id") Long id) {
        if (id != null & requisicaoServicoRepository.existsById(id)) {
            RequisicaoServico servico = requisicaoServicoRepository.getById(id);
            return ResponseEntity.ok(new RequisicaoServicoDto(servico));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> criaMensagem(@RequestBody(required = true) RequisicaoServicoForm form){
        if(RequisicaoServicoForm.valida(form, userRepository)){
            RequisicaoServico requisicaoServico = new RequisicaoServico(form, userRepository);
            requisicaoServicoRepository.save(requisicaoServico);
            return ResponseEntity.ok(new RequisicaoServicoDto(requisicaoServico));
        }
        return ResponseEntity.badRequest().build();
    }
}
