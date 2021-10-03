package projeto.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name="tb_conta")
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero;

    @Column(nullable = false)
    private int agencia;

    @Column(nullable = false)
    private int contaTipo; // 0 - conta corrente, 1 - poupança, 2 - investimento

    @Column(nullable = false)
    private double saldo;
   
    @ManyToOne
    @JoinColumn(name = "cliente")
    @JsonIgnoreProperties("conta")
    private Cliente cliente;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getContatipo() {
        return contaTipo;
    }

    public void setContaTipo(int contaTipo) {
        this.contaTipo = contaTipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }   
}
