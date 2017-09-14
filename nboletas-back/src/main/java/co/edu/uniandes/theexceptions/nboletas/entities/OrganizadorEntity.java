package co.edu.uniandes.theexceptions.nboletas.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class OrganizadorEntity extends BaseEntity implements Serializable
{
    
    private String nombreEmpresa;
            
    @OneToMany()
    private List<Espectaculo> espectaculos;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

