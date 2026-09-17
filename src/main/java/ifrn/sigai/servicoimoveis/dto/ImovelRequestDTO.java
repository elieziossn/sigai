package ifrn.sigai.servicoimoveis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class ImovelRequestDTO {
    @NotBlank(message = "O endereço não pode ser nulo ou vazio.")
    private String endereco;
    
    @NonNull
    @Positive
    private Double valorAluguel;
    
    @Size(max = 500)
    private String descricao;
}
