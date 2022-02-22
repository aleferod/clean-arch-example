package adapter.data.repository;

import adapter.data.dto.EmpresaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmpresaRepository extends CrudRepository<EmpresaEntity, Long> {

    Optional<EmpresaEntity> findByCnpj(String cnpj);

}
