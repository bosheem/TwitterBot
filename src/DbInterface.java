import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.
public class DbInterface {
	
	//Going to implement a REST API to access IGDB video game database 
	//https://api-docs.igdb.com/#about
	//Apache Restful 
	//tutorialspoint.com/apache_httpclient/apache_httpclient_environment_setup.htm
	
    //Creating a HttpClient object
    CloseableHttpClient httpclient = HttpClients.createDefault();

    //Creating a HttpGet object
    HttpGet httpget = new HttpGet("https://www.tutorialspoint.com/ ");

    //Printing the method used
    System.out.println("Request Type: "+httpget.getMethod());

    //Executing the Get request
    HttpResponse httpresponse = httpclient.execute(httpget);

    Scanner sc = new Scanner(httpresponse.getEntity().getContent());

    //Printing the status line
    System.out.println(httpresponse.getStatusLine());
    while(sc.hasNext()) {
       System.out.println(sc.nextLine());

}
