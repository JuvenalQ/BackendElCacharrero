package usa.edu.ciclo4.ElCacharrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"usa.edu.ciclo4.ElCacharrero.Model"})
public class ElCacharreroApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElCacharreroApplication.class, args);
  }

}
