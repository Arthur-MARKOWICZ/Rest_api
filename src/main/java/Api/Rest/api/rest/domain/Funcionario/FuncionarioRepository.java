package Api.Rest.api.rest.domain.Funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario ,Long> {
    Page<Funcionario> findAllByAtivoTrue(Pageable paginacao);
}
