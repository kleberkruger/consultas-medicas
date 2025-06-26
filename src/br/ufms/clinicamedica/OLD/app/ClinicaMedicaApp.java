package br.ufms.clinicamedica.OLD.app;

import br.ufms.clinicamedica.OLD.controller.ClinicaMedica;
import br.ufms.clinicamedica.view.Menu;
import br.ufms.clinicamedica.view.SecretarioApp;
import br.ufms.clinicamedica.model.Medico;
import br.ufms.clinicamedica.model.Paciente;
import br.ufms.clinicamedica.model.Secretario;

import java.time.LocalDate;
import java.util.Map;

public class ClinicaMedicaApp {

    private final Secretario secretario = new Secretario(
            "Jacinto Pinto",
            "12345678909",
            null,
            "6732910201",
            LocalDate.of(1991, 5, 6),
            LocalDate.now(),
            3000
    );

    private final Medico medico = new Medico(
            "Paula Tejano",
            "98765432100",
            "123456MS",
            null,
            "6732910202",
            LocalDate.of(1980, 2, 15)
    );

    private final Paciente paciente = new Paciente(
            "Angelo Darcy Molin",
            "11144477735",
            null,
            "67999999999",
            LocalDate.of(1986, 8, 17)
    );

    private final ClinicaMedica clinica;

    public ClinicaMedicaApp(ClinicaMedica clinica) {
        this.clinica = clinica;
    }

    public void iniciar() {
        menuBoasVindas();
    }

    private void menuBoasVindas() {
        while (true) {
            int opc = Menu.exibir("BEM-VINDO AO SISTEMA", Map.of(
                    1, "Fazer Login",
                    2, "Criar Conta",
                    0, "Sair"
            ));
            switch (opc) {
                case 1 -> menuLogin();
                case 2 -> menuCriarConta();
                case 0 -> System.exit(0);
            }
        }
    }

    private void menuLogin() {
//        new PacienteApp(clinica).iniciar(paciente);
        new SecretarioApp(clinica).iniciar(secretario);
//        new MedicoApp(clinica).iniciar(medico);
    }

    private void menuCriarConta() {
        System.out.println("Criar Conta");
    }

    public static void main(String[] args) {
        var clinica = new ClinicaMedica("Clínica Universitária UFMS", "15.126.437/0018-91");
        new ClinicaMedicaApp(clinica).iniciar();
    }
}
