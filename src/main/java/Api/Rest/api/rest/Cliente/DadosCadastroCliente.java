package Api.Rest.api.rest.Cliente;

import Api.Rest.api.rest.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        String telefone,
        @Email
        String email,
        @NotNull @Valid
        DadosEndereco endereco
) {
}
