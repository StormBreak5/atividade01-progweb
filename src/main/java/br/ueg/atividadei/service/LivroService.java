package br.ueg.atividadei.service;

import br.ueg.atividadei.model.Livro;
import br.ueg.atividadei.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro save(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> list() {
        return repository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return repository.findById(id);
    }

    public ResponseEntity<Livro> update(Long id, Livro livroAtualizado) {
        return findById(id).map(livro -> {
            livroAtualizado.setId(livro.getId());
            return ResponseEntity.ok(save(livroAtualizado));
        }).orElse(ResponseEntity.notFound().build());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
