package Api.Rest.api.rest.domain.Funcionario;

public record DadosListagemFuncionarios(Long id,String nome, String telefone, String email,
                                        String cargaHoraria) {
    public DadosListagemFuncionarios(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getTelefone(), funcionario.getEmail(),
                funcionario.getCargaHoraria());
    }
}
