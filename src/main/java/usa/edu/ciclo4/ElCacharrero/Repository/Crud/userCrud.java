package usa.edu.ciclo4.ElCacharrero.Repository.Crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import usa.edu.ciclo4.ElCacharrero.Model.userModel;

/**
 *
 * @author Andy
 */
public interface userCrud extends CrudRepository<userModel, Integer> {

  //consultas para guardar usuarios 
  public Optional<userModel> findByName(String name);

  public Optional<userModel> findByEmail(String email);

  // busca por los dos campos 
  public List<userModel> findByNameOrEmail(String name, String email);



  //validacion para el login 
  public Optional<userModel> findByEmailAndPassword(String email, String password);

}
