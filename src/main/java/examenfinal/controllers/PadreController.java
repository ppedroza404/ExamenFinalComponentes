package examenfinal.controllers;

import examenfinal.Services.HijoService;
import examenfinal.Services.PadreService;
import examenfinal.entities.Hijo;
import examenfinal.entities.Padre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/padres"})
public class PadreController {
    @Autowired
    private PadreService padreService;

    @Autowired
    private HijoService hijoService;

    // Get all
    @GetMapping
    public List getAll(){
        return padreService.getAll();
    }

    // Get by ID
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Padre> findById(@PathVariable long id){
        Optional<Padre> result = padreService.findById(id);
        if (result.isPresent()){

            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Save Padre
    @PostMapping
    public Padre create(@RequestBody Padre padre){
        return padreService.save(padre).get();
    }

    // Delete Padre
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (padreService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update Padre
    @PutMapping(value="/{id}")
    public ResponseEntity<Padre> update(@PathVariable("id") long id,@RequestBody Padre padre){
        padre.setId(id);
        Optional<Padre> result = padreService.update(padre);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // find Contains
    @GetMapping(value="/buscar")
    public List findContains(@RequestParam(name = "buscar") String keyword){
        return padreService.findContains(keyword);
    }

    // agregar hijo a padre
    @PutMapping("/asignar/{padreId}/de/{hijoID}")
    public Padre asignarHijo(
            @PathVariable Long padreId,
            @PathVariable Long hijoID
    ){
        Padre padre = padreService.findById(padreId).get();
        Hijo hijo = hijoService.findById(hijoID).get();
        padre.agregarHijo(hijo);
        return padreService.save(padre).get();
    }
}
