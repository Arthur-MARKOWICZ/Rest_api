package Api.Rest.api.rest.domain.Funcionario;

import Api.Rest.api.rest.domain.Endereco.DadosEndereco;
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
