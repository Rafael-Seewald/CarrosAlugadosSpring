package seewald.rafael.cadastroCarrosAlugados.Aluguel;

import jakarta.persistence.*;
import seewald.rafael.cadastroCarrosAlugados.Carros.Car;
import seewald.rafael.cadastroCarrosAlugados.Clientes.Client;

import java.time.LocalDate;

@Entity
@Table(name = "tb_alugueis")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private double value;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Car carro;

    public Rental() {
    }

    public Rental(Long id, LocalDate startDate, LocalDate endDate,
                  Client cliente, Car carro){
        this.carro = carro;
        this.cliente = cliente;
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public void setClient(Client cliente){
        this.cliente = cliente;
    }

    public void setCar(Car carro) {
        this.carro = carro;
    }

    public void setAluguel(Rental aluguel) {
    }
}