/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.FuncionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja.gomez1
 */
public class FuncionDetailDTO extends FuncionDTO {
    
    private List<BoletaDTO> boletas;
    
    private LugarDTO lugar;
    
    private EspectaculoDTO espectaculo;

    public FuncionDetailDTO() {
    }

    public FuncionDetailDTO(FuncionEntity entity) {
        super(entity);
        
        if(entity.getBoletas()!= null) {
            ArrayList<BoletaDTO> b = new ArrayList<>();
            for(BoletaEntity e : entity.getBoletas()) b.add(new BoletaDTO(e));
            this.boletas = b;
        }
        
        if(entity.getLugar() != null) {
            this.lugar = new LugarDTO(entity.getLugar());
        }
        
        if(entity.getEspectaculo()!= null) {
            this.espectaculo = new EspectaculoDTO(entity.getEspectaculo());
        }
    }
    
    @Override
    public FuncionEntity toEntity() {
        FuncionEntity f = super.toEntity();
        return f;
    }
}
