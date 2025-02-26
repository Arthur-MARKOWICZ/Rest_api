package Api.Rest.api.rest.domain.Cliente;

import Api.Rest.api.rest.domain.Endereco.Endereco;


public record DadosDetalhamentoCliente(String nome, String telefone, String email, Endereco endereco) {
    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getTelefone(), cliente.getEmail(), cliente.getEndereco());
    }
}
