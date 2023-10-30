package br.api.hallel.moduloAPI.repository;

import br.api.hallel.moduloAPI.model.Retiro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiroRepository extends MongoRepository<Retiro,String> {
}
