package usa.edu.ciclo4.ElCacharrero.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo4.ElCacharrero.Model.userModel;
import usa.edu.ciclo4.ElCacharrero.Repository.Crud.userCrud;

/**
 *
 * @author Andy
 */
@Repository
public class userRepository {

  @Autowired
  private userCrud objUserCrud;//Instancia de las dependencias de crud

  //Obtiene todos los registros
  public List<userModel> getAll() {
    return (List<userModel>) objUserCrud.findAll();
  }

  // Guarda un usuario 
  public userModel saveUser(userModel objUser) {
    return objUserCrud.save(objUser);
  }

  // validaciones para guardar usuario
  public Optional<userModel> getUserByName(String name) {
    return objUserCrud.findByName(name);
  }

  public Optional<userModel> getUserByEmail(String Email) {
    return objUserCrud.findByEmail(Email);
  }

  public List<userModel> getExistUser(String name, String email) {
    return objUserCrud.findByNameOrEmail(name, email);
  }

  public Optional<userModel> getUserByid(Integer id) {
    return objUserCrud.findById(id);
  }

  //Validaciones para login 
  public Optional<userModel> getUserEmailAndPassword(String email, String password) {
    return objUserCrud.findByEmailAndPassword(email, password);
  }
 
}
