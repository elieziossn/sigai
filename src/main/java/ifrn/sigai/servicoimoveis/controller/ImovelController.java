package ifrn.sigai.servicoimoveis.controller;

import ifrn.sigai.servicoimoveis.exception.ImovelNaoEncontradoException;
import ifrn.sigai.servicoimoveis.model.Imovel;
import ifrn.sigai.servicoimoveis.repository.ImovelRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelRepository repository;

    public ImovelController(ImovelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Imovel> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Imovel buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));
    }

    @PostMapping
    //public Imovel criar(@RequestBody Imovel imovel) {
    //    return repository.save(imovel);
    //}
    public ResponseEntity<Imovel> criar(@RequestBody Imovel imovel) {
        Imovel imovelSalvo = repository.save(imovel);
        URI uri = URI.create("/imoveis/" + imovelSalvo.getId());
        return ResponseEntity.created(uri).body(imovelSalvo);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> atualizar(@PathVariable Long id, @RequestBody Imovel imovel) {
        Imovel imovelExistente = buscarPorId(id);
        
        System.out.println(imovel.toString());
        imovelExistente.setEndereco(imovel.getEndereco());
        imovelExistente.setValorAluguel(imovel.getValorAluguel());
        imovelExistente.setDescricao(imovel.getDescricao());

        return ResponseEntity.ok(repository.save(imovelExistente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Imovel imovelExistente = buscarPorId(id);
        repository.deleteById(imovelExistente.getId());
        return ResponseEntity.noContent().build();
    }
}