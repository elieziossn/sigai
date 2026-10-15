package ifrn.sigai.servicoimoveis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data 
@NoArgsConstructor 
public class ImovelRequestDTO {

    public ImovelRequestDTO(String endereco, Double valorAluguel, String descricao) {
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.descricao = descricao;
    }
    
    @NotBlank(message = "O endereço não pode ser nulo ou vazio.")
    private String endereco;
    
    @NonNull
    @Positive
    private Double valorAluguel;
    
    @Size(max = 500)
    private String descricao;
}
