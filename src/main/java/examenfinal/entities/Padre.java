package examenfinal.entities;




import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Padre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "p_id")
    private Long id;
    private String tipo;
    private String nombre;
    private String apellido;
    private String Cedula;
    private String Direccion;
    private String telefonoP;
    private String telefonoS;

    @ManyToMany
    @JoinTable(
            name = "Padre_Hijo",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "h_id")
    )
    private Set<Hijo> HijosList = new HashSet<>();


    public Padre(Long id, String tipo, String nombre, String apellido, String cedula, String direccion, String telefonoP, String telefonoS, Set<Hijo> hijosList) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        Cedula = cedula;
        Direccion = direccion;
        this.telefonoP = telefonoP;
        this.telefonoS = telefonoS;
        HijosList = hijosList;
    }

    public Padre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public String getTelefonoS() {
        return telefonoS;
    }

    public void setTelefonoS(String telefonoS) {
        this.telefonoS = telefonoS;
    }


    public Set<Hijo> getHijosList() {
        return HijosList;
    }

    public void setHijosList(Set<Hijo> hijosList) {
        HijosList = hijosList;
    }

    public void agregarHijo(Hijo h){
        HijosList.add(h);
    }
}
