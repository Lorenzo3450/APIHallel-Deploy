package br.api.hallel.service;

import br.api.hallel.model.Eventos;
import br.api.hallel.repository.EventosRepository;
import br.api.hallel.service.interfaces.EventosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventosService implements EventosInterface {

    @Autowired
    private EventosRepository repository;

    @Override
    public List<Eventos> listarAllEventos() {
        System.out.println("Listando Eventos...");
        return this.repository.findAll();
    }

    @Override
    public Eventos listarEventoById(String id) {
        Optional<Eventos> optional = this.repository.findById(id);

        if (optional.isPresent()) {
            Eventos eventos = optional.get();
            return eventos;
        } else {
            System.out.println("Evento não encontrado!");
            return null;
        }
    }

    @Override
    public Eventos listarEventosByNome(String nome) {
        Optional<Eventos> optional = this.repository.findByNome(nome);

        if (optional.isPresent()) {
            Eventos eventos = optional.get();
            return eventos;
        } else {
            System.out.println("Evento não encontrado!");
            return null;
        }

    }

    @Override
    public Eventos createEvento(Eventos evento) {
        return this.repository.insert(evento);
    }

    @Override
    public Eventos updateEventoById(String id) {

        Optional<Eventos> optional = this.repository.findById(id);

        if (optional.isPresent()) {
            Eventos eventos = optional.get();

            return this.repository.save(eventos);
        } else {
            System.out.println("Evento não encontrado!");
            return null;
        }

    }

    @Override
    public void deleteEventoById(String id) {
        Optional<Eventos> optional = this.repository.findById(id);

        if (optional.isPresent()) {
            Eventos eventos = optional.get();
            this.repository.deleteById(id);
        } else {
            System.out.println("Evento não encontrado!");
        }
    }


}
