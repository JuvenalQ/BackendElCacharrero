package usa.edu.ciclo4.ElCacharrero.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// propiedades de lombok para que cree el get y el set y constructores 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Andy
 */
@Data //crea los getters y setters de la clase
@NoArgsConstructor // crea el constructor sin argumentos 
@AllArgsConstructor //constructor por parametros

@Entity
@Table(name = "user")
public class userModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)   //Genera de forma automatica el Id 

  private Integer id;

  // Propiedades de la columna
  @Column(name = "user_email", unique = true, length = 50, nullable = false)
  private String email;

  @Column(name = "user_password", length = 50, nullable = false)
  private String password;

  @Column(name = "user_name", length = 80, nullable = false)
  private String name;

}
