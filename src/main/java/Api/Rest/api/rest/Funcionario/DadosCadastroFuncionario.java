package Api.Rest.api.rest.Funcionario;

import Api.Rest.api.rest.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroFuncionario(
        @NotBlank
        String nome,
        String telefone,
        @Email
        String email,
        @Pattern(regexp = "^\\d{11}$")
        String cpf,
        @NotNull @Valid
        DadosEndereco endereco,
        @NotNull
        String cargaHoraria
) {
}
