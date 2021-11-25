package usa.edu.ciclo4.ElCacharrero.Web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.edu.ciclo4.ElCacharrero.Model.userModel;
import usa.edu.ciclo4.ElCacharrero.Service.userServices;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

public class userController {

  // atributos 
  @Autowired

  /**
   *
   */
  private userServices objServices;

  ///////// METODOS /////////
  //obtiene todos los registros de la tabla 
  /**
   *
   * @return
   */
  @GetMapping("/all")
  public List<userModel> getAll() {
    return objServices.getAll();
  }

  /**
   *
   * @param objUser
   * @return
   */
  @PostMapping("/new")
  @ResponseStatus(HttpStatus.CREATED) // solucion de error..
  public userModel saveUser(@RequestBody userModel objUser) {
    return objServices.saveUser(objUser);
  }

  /**
   *
   * @param email
   * @return
   */
  @GetMapping("/{email}")
  public boolean getUserByEmail(@PathVariable("email") String email) {
    return objServices.getUserByEmail(email);
  }

  /**
   *
   * @param email
   * @param password
   * @return
   */
  @GetMapping("/{email}/{password}")
  public userModel getLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
    return objServices.getLogin(email, password);
  }
}
