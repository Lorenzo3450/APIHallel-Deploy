package br.api.hallel.moduloAPI.controller.membro;

import br.api.hallel.moduloAPI.exceptions.associado.AssociadoNotFoundException;
import br.api.hallel.moduloAPI.model.Associado;
import br.api.hallel.moduloAPI.payload.requerimento.BuscarIdAssociadoReq;
import br.api.hallel.moduloAPI.payload.requerimento.EditPerfilRequest;
import br.api.hallel.moduloAPI.payload.requerimento.VirarAssociadoRequest;
import br.api.hallel.moduloAPI.payload.resposta.*;
import br.api.hallel.moduloAPI.service.financeiro.AssociadoService;
import br.api.hallel.moduloAPI.service.main.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/membros")
@CrossOrigin("*")



public class MembroController {

    @Autowired
    private MembroService service;

    @Autowired
    private AssociadoService associadoService;


    // Método para editar o perfil
    @PutMapping("/perfil/editar/{id}")
    public ResponseEntity<EditPerfilResponse> editarPerfil(@PathVariable String id, @RequestBody EditPerfilRequest editPerfilRequest) {
        try {
            EditPerfilResponse perfilAtualizado = service.editarPerfil(id, editPerfilRequest);
            return ResponseEntity.ok(perfilAtualizado);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<PerfilResponse> visualizarPerfil(@PathVariable String id) throws IllegalAccessException {

        System.out.println("oi");
        System.out.println(id);
        PerfilResponse perfil = this.service.visualizarPerfil(id);
        return ResponseEntity.status(200).body(perfil);
    }

    @PostMapping("/virarAssociado")
    public ResponseEntity<VirarAssociadoResponse> createAssociado(@RequestBody VirarAssociadoRequest virarAssociadoRequest) {

        VirarAssociadoResponse response = new VirarAssociadoResponse();

        try {
            response.setResultado(this.associadoService.criarAssociado(virarAssociadoRequest));

            if (response.getResultado()) {
                return ResponseEntity.status(200).body(response);
            } else {
                return ResponseEntity.status(402).body(response);
            }
        } catch (AssociadoNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{data}/virarAssociado")
    public ResponseEntity<VirarAssociadoResponse> createAssociadoMobile(@PathVariable(value = "data") String data,
            @RequestBody VirarAssociadoRequest virarAssociadoRequest) throws ParseException {

        VirarAssociadoResponse response = new VirarAssociadoResponse();

        data = data.replace("-", "/");

        SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy"); // Formato da string recebida





        Date data2 = sdfInput.parse(data);


        virarAssociadoRequest.setDataValidadeCartao(data2);


        try {
            response.setResultado(this.associadoService.criarAssociado(virarAssociadoRequest));

            if (response.getResultado()) {
                return ResponseEntity.status(200).body(response);
            } else {
                return ResponseEntity.status(402).body(response);
            }
        } catch (AssociadoNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/buscarAssociadoEmail")
    public ResponseEntity<BuscarIdAssociadoRes> buscarAssociado(@RequestBody BuscarIdAssociadoReq buscarIdAssociadoReq) {

        System.out.println(buscarIdAssociadoReq.getEmail()); // Verifique se o email está sendo corretamente capturado
        return ResponseEntity.ok().body(this.associadoService.IdAssociadofindByEmail(buscarIdAssociadoReq.getEmail()));
    }



}