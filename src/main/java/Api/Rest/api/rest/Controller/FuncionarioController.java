package Api.Rest.api.rest.Controller;

import Api.Rest.api.rest.domain.Funcionario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriComponentsBuilder){
        var funcionario = new Funcionario(dados);
        funcionarioRepository.save(funcionario);
        var uri = uriComponentsBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }
    @PutMapping
    @Transactional
    public  ResponseEntity atualizarFuncionario(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
        var funcionario = funcionarioRepository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemFuncionarios>>listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = funcionarioRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFuncionarios::new);

        return ResponseEntity.ok(page);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.excluir();
        return ResponseEntity.noContent().build();
    }
}
