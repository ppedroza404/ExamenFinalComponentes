package examenfinal.controllers;

import examenfinal.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/libros"})

public class LibroController {

    @Autowired
    private LibroService libroService;

    // Get all
    @GetMapping
    public List getAll(){
        return libroService.getAll();
    }
}
