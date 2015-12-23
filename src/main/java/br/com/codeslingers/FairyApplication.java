package br.com.codeslingers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeslingers.beans.PeopleBean;
import br.com.codeslingers.repository.PeopleRepository;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class FairyApplication extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(FairyApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	log.info("[DEV] configure");
        return application.sources(FairyApplication.class);
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
    	log.info("[DEV] home");
        return "Hello World!";
    }
    
    @RequestMapping(value="/convidado/lista", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PeopleBean> getListarConvidados() {
    	log.info("[DEV] getListarConvidados");
    	List<PeopleBean> retorno = new ArrayList<PeopleBean>();
    	
    	PeopleBean b1 = new PeopleBean();
    	b1.setIdPessoa(1);
    	b1.setNome("Fernanda");
    	retorno.add(b1);
    	
    	return retorno;
    }
    
//    @Bean
//	public void demo(PeopleRepository repository) {
//
//			for (PeopleBean p : repository.findAll()) {
//				log.info(p.toString());
//			}
// 		}
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(FairyApplication.class, args);
//    	Class.forName("com.mysql.jdbc.Driver");
//        // Setup the connection with the DB
//    	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/fairydb?user=fairy_user&password=september2017");
//    	
//    	Statement statement = connect.createStatement();
//        // Result set get the result of the SQL query
//    	ResultSet  resultSet = statement
//            .executeQuery("select * from tb_pessoas");
//        
//        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
//            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
//          }
    }
}
