package projeto.spring.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo; // código interno

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private long cpf;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;
    
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    // Conta tem apenas um titular
    // Titular pode ter vários tipos de contains
    @OneToMany(mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    public List<Conta> contas;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
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

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    
}
