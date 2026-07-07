package seewald.rafael.cadastroCarrosAlugados.Carros;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> listar() {
        return repository.findAll();
    }

    public Car salvar(Car carro) {
        return repository.save(carro);
    }
}
