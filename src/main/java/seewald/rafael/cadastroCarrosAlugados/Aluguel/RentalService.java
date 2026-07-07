package seewald.rafael.cadastroCarrosAlugados.Aluguel;

import org.springframework.stereotype.Service;
import seewald.rafael.cadastroCarrosAlugados.Carros.Car;
import seewald.rafael.cadastroCarrosAlugados.Carros.CarRepository;
import seewald.rafael.cadastroCarrosAlugados.Clientes.Client;
import seewald.rafael.cadastroCarrosAlugados.Clientes.ClientRepository;

@Service
public class RentalService {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final RentalRepository rentalRepository;

    public RentalService(CarRepository carRepository,
                         ClientRepository clientRepository,
                         RentalRepository rentalRepository){
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.rentalRepository = rentalRepository;
    }

    public Rental alugar(Long clienteId, Long carroId) {

        Client cliente = clientRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Car carro = carRepository.findById(carroId)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        if (!carro.isAvailable()) {
            throw new RuntimeException("Carro indisponível");
        }

        Rental aluguel = new Rental();

        aluguel.setClient(cliente);
        aluguel.setCar(carro);
        aluguel.setAluguel(aluguel);

        carro.setAvailable(false);

        carRepository.save(carro);

        return rentalRepository.save(aluguel);
    }
}
