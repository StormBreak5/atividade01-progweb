package br.ueg.atividadei.service;

import br.ueg.atividadei.model.Livro;
import br.ueg.atividadei.repository.LivroRepository;
import org.springframework.stereotype.Service;

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

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
