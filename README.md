# Sistema de Consultório Médico

Curso prático para a disciplina de Linguagem de Programação Orientada a Objetos (LPOO)

## Descrição do Problema

Uma empresa necessita de um sistema para controle e agendamento de pacientes. O sistema deve atender aos seguintes requisitos:

* O sistema possui três perfis de usuário: Paciente, Secretário e Médico.
* O Secretário é responsável pelo agendamento das consultas.
* O Paciente é responsável por solicitar consultas.
* O Médico é responsável por solicitar exames e preencher receitas.

## Dados dos Usuários

Paciente: Nome, Endereço, Telefone e Data de Nascimento.
- Pode solicitar agendamento de consulta, visualizar receitas e exames realizados em consultas anteriores.

Secretário: Nome, Endereço, Telefone, Data de Nascimento, Data de Ingresso no consultório e Salário.
- Pode marcar consultas, alterar dados de um paciente e receber pagamentos.

Médico: Nome, Endereço, Telefone, Data de Nascimento e CRM.
- Deve obrigatoriamente inserir a receita após a consulta e pode solicitar exames.
