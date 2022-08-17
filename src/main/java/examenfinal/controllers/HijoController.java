package examenfinal.controllers;

import examenfinal.Services.HijoService;
import examenfinal.Services.LibroService;
import examenfinal.entities.Hijo;;
import examenfinal.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/hijos"})
public class HijoController {

    @Autowired
    private HijoService hijoService;

    @Autowired
    private LibroService libroService;


    // Get all
    @GetMapping
    public List getAll(){
        return hijoService.getAll();
    }

    // Save Padre
    @PostMapping
    public Hijo create(@RequestBody Hijo hijo){
        return hijoService.save(hijo).get();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Hijo> findById(@PathVariable long id){
        Optional<Hijo> result = hijoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Agregar libro a hijo
    @PostMapping("/leer/{hijoID}")
    public Hijo LeerLibro(
            @PathVariable Long hijoID,
            @RequestBody Libro libro
    ){
        Hijo hijo = hijoService.findById(hijoID).get();

        hijo.leerLibro(libroService.save(libro).get());
        return hijoService.save(hijo).get();
    }

}
