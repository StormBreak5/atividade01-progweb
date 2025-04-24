package br.ueg.atividadei.controller;

import br.ueg.atividadei.model.Livro;
import br.ueg.atividadei.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService livroService) {
        this.service = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity.ok(service.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return service.findById(id).map(livro -> {
            livroAtualizado.setId(livro.getId());
            return ResponseEntity.ok(service.save(livroAtualizado));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
