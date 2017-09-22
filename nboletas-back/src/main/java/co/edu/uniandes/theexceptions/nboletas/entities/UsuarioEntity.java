/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jm.contreras10
 */
@Entity
public class UsuarioEntity extends BaseEntity implements Serializable {
    
    /**
     * User-Name del usuario.
     */
    private String userName;
    
    /**
     * Contraseña del usuario.
     */
    private String password;
    
    /**
     * Nombre completo del usuario.
     */
    private String nombreUsuario;
            
    /**
     * E-mail del usuario.
     */
    private String email;
    
    /**
     * Pais del usuario.
     */
    private String pais;
    
    /**
     * ciudad del usuario.
     */
    private String ciudad;
    
    @PodamExclude
    @OneToMany(mappedBy = "usuario")
    private List<BoletaEntity> boletas;
    
    @PodamExclude
    @OneToMany(mappedBy = "usuario")
    private List<ReembolsoEntity> reembolsos;

    public List<BoletaEntity> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<BoletaEntity> boletas) {
        this.boletas = boletas;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<ReembolsoEntity> getReembolsos() {
        return reembolsos;
    }

    public void setReembolsos(List<ReembolsoEntity> reembolsos) {
        this.reembolsos = reembolsos;
    }
    
    
    
}
