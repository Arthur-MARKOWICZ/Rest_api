package Api.Rest.api.rest.domain.Funcionario;

import Api.Rest.api.rest.domain.Cliente.Cliente;
import Api.Rest.api.rest.domain.Endereco.Endereco;

public record DadosDetalhamentoFuncionario(String nome, String telefone, String email, Endereco endereco) {
    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getNome(), funcionario.getTelefone(), funcionario.getEmail(), funcionario.getEndereco());
    }
}
