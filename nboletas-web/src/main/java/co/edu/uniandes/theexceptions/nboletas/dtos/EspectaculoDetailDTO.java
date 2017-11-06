/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.ArtistaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jf.ramos
 */
public class EspectaculoDetailDTO extends EspectaculoDTO {

    
    private List<ArtistaDTO> artistas;
    private List<OrganizadorDTO> organizadores;
    private List<ComentarioDTO> comentarios;
    
    /**
     * Constructor de un entity
     * @param espectaculo
     */
    public EspectaculoDetailDTO(EspectaculoEntity espectaculo) {
        
        super(espectaculo);
        this.artistas=new ArrayList<>();
        for(ArtistaEntity artista: espectaculo.getArtista()){
            artistas.add(new ArtistaDTO(artista));
        }
        this.organizadores=new ArrayList<>();
        for(OrganizadorEntity organizador: espectaculo.getOrganizador()){
            organizadores.add(new OrganizadorDTO(organizador));
        }
        this.comentarios=new ArrayList<>();
        for(ComentarioEntity comentario: espectaculo.getComentarios()){
            comentarios.add(new ComentarioDTO(comentario));
        }
    }

    /**
     * Constructor por defecto
     *
     */
    public EspectaculoDetailDTO() {
 
    }
    
    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * @return the id
     */
    public List<ArtistaDTO> getArtistas() {
        return artistas;
    }

    /**
     * @param lista the id to set
     */
    public void setArtistas(List<ArtistaDTO> lista) {
        this.artistas=lista;
    }
    
    public List<OrganizadorDTO> getOrganizadores() {
        return organizadores;
    }

    /**
     * @param organizadores the id to set
     */
    public void setOrganizadores(List<OrganizadorDTO> organizadores) {
        this.organizadores=organizadores;
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public EspectaculoEntity toEntity() {
        EspectaculoEntity espectaculoE = super.toEntity();
        return espectaculoE;
    }

    public List<EspectaculoDetailDTO> listEspectaculoEntity2EspectaculoDetailDTO(List<EspectaculoEntity> entityList) {
        List<EspectaculoDetailDTO> list = new ArrayList<>();
        for (EspectaculoEntity entity : entityList) {
            list.add(new EspectaculoDetailDTO(entity));
        }
        return list;
    }

    public List<EspectaculoEntity> listEspectaculoDetailDto2EspectaculoEntity(List<EspectaculoDetailDTO> entityList) {
        List<EspectaculoEntity> list = new ArrayList<>();
        for (EspectaculoDetailDTO entity : entityList) {
            list.add(entity.toEntity());
        }
        return list;
    }
}
