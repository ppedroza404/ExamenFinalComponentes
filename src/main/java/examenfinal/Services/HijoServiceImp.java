package examenfinal.Services;

import examenfinal.entities.Hijo;
import examenfinal.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HijoServiceImp implements HijoService{

    @Autowired
    HijoRepository HijoRepo;


    @Override
    public List<Hijo> getAll() {
        return HijoRepo.findAll();
    }

    @Override
    public Optional<Hijo> findById(long id) {
        return HijoRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Hijo> save(Hijo hijo) {
        return Optional.of(HijoRepo.save(hijo));
    }

    @Override
    public Optional<Hijo> update(Hijo hijo) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
