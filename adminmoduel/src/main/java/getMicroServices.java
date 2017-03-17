import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.faces.bean.ManagedBean;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;




/**
 * @author jogish
 */
@ManagedBean(name= "microservice")
public class getMicroServices {

    /**
     *
     */
    private String userName;

    private String password;


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String authenticate() throws Exception{
          HttpClient client = new DefaultHttpClient();
          String url = "http://localhost:8888/"+userName+"/"+password;
          HttpGet request = new HttpGet(url);
          HttpResponse response = client.execute(request);
          BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
          String line = "";
          String val = "";
          while ((line = rd.readLine()) != null) {
            val = line;
          }
          String retStr = "";
          if(!"Login Failed".equalsIgnoreCase(val)){
              retStr = "welcome";
          }else{
              retStr = "failed";
          }

        return retStr;
    }


}
