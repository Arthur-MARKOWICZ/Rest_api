package Api.Rest.api.rest.Controller;

import Api.Rest.api.rest.Cliente.Cliente;
import Api.Rest.api.rest.Cliente.ClienteRepository;
import Api.Rest.api.rest.Cliente.DadosAtualizacaoCliente;
import Api.Rest.api.rest.Cliente.DadosCadastroCliente;
import Api.Rest.api.rest.Funcionario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroFuncionario dados){
        funcionarioRepository.save(new Funcionario(dados));
    }
    @PutMapping
    @Transactional
    public  void atualizarCliente(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
        var funcionario = funcionarioRepository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);
    }
    @GetMapping
    public Page<DadosListagemFuncionarios>listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return funcionarioRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFuncionarios::new);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.excluir();

    }
}
