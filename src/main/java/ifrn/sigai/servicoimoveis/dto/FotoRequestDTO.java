package ifrn.sigai.servicoimoveis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class FotoRequestDTO {
    private Long imovelId;
    private String url;
    private String legenda;
    private Boolean principal;
}
