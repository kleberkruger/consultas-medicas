package br.ufms.clinicamedica.view;

import br.ufms.clinicamedica.OLD.controller.ClinicaMedica;
import br.ufms.clinicamedica.model.Paciente;

import java.util.Map;

public class PacienteApp {

    private final ClinicaMedica clinica;

    public PacienteApp(ClinicaMedica clinica) {
        this.clinica = clinica;
    }

    public void iniciar(Paciente paciente) {
        menuPrincipal();
    }

    private void menuPrincipal() {
        while (true) {
            int opcao = Menu.exibir("MENU PRINCIPAL", Map.of(
                    1, "Solicitar Consulta",
                    2, "Confirmar Agendamento",
                    3, "Listar Consultas Agendadas",
                    4, "Histórico de Consultas",
                    9, "Meu Perfil",
                    0, "Sair"
            ));
            switch (opcao) {
                case 1 -> menuSolicitarConsulta();
                case 2 -> menuConfirmarAgendamento();
                case 3 -> menuListarConsultasAgendadas();
                case 4 -> menuHistoricoConsultas();
                case 9 -> menuMeuPerfil();
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void menuSolicitarConsulta() {
        System.out.println("Solicitar Consulta");
    }

    private void menuConfirmarAgendamento() {
        System.out.println("Confirmar Agendamento");
    }

    private void menuListarConsultasAgendadas() {
        System.out.println("Listar Consultas Agendadas");
    }

    private void menuHistoricoConsultas() {
        System.out.println("Histórico de Consultas");
    }

    private void menuMeuPerfil() {
        System.out.println("Meu Perfil");
    }
}
