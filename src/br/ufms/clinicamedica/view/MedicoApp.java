package br.ufms.clinicamedica.view;

import br.ufms.clinicamedica.OLD.controller.ClinicaMedica;
import br.ufms.clinicamedica.model.Medico;

import java.util.Map;

public class MedicoApp {

    private final ClinicaMedica clinica;

    public MedicoApp(ClinicaMedica clinica) {
        this.clinica = clinica;
    }

    public void iniciar(Medico medico) {
        menuPrincipal();
    }

    private void menuPrincipal() {
        int opcao = Menu.exibir("MENU PRINCIPAL", Map.of(
                1, "Consultas agendadas",
                2, "Histórico de Consultas",
                9, "Meu Perfil",
                0, "Sair"
        ));
    }

    private void menuConsultasMedicoSelecionar() {
        int opcao = Menu.exibir("CONSULTAS AGENDADAS", Map.of(
                0, "Voltar"
        ));
    }

    private void menuConsultaMedica() {
        int opcao = Menu.exibir("CONSULTA MÉDICA", Map.of(
                1, "Prescrever Receita",
                2, "Pedir Exames",
//                9, "Finalizar Consulta",
                0, "Voltar"
        ));
    }
}
