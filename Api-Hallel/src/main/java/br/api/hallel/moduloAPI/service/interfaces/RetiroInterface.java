package br.api.hallel.moduloAPI.service.interfaces;

import br.api.hallel.moduloAPI.model.ContribuicaoEvento;
import br.api.hallel.moduloAPI.model.Retiro;
import br.api.hallel.moduloAPI.payload.requerimento.AlimentoReq;
import br.api.hallel.moduloAPI.payload.requerimento.RetiroRequest;
import br.api.hallel.moduloAPI.payload.resposta.AlimentoResponse;
import br.api.hallel.moduloAPI.payload.resposta.RetiroResponse;

import java.util.List;

public interface RetiroInterface {
    Retiro createRetiro(RetiroRequest request);

    List<RetiroResponse> listAllRetiros();

    RetiroResponse listRetiroById(String id);

    RetiroResponse updateRetiroById(RetiroRequest request, String id);

    void deleteRetiroById(String id);

    AlimentoReq addAlimentosRetiro(String idRetiro, AlimentoReq alimentoReq);

    AlimentoReq removeAlimentoRetiro(String idRetiro, AlimentoReq alimentoReq);

    AlimentoReq atualizarAlimentoRetiro(String idRetiro, AlimentoReq alimentoReq);
    List<AlimentoResponse> listAllAlimentosByRetiro(String idRetiro);

    ContribuicaoEvento addContribuicaoRetiro(String idRetiro, ContribuicaoEvento contribuicaoEvento);

    // Remover contribuição do retiro
    void removeContribuicaoRetiro(String idRetiro, ContribuicaoEvento contribuicaoEvento);

    // Atualizar contribuição no retiro
    ContribuicaoEvento updateContribuicaoRetiro(String idRetiro, ContribuicaoEvento contribuicaoEvento);

    // Listar todas as contribuições do retiro
    List<ContribuicaoEvento> listAllContribuicoesByRetiro(String idRetiro);
}
