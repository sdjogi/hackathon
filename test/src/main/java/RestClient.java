import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



/**
 * @author jogish
 */
public class RestClient {

    public static void main(String a[]){
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8080/getCaptcha");
        try{
            HttpResponse response = client.execute(request);
            OutputStream outputStream = null;

            try {
                // read this file into InputStream

                // write the inputStream to a FileOutputStream
                outputStream =
                            new FileOutputStream(new File("c:\\Users\\jogish\\Desktop\\test.png"));

                int read = 0;
                byte[] bytes = new byte[1024];
                //ImageInputStream image = ImageIO.createImageInputStream(response.getEntity().getContent());

                while ((read = response.getEntity().getContent().read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                System.out.println("Done!");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        // outputStream.flush();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }catch (Exception e){
        }
    }

}
