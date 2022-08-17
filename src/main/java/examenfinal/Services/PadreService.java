package examenfinal.Services;

import examenfinal.entities.Padre;

import java.util.List;
import java.util.Optional;

public interface PadreService {
    public List<Padre> getAll(); // *
    public Optional<Padre> findById(long id); // ** padre y sus hijos
    public List<Padre> findContains(String nomOapel); // *
    public Optional<Padre> save(Padre padre); // *
    public  Optional<Padre> update(Padre padre); // *
    public boolean delete(Long id); // *
}
