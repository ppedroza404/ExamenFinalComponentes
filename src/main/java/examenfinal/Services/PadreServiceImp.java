package examenfinal.Services;


import examenfinal.entities.Padre;
import examenfinal.repositories.PadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PadreServiceImp implements PadreService{

    @Autowired
    PadreRepository PadreRepo;

    @Override
    public List<Padre> getAll() {
        return PadreRepo.findAll();
    }

    @Override
    public Optional<Padre> findById(long id) {
        return PadreRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Padre> findContains(String nomOapel) {
        List<Padre> filteredList = new ArrayList<>();
        List<Padre> noFIltered = PadreRepo.findAll();

        for ( Padre item : noFIltered) {
            if(item.getNombre().toLowerCase().contains(nomOapel.toLowerCase()) || item.getApellido().toLowerCase().contains(nomOapel.toLowerCase())){
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    @Override
    public Optional<Padre> save(Padre padre) {
        return Optional.of(PadreRepo.save(padre));
    }

    @Override
    public Optional<Padre> update(Padre padre) {
        Optional<Padre> record = PadreRepo.findById(padre.getId());

        if (record.isPresent()) {
            Padre data = record.get();
            data.setTipo(padre.getTipo());
            data.setNombre(padre.getNombre());
            data.setApellido(padre.getApellido());
            data.setCedula(padre.getCedula());
            data.setDireccion(padre.getDireccion());
            data.setTelefonoP(padre.getTelefonoP());
            data.setTelefonoS(padre.getTelefonoS());
            //data.setHijo(padre.getHijo());
            return Optional.of(PadreRepo.save(data));
        }

        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Padre> result = PadreRepo.findById(id);
        if (result.isPresent()){
            PadreRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
