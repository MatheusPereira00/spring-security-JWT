# autentica-o-JWT

Projeto de Autenticação com Spring Security e JWT
Este projeto demonstra a implementação de um sistema de autenticação simples usando Spring Security e JWT em Java 21 e Spring Boot. O objetivo principal do projeto é aprimorar meus conhecimentos em:

Spring Security: Framework para segurança em aplicações Java, fornecendo recursos para autenticação e autorização.
JWT (JSON Web Token): Padrão aberto para criação de tokens de autenticação seguros e compactos.
Spring Boot: Framework para desenvolvimento rápido de aplicações Java com foco em simplicidade e produtividade.
Funcionalidades:

Autenticação de usuários com base em nome de usuário e senha.
Geração de tokens JWT para usuários autenticados.
Validação de tokens JWT em requisições subsequentes.
Controle de acesso a recursos da API baseado em funções (roles).
Estrutura do projeto:

Modelo: Contém as entidades do sistema, como Usuario e Role.
Repositório: Implementa o acesso a dados para as entidades.
Serviço: Contém a lógica de negócio da aplicação, como autenticação e geração de tokens.
Controlador: Define os endpoints da API e lida com as requisições HTTP.
Configuração de segurança: Define as regras de autenticação e autorização para a API.
Usuários:

Dois usuários pré-cadastrados estão disponíveis para teste:

Admin: Usuário com a função ADMIN, que tem acesso a todos os recursos da API.
Usuario: Usuário com a função USER, que tem acesso a recursos específicos da API.
Como usar:

Clone o projeto e importe-o para seu IDE favorito.
Inicie a aplicação com o comando mvn spring-boot:run.
Utilize os endpoints da API para realizar a autenticação e acessar os recursos protegidos.


<img src="https://github.com/MatheusPereira00/spring-security-JWT/blob/main/imgTable.png" alt="Logo tabela">
