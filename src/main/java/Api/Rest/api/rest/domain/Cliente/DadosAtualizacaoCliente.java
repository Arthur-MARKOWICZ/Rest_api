package Api.Rest.api.rest.domain.Cliente;

import Api.Rest.api.rest.domain.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        Long id,

        String nome,
        String telefone,

        String email,
        DadosEndereco endereco
) {
}
