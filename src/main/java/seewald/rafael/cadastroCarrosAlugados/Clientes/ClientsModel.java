package seewald.rafael.cadastroCarrosAlugados.Clientes;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_clientes")
public class ClientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String idade;
    private String nationality;

    @OneToMany(mappedBy = "clientes")
    private List<ClientsModel> clientes;

    public ClientsModel(long id, String name, String email, String idade, String nationality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idade = idade;
        this.nationality = nationality;
    }

    public ClientsModel(long id) { this.id = id; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getIdade() { return idade; }

    public void setIdade(String idade) { this.idade = idade; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }
}
