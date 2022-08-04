import java.io.*;
import java.util.*;
// import stat ;

class ImplementAPI {

  public static void main(String[] args) {
    System.out.println("test");
  }

  public static List<String> implementAPI(List<String> logs){
    HashMap<String, String> register = new HashMap<>();
    HashMap<String, String> login = new HashMap<>();
    List<String> res = new ArrayList<>();

    for(String log : logs) {
      String [] splitArr = log.split("");
      String operation = splitArr[0];
      String username = splitArr[1];
      String password = null;
      if(splitArr.length > 2){
        password = splitArr[2];
      }
      if("register".equals(operation)){
        if(register.containsKey(username)){
          res.add("Username already exists");
        } else{
          register.put(username, password);
          res.add("Registered Successfully");
        }
      } else if("login".equals(operation)){
        if(register.containsKey(username)){
          if(login.containsKey(username)){
            res.add("Login Unsuccessfully");
          }else{
            login.put(username, password);
            res.add("Login Sucessfully");
          }
        } else {
          res.add("Login Unsuccessfully");
        }
      } else{
        if(register.containsKey(username)){
          if(login.containsKey(username)){
            res.add("Logout Successfully");
            login.remove(username);
          } else{
            res.add("Logout Unsuccessfully");
          }
        } else{
          res.add("Logout Unsuccessfully");
        }
        
      }

    }
    return res;
  }

}