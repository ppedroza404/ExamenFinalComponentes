package examenfinal.Services;

import examenfinal.entities.Hijo;
import examenfinal.entities.Libro;
import examenfinal.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImp implements LibroService {

    @Autowired
    LibroRepository LibroRepo;


    @Override
    public List<Libro> getAll() {
        return LibroRepo.findAll();
    }

    @Override
    public Optional<Libro> findById(long id) {
        return LibroRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Libro> save(Libro libro) {
        return  Optional.of(LibroRepo.save(libro));
    }

    @Override
    public Libro findOne(String nombre) {
        List<Libro> listaLibros = LibroRepo.findAll();
        Libro libroEncontrado = new Libro();

        for (Libro l : listaLibros) {
            if(l.getNombre().contains(nombre)){
                libroEncontrado = l;
            }
        }
        return libroEncontrado;
    }
}
