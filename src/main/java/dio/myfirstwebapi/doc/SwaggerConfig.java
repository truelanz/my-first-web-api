package dio.myfirstwebapi.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private springfox.documentation.service.Contact contact() {
		return new Contact(
				"truelanz",
				"http://www.truedotrue.com.br", 
				"voce@seusite.com.br");
	}
    
//-----------------	//CONFIGURAÇÕES BASE DA INTERFACE DO SWAGGER\\ ----------------------\\

    private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Title");
		apiInfoBuilder.description("API exemplo de uso de Springboot REST API");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
		apiInfoBuilder.license("Licença - Sua Empresa");
		apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
		apiInfoBuilder.contact(this.contact());
 
		return apiInfoBuilder;
	}

//----------------------------------------------------------------------------------------------\\

    @Bean
public Docket detalheApi() {
	Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
	docket
	.select()
	.apis(RequestHandlerSelectors.basePackage("dio.myfirstwebapi.controller"))//Copia o diretório do pacote que o SWAGGER vai escanear
	.paths(PathSelectors.any())
	.build()
	.apiInfo(this.informacoesApi().build())
	.consumes(new HashSet<String>(Arrays.asList("application/json")))
	.produces(new HashSet<String>(Arrays.asList("application/json")));
	
	return docket;
}
}
