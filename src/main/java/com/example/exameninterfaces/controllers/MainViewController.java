package com.example.exameninterfaces.controllers;


import com.example.exameninterfaces.App;
import com.example.exameninterfaces.entities.Cliente;
import com.example.exameninterfaces.entities.Coche;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {


    @javafx.fxml.FXML
    private TextField txtMatricula;
    @javafx.fxml.FXML
    private ComboBox<String> comboModelo;
    @javafx.fxml.FXML
    private ComboBox<Cliente> comboCliente;
    @javafx.fxml.FXML
    private RadioButton radioStandard;
    @javafx.fxml.FXML
    private ToggleGroup tarifa;
    @javafx.fxml.FXML
    private RadioButton radioOferta;
    @javafx.fxml.FXML
    private RadioButton radioLarga;
    @javafx.fxml.FXML
    private DatePicker dateEntrada;
    @javafx.fxml.FXML
    private Label labelCoste;
    @javafx.fxml.FXML
    private Button btnAdd;
    @javafx.fxml.FXML
    private Button btnSalir;
    @javafx.fxml.FXML
    private TableView<Coche> table;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cMatricula;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cModelo;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cFechaSalida;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cFechaEntrada;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cCliente;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cTarifa;
    @javafx.fxml.FXML
    private TableColumn<Coche, String> cCoste;
    @javafx.fxml.FXML
    private DatePicker dateSalida;
    @javafx.fxml.FXML
    private Label enlace;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateEntrada.setValue(LocalDate.now());
        dateSalida.setValue(LocalDate.now().plusDays(1));

        comboCliente.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente.getNombre();
            }

            @Override
            public Cliente fromString(String s) {
                return null;
            }
        });
        Cliente cliente1 = new Cliente(1, "Juan Pérez", "juan@email.com");
        Cliente cliente2 = new Cliente(2, "María González", "maria@email.com");
        Cliente cliente3 = new Cliente(3, "Carlos Ramírez", "carlos@email.com");
        Cliente cliente4 = new Cliente(4, "Laura Rodríguez", "laura@email.com");
        Cliente cliente5 = new Cliente(5, "Pedro Sánchez", "pedro@email.com");
        comboCliente.getItems().setAll(cliente1, cliente2, cliente3, cliente4, cliente5);
        comboCliente.getSelectionModel().selectFirst();

        comboModelo.getItems().addAll("Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Mazda", "Hyundai", "Kia", "Subaru", "Mercedes-Benz");
        comboModelo.getSelectionModel().selectFirst();

        Coche coche1 = new Coche("ABC123", "Toyota", 8, LocalDate.now(), LocalDate.now().plusDays(7), 350, cliente1);
        Coche coche2 = new Coche("DEF456", "Honda", 2, LocalDate.now(), LocalDate.now().plusDays(5), 200, cliente2);
        Coche coche3 = new Coche("GHI789", "Ford", 6, LocalDate.now(), LocalDate.now().plusDays(10), 600, cliente3);
        Coche coche4 = new Coche("JKL012", "Chevrolet", 2, LocalDate.now(), LocalDate.now().plusDays(3), 135, cliente4);
        Coche coche5 = new Coche("MNO345", "Nissan", 8, LocalDate.now(), LocalDate.now().plusDays(8), 440, cliente5);
        Coche coche6 = new Coche("PQR678", "Mazda", 8, LocalDate.now(), LocalDate.now().plusDays(6), 288, cliente1);
        Coche coche7 = new Coche("STU901", "Hyundai", 2, LocalDate.now(), LocalDate.now().plusDays(12), 780, cliente1);
        Coche coche8 = new Coche("VWX234", "Kia", 6, LocalDate.now(), LocalDate.now().plusDays(4), 168, cliente3);
        Coche coche9 = new Coche("YZA567", "Subaru", 6, LocalDate.now(), LocalDate.now().plusDays(9), 522, cliente5);
        Coche coche10 = new Coche("BCD890", "Mercedes-Benz", 8, LocalDate.now(), LocalDate.now().plusDays(15), 1050, cliente4);

        ObservableList<Coche> lista = table.getItems();
        lista.addAll(coche1, coche2, coche3, coche4, coche5, coche6, coche7, coche8, coche9, coche10);

        cMatricula.setCellValueFactory((fila) -> {
            String matricula = fila.getValue().getMatricula();
            return new SimpleStringProperty(matricula);
        });


        cFechaEntrada.setCellValueFactory((fila) -> {
            String entrada = fila.getValue().getFechaEntrada().toString();
            return new SimpleStringProperty(entrada);
        });

        cFechaSalida.setCellValueFactory((fila) -> {
            String salida = fila.getValue().getFechaSalida().toString();
            return new SimpleStringProperty(salida);
        });

        cModelo.setCellValueFactory((fila) -> {
            String modelo = fila.getValue().getModelo();
            return new SimpleStringProperty(modelo);
        });

        cCliente.setCellValueFactory((fila) -> {
            String cliente = fila.getValue().getCliente().getNombre();
            return new SimpleStringProperty(cliente);
        });

        cTarifa.setCellValueFactory((fila) -> {
            String tarifa = tarifaToString(fila.getValue().getTarifa());
            return new SimpleStringProperty(tarifa);
        });

        cCoste.setCellValueFactory((fila) -> {
            String coste = fila.getValue().getCosteTotal() + "€";
            return new SimpleStringProperty(coste);
        });

        dateEntrada.valueProperty().addListener((observable, newValue, oldValue) -> {
            labelCoste.setText(calcularCoste() + "€");
        });

        dateSalida.valueProperty().addListener((observable, newValue, oldValue) -> {
            labelCoste.setText(calcularCoste() + "€");
        });

        tarifa.selectedToggleProperty().addListener((observable,newValue,oldValue)->{
            labelCoste.setText(calcularCoste() + "€");
        });
    }

    @javafx.fxml.FXML
    public void alert(Event event) {
        App.makeNewAlert(Alert.AlertType.INFORMATION,
                "Información del alumno",
                "Gabriel Rincón López",
                "Ciclo: 2ºDAM").showAndWait();
    }

    @javafx.fxml.FXML
    public void appOut(ActionEvent actionEvent) {
        Alert alert = App.makeNewAlert(Alert.AlertType.CONFIRMATION,
                "Confirmación",
                "¿Estas seguro de que quieres salir?",
                "Presiona aceptar para salir");
        alert.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait().ifPresent((response) -> {
            if (response == ButtonType.OK) Platform.exit();


        });
    }

    private boolean checkCampos() {
        boolean out = true;
        if (txtMatricula.getText() == null || Objects.equals(txtMatricula.getText(), "")) {
            out = false;
            App.makeNewAlert(Alert.AlertType.INFORMATION,
                    "Error al añadir",
                    "Rellena el campo de matricula",
                    "Pulsa aceptar para volver al formulario").showAndWait();
        }

        if (dateSalida.getValue() == null || dateEntrada == null) {
            out = false;
            App.makeNewAlert(Alert.AlertType.INFORMATION,
                    "Error al añadir",
                    "Rellena los campos de fecha",
                    "Pulsa aceptar para volver al formulario").showAndWait();
        }

        return out;
    }

    private String tarifaToString(Integer value) {
        String out = null;
        switch (value) {
            case 8:
                out = "Standard";
                break;
            case 6:
                out = "Oferta";
                break;
            case 2:
                out = "Larga";
                break;
            default:
                break;
        }
        return out;
    }
    private String tarifaToInteger() {
        String out = null;
        switch (value) {
            case 8:
                out = "Standard";
                break;
            case 6:
                out = "Oferta";
                break;
            case 2:
                out = "Larga";
                break;
            default:
                break;
        }
        return out;
    }


    @javafx.fxml.FXML
    public void addCoche(ActionEvent actionEvent) {
        if (checkCampos()) {
            Coche c = new Coche();
            if (tarifa.selectedToggleProperty().getValue().equals(radioLarga)) {
                c.setTarifa(2);
            } else if (tarifa.selectedToggleProperty().getValue().equals(radioOferta)) {
                c.setTarifa(6);
            } else {
                c.setTarifa(8);
            }
            c.setCliente(comboCliente.getValue());
            c.setMatricula(txtMatricula.getText());
            c.setFechaEntrada(dateEntrada.getValue());
            c.setFechaSalida(dateSalida.getValue());
            c.setModelo(comboModelo.getValue());
            c.setCosteTotal(Integer.valueOf(labelCoste.getText().substring(0, labelCoste.getText().length() - 1)));
            table.getItems().add(c);
            table.refresh();
        }
    }

    private Integer calcularCoste() {
        Integer out = null;
        long dias = ChronoUnit.DAYS.between(dateEntrada.getValue(), dateSalida.getValue());
        if(dias<=0){
            App.makeNewAlert(Alert.AlertType.INFORMATION,
                    "Error al añadir",
                    "Diferencia de fechas no válida",
                    "Pulsa aceptar para volver al formulario").showAndWait();
        }else{
            out = dias*
        }
        return out;
    }
}