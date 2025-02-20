package Api.Rest.api.rest.Controller;


import Api.Rest.api.rest.Cliente.Cliente;
import Api.Rest.api.rest.Cliente.ClienteRepository;
import Api.Rest.api.rest.Cliente.DadosAtualizacaoCliente;
import Api.Rest.api.rest.Cliente.DadosCadastroCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados){
        clienteRepository.save(new Cliente(dados));
    }
    @PutMapping
    @Transactional
    public  void atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.excluir();

    }
}
