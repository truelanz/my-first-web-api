## SWEGGER + :leaves: Spring Boot :leaves: - Problemas e Soluções. 

- Erro na execução:grey_question:
- Incompatibilidade entre as versões Spring Boot/Swagger:grey_question:
- O maven não baixa a dependência do Swagger:grey_question:
- Não consegue chamar as anotações do 'Swagger':grey_question:

 #### Se você está com algum desses problemas, é possível que agora consiga resolver de vez.

 Se está com erro na execução por conta do Swagger, começe conferindo a compatibilidade da sua versão *Java, Spring Boot e da sua dependência Swagger* `io.springfox`.

###### Aparentemente a dependency `io.springfox version 3.0.0` não foi compatível com as versões do Spring Boot acima de `2.5.2`.

 Então comece *alterando a versão do seu Spring Boot* no `pom.xml` do seu projeto:

 `<parent>`
		`<groupId>org.springframework.boot</groupId>`
		`<artifactId>spring-boot-starter-parent</artifactId>`
		`<version>2.5.2</version>`
		`<relativePath/>`
	`</parent>`

  Use junto com a versão 3.0.0 do Swagger:

`<dependency>`
  `<groupId>io.springfox</groupId>`
  `<artifactId>springfox-boot-starter</artifactId>`
  `<version>3.0.0</version>`
`</dependency>`

//Salve e sincronize seu pom.xml (essa `3.0.0` versão não se faz necessário a dependency ~~`springfox-swagger-ui`~~).
###### Tente executar com: http://localhost:8080/swagger-ui/index.html ou: http://localhost:8080/swagger-ui/

 *Caso seu maven não estivesse baixando a "biblioteca Swagger" vá na sua classe de configurações do seu Swagger e veja se agora aparece as anotações e métodos da dependência.* _(Não se faz necessária a utilização `@EnableSwagger2`, mas ela aparecerá, junto com `@EnableOpenAi`._

  - Caso não apareça e/ou dê erro na execução - mude sua versão do Java no `pom.xml`, você pode testar em ordem decrescente se quiser até que funcione, ou coloque a versão `1.8` do java como eu fiz: `<java.version>1.8</java.version>` .

:arrows_counterclockwise:  **_Sempre atualize e teste_** no localhost...

   ## Bonus: :coffee:

   _Se estiver com problemas para criar a classe de configuração do Swagger, segue uma colinha:_

   ![swagger configuration](https://i.imgur.com/167Z4y8.jpg)

   _Você usa a **IDE VSCODE** e ainda assim não está baixando a "biblioteca Swagger?_
   - Exclua sua dependencia `io.springfox` do `pom.xml`.
   - Feixe sua IDE, exclua sua pasta repository em Usuário/"usuário"/m2/.
   - Abra seu VSCODE e espere baixar novamente seus repositórios.
   - Baixe a extenção: "Maven for Java" na sua IDE
   - No canto inferior esquerdo, clique em maven, seu projeto e no `+` do lado direito de `Dependencies`:


   ![Download dependência VSCODE](/assets/Download%20dependência%20VSCODE.jpg)

   - clique em `springfox.swagger2`.

   _Referências_:
   https://springfox.github.io/springfox/docs/current/#migrating-from-existing-2-x-version
   
   https://medium.com/javarevisited/api-documentation-using-swagger-3-with-spring-boot-2-spring-security-5a0d2b0996ee

   https://www.javainuse.com/spring/boot_swagger3

   https://stackoverflow.com/questions/74614369/how-to-run-swagger-3-on-spring-boot-3

   https://springdoc.org/v2/#features

   `[PT-BR]` https://www.youtube.com/watch?v=pMXnR1T47e0&ab_channel=Developertips
