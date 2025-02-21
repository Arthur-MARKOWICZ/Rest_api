package Api.Rest.api.rest.Funcionario;

import Api.Rest.api.rest.Cliente.DadosAtualizacaoCliente;
import Api.Rest.api.rest.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;

@Table(name = "funcionario")
@Entity(name = "funcionario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "of")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String cargaHoraria;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;
    public Funcionario(DadosCadastroFuncionario dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.cargaHoraria = dados.cargaHoraria();
        this.endereco = new Endereco(dados.endereco());
    }
    public void atualizarInformacoes(DadosAtualizacaoFuncionario dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.cargaHoraria() != null){
            this.cargaHoraria = dados.cargaHoraria();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
    public void excluir(){
        this.ativo = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
