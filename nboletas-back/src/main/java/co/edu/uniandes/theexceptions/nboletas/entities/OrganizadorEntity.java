package co.edu.uniandes.theexceptions.nboletas.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;


@Entity
public class OrganizadorEntity extends BaseEntity implements Serializable
{
    
    private String nombreEmpresa;
    
    @PodamExclude
    @ManyToMany(mappedBy = "organizador")
    private List<EspectaculoEntity> espectaculos;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

