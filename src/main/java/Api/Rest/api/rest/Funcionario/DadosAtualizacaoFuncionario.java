package Api.Rest.api.rest.Funcionario;

import Api.Rest.api.rest.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFuncionario(
        @NotNull
        Long id,

        String nome,
        String telefone,

        String email,
        String cargaHoraria,
        DadosEndereco endereco
) {
}
