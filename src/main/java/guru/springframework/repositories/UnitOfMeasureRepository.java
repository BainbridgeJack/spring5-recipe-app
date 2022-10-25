package guru.springframework.repositories;

import guru.springframework.model.Category;
import guru.springframework.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByUnitOfMeasure(String unitOfMeasure);
}
