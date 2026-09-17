package ifrn.sigai.servicoimoveis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ImovelResponseDTO {
    private Long id;
    private String endereco;
    private Double valorAluguel;
}
