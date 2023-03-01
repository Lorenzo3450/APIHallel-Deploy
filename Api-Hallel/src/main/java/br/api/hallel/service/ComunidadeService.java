package br.api.hallel.service;

import br.api.hallel.model.Comunidade;
import br.api.hallel.model.Doacao;
import br.api.hallel.model.Eventos;
import br.api.hallel.repository.ComunidadeRepository;
import br.api.hallel.service.interfaces.ComunidadeInterface;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ComunidadeService implements ComunidadeInterface {

    @Autowired
    private ComunidadeRepository repository;

    Logger logger =(Logger) LoggerFactory.getLogger(ComunidadeService.class);


    //CRIA UMA DOAÇÃO, OU APENAS ALTERA AS INFORMAÇÕES DELA
    @Override
    public void atualizarDoacao(Doacao doacao) {
        Comunidade comunidade = getComunidade();

        if (comunidade.getDoacaoTotal() != null) {
            comunidade.getDoacaoTotal().add(doacao);
            //ADICIONA A DOAÇÃO

            logger.info("DOAÇÃO ADICIONADA!");

        } else {
            ArrayList<Doacao> doacoes = new ArrayList<>();
            doacoes.add(doacao);
            comunidade.setDoacaoTotal(doacoes);
            //CRIA UMA LISTA PARA PODER ADICIONAR AS DOAÇÕES
            logger.info("LISTA DE DOAÇÃO SALVA!");

        }

        if (comunidade.getDoacaoMensais() != null) {
            comunidade.getDoacaoMensais().add(doacao);
            logger.info("DOAÇÃO MENSAL SALVA!");

        } else {
            ArrayList<Doacao> doacoes = new ArrayList<>();
            doacoes.add(doacao);
            comunidade.setDoacaoMensais(doacoes);
            logger.info("LISTA DE DOAÇÕES MENSAIL SALVA!");

        }

        logger.info("ALTERAÇÕES REALIZADAS NAS CONDIÇÕES FORAM SALVAS!");

        repository.save(comunidade);
    }

    //MÉTODO PARA RESGATAR A 'COMUNIDADE' DO BANCO DE DADOS, PARA PODER REALIZAR AS OPERAÇÕES
    //NECESSÁRIAS
    @Override
    public Comunidade getComunidade() {
        return repository.findById("63e28aa8543a7bca82109218").get() != null ?
                repository.findById("63e28aa8543a7bca82109218").get() :
                null;
    }



}
