package ifrn.sigai.servicoimoveis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ifrn.sigai.servicoimoveis.dto.FotoRequestDTO;
import ifrn.sigai.servicoimoveis.dto.FotoResponseDTO;
import ifrn.sigai.servicoimoveis.model.Foto;
import ifrn.sigai.servicoimoveis.repository.FotoRepository;

@Service 
public class FotoService {

    private final FotoRepository repository;
    public FotoService(FotoRepository repository) {
        this.repository = repository;
    }
    public FotoResponseDTO criar(FotoRequestDTO dto) {
        Foto salvo = repository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }
    public FotoResponseDTO buscarPorId(Long id) {
        Foto foto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Foto não encontrada com id: " + id));
        return toResponseDTO(foto);
    }
    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto) {
        Foto foto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foto não encontrada com id: " + id));

        Foto fotoAtualizada = toEntity(dto);
        fotoAtualizada.setId(id);
        fotoAtualizada = repository.save(fotoAtualizada); 

        return toResponseDTO(fotoAtualizada);
    }
    public void deletar(Long id) {
        Foto foto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foto não encontrada com id: " + id));
        repository.deleteById(id);
    }
    public List<FotoResponseDTO> listar() {
        List<Foto> fotos = repository.findAll();
        return fotos.stream()
                .map(this::toResponseDTO)
                .toList();
    }


    private Foto toEntity(FotoRequestDTO dto) {
        return new Foto(null, dto.getImovelId(), dto.getUrl(), dto.getLegenda(), dto.getPrincipal());
    }
    private FotoResponseDTO toResponseDTO(Foto foto) {
        return new FotoResponseDTO(foto.getId(), foto.getImovelId(), foto.getUrl(), foto.getLegenda(), foto.getPrincipal());
    }
}
