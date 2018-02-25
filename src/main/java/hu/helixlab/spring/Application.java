package hu.helixlab.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	//itt fut a main metódus, a springbootapplication annotáció adja meg hogy springes az alkalmazás belépési pontja
//alkalmazás felépítése

	//frontend: view--controller--service
	//frontend app a fő appja, service, controllerje,html oldalak
	//backend: repository, domain--service--controller
	//backend pom.xml, application.properties, application, domainek az entitásokkak, repositoryk a metódusokkal interfacek
	//servicek, controllerek, ha kell bootstrap

	//backend controllerje kommunikál a fronend service-szel
	//apach--xampp ennek a porja 80, webszerver
	//tomcat 8080 szerver
	//postgres szerver 5432 adatbázis szerver


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
