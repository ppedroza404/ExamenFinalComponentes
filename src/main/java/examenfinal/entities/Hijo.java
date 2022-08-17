package examenfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "h_id")
    private Long id;
    private String nombre;
    private String apellido;
    private String plan;
    private String alergias;

    @ManyToMany
    @JoinTable(
            name = "Hijos_Libro",
            joinColumns = @JoinColumn(name = "h_id"),
            inverseJoinColumns = @JoinColumn(name = "l_id")
    )
    private Set<Libro> librosList= new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "HijosList")
    private Set<Padre> padres = new HashSet<>();

    public Hijo() {
    }

    public Hijo(Long id, String nombre, String apellido, String plan, String alergias, Set<Libro> librosList, Set<Padre> padres) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.plan = plan;
        this.alergias = alergias;
        this.librosList = librosList;
        this.padres = padres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Set<Libro> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(Set<Libro> librosList) {
        this.librosList = librosList;
    }

    public Set<Padre> getPadres() {
        return padres;
    }

    public void setPadres(Set<Padre> padres) {
        this.padres = padres;
    }

    public void leerLibro(Libro l){

        librosList.add(l);
    }


}
