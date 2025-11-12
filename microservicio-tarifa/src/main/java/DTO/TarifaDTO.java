package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifaDTO {

    private int precioPorMinuto;
    private int precioPorKilometro;
    private int extraPorPausa;

}
