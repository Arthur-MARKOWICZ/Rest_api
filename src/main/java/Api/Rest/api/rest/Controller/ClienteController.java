package Api.Rest.api.rest.Controller;


import Api.Rest.api.rest.domain.Cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriComponentsBuilder){
        var cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        var uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.excluir();
        return ResponseEntity.noContent().build();

    }
}
