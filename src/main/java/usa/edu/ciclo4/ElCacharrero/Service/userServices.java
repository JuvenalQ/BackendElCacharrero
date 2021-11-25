package usa.edu.ciclo4.ElCacharrero.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo4.ElCacharrero.Model.userModel;
import usa.edu.ciclo4.ElCacharrero.Repository.userRepository;

/**
 *
 * @author Andy
 */
@Service
public class userServices {

  @Autowired
  private userRepository objRepository;

  //obtiene todos los registros de la tabla 
  public List<userModel> getAll() {
    return objRepository.getAll();
  }

  // Guarda un usuario 
  public userModel saveUser(userModel objUser) {

    //validaciones 
    if (objUser.getName() == null || objUser.getEmail() == null || objUser.getEmail() == null) {
      return objUser;

    } else {

      //guardamos si existe un usuario
      List<userModel> existUser = objRepository.getExistUser(objUser.getName(), objUser.getEmail());

      if (existUser.isEmpty()) { // si existe lo devuelve 
        if (objUser.getId() == null) { // si el id es null lo guarda 
          return objRepository.saveUser(objUser);

        } else {

          Optional<userModel> existId = objRepository.getUserByid(objUser.getId());// obtiene si existe el id 
          if (existId.isEmpty()) {
            return objRepository.saveUser(objUser);
          } else {
            return objUser;
          }
        }
      } else {
        return objUser;
      }
    }
  }

  //devuelve un booleano si existe el email 
  public boolean getUserByEmail(String email) {
    return objRepository.getUserByEmail(email).isPresent();
  }

  // devuelve un REGISTRO si existe el usuario 
  public userModel getLogin(String email, String password) {

    Optional<userModel> userLogin = objRepository.getUserEmailAndPassword(email, password);

    if (userLogin.isPresent()) {
      return userLogin.get();
    } else {
      return new userModel(null, email, password, "NO DEFINIDO");
    }
  }

}
