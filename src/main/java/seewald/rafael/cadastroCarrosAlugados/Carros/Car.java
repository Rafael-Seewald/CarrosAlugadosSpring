package seewald.rafael.cadastroCarrosAlugados.Carros;

import jakarta.persistence.*;

@Entity
@Table(name="tb_carros")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int year;
    private boolean available;
    private String color;
    private String plate;

    public Car() {
    }

    public Car(String model, int year, boolean available, String color, String plate, String manufacture) {
        this.model = model;
        this.year = year;
        this.available = available;
        this.color = color;
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() { return available; }

    public String getColor() {
        return color;
    }

    public String getPlate() {
        return plate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
