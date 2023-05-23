package br.api.hallel.payload.resposta;

import br.api.hallel.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoCursoResponse {
    private String id;
    private String nome;
    private String email;
    private String dataNascimentoAssociado;
    private AssociadoRole isAssociado;
    private Boolean isPago;
    private StatusMembro status;

    public Associado toAssociado(Associado associado) {
        Associado associadoVal = new Associado();

        associadoVal.setId(associado.getId());
        associadoVal.setNome(associado.getNome());
        associadoVal.setEmail(associado.getEmail());
        associadoVal.setDataNascimentoAssociado(associado.getDataNascimentoAssociado());
        associadoVal.setIsAssociado(associado.getIsAssociado());
        associadoVal.setIsPago(associado.getIsPago());
        associadoVal.setStatus(associado.getStatus());

        return associadoVal;
    }
}
