package examenfinal.Services;

import examenfinal.entities.Hijo;
import examenfinal.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    public List<Libro> getAll();
    public Optional<Libro> findById(long id);
    public Optional<Libro> save(Libro libro);
    public Libro findOne(String nombre);
}
