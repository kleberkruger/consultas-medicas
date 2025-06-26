package br.ufms.clinicamedica.view;

import br.ufms.clinicamedica.OLD.controller.ClinicaMedica;
import br.ufms.clinicamedica.model.Secretario;

import java.util.Map;

public class SecretarioApp {

    private final ClinicaMedica clinica;

    public SecretarioApp(ClinicaMedica clinica) {
        this.clinica = clinica;
    }

    public void iniciar(Secretario secretario) {
        menuPrincipal();
    }

    private void menuPrincipal() {
        int opcao = Menu.exibir("MENU PRINCIPAL", Map.of(
                1, "Consultas",
                2, "Pacientes",
                3, "Médicos",
                9, "Meu Perfil",
                0, "Sair"
        ));
        switch (opcao) {
            case 1 -> menuConsultasSecretario();
            case 2 -> menuPacientes();
            case 3 -> menuMedicos();
            case 4 -> menuMeuPerfil();
        }
    }

    private void menuConsultasSecretario() {
        int opcao = Menu.exibir("MENU DE CONSULTAS", Map.of(
                1, "Solicitações",
                2, "Agendamentos",
                3, "Histórico de Consultas",
                0, "Voltar"
        ));
    }

    private void menuPacientes() {
        int opcao = Menu.exibir("MENU DE PACIENTES", Map.of(
                1, "Novo",
                2, "Editar",
                3, "Excluir",
                4, "Listar",
                0, "Voltar"
        ));
    }

    private void menuMedicos() {
        int opcao = Menu.exibir("MENU DE MÉDICOS", Map.of(
                1, "Novo",
                2, "Editar",
                3, "Excluir",
                4, "Listar",
                0, "Voltar"
        ));
    }

    private void menuAgendamentos() {
        int opcao = Menu.exibir("MENU DE AGENDAMENTOS", Map.of(
                1, "Novo",
                2, "Editar",
                3, "Excluir",
                4, "Listar",
                0, "Voltar"
        ));
    }

    private void menuListarAgendamentos() {
        int opcao = Menu.exibir("MENU DE AGENDAMENTOS", Map.of(
                1, "Listar por médico",
                2, "Listar por paciente",
                3, "Listar por data",
                4, "Listar todos",
                0, "Voltar"
        ));
    }

    private void menuHistoricoConsultas() {
        int opcao = Menu.exibir("HISTÓRICO DE CONSULTAS", Map.of(
                1, "Listar por médico",
                2, "Listar por paciente",
                3, "Listar por data",
                4, "Listar todos",
                0, "Voltar"
        ));
    }

    private void menuPerfil() {
        int opcao = Menu.exibir("MEU PERFIL", Map.of(
                1, "Ver dados pessoais",
                2, "Editar dados pessoais",
                0, "Voltar"
        ));
    }

    private void menuMeuPerfil() {
        System.out.println("Meu Perfil");
    }
}
