# Desenvolvendo uma plataforma de Bootcamps através de uma API REST com Spring Boot

Este projeto foi pensado em abstrair uma plataforma de Bootcamp, onde a mesma registra os novos alunos, cursos, mentoria, bootcamps.
Essa API está projetada para registro, consulta, modificação e edição, de qualquer entidade mencionada anteriormente.
As etapas até agora desenvolvida nesta API:
- Cadastro de um **Aluno**, passando o seu nome, e o seu cep. (Não estão sendo pedido outros dados, como CPF e email, neste momento).
    - Obs.: Ao passar o cep, o sistema irá consumir a API <a href="https://viacep.com.br/">ViaCEP</a>, com isso, o sistema irá baixar todos os dados referente àquele cep.
- Cadastro de um **Bootcamp**, passando a data limite para terminar o Bootcamp (o de início irá ser gerado automaticamente),
- Adicionar **Aluno** a determinado Bootcamp, passando o id do Bootcamp, além do Aluno em questão.
- Deletar um **Aluno** passando o seu *id*

% Em atualização