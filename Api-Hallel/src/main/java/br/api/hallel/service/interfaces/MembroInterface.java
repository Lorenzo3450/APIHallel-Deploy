package br.api.hallel.service.interfaces;

import java.util.List;

import br.api.hallel.model.Membro;
import br.api.hallel.model.StatusMembro;
import br.api.hallel.payload.resposta.PerfilResponse;

public interface MembroInterface {

    public Membro createMembro(Membro membro);

    public List<Membro> listAllMembros();

    public Membro listMembroId(String id);

    public Membro updatePerfilMembro(String id, Membro membroModel);

    public void deleteMembroById(String id);

    public Membro findByEmailAndPassword(String email, String senha);

    public List<Membro> findByStatusAtivo();

    public List<Membro> findByStatusPendente();

    public Membro findByEmail(String email);

    PerfilResponse visualizarPerfil(String id) throws IllegalAccessException;
}