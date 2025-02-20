package Api.Rest.api.rest.Cliente;

import Api.Rest.api.rest.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
