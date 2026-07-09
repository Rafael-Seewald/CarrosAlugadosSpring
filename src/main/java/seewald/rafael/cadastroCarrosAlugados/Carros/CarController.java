package seewald.rafael.cadastroCarrosAlugados.Carros;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> listar() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car buscarPeloID(@PathVariable Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Car atualizar(@PathVariable Long id, RequestBody Car carro) {
        return 'teste';
    }

    @DeleteMapping("/{id}")
    public Car deletar(@PathVariable Long id) {
        return 'de';
    }

    @DeleteMapping
    public Car deletarTodos() {
        return 'detode';
    }

    @PostMapping
    public Car salvar(@RequestBody Car carro) {
        return carRepository.save(carro);
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }
}
