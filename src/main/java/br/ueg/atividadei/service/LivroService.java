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
public interface LivroService {

    public Livro save(Livro livro);

    public List<Livro> list();

    public Optional<Livro> findById(Long id);

    public ResponseEntity<Livro> update(Long id, Livro livroAtualizado);

    public Livro delete(Long id);
}
