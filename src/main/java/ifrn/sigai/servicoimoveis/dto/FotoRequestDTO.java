package ifrn.sigai.servicoimoveis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class FotoRequestDTO {
    @NotBlank(message = "O ID do imóvel não pode ser nulo ou vazio.")
    private Long imovelId;

    @NotBlank(message = "A URL da foto não pode ser nula ou vazia.")
    private String url;
    
    @Size(max = 200, message = "A legenda não pode ter mais de 200 caracteres.")
    private String legenda;
    private Boolean principal = false;
}
