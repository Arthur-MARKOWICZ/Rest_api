package Api.Rest.api.rest.Funcionario;

import Api.Rest.api.rest.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosListagemFuncionarios(Long id,String nome, String telefone, String email,
                                        String cargaHoraria) {
    public DadosListagemFuncionarios(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getTelefone(), funcionario.getEmail(),
                funcionario.getCargaHoraria());
    }
}
