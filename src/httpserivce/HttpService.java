/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserivce;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import httpserivce.responemodel.AttendenceClass;
import httpserivce.responemodel.CreateClassRespone;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static javafx.css.StyleOrigin.USER_AGENT;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author tuyen
 */
public class HttpService {
    public String GetClassAll() throws Exception {
		
        String url = "http://cbfarmv2.combrosidc.com:4022/class/all";
        URIBuilder builder = new URIBuilder(url);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(builder.build());
        org.apache.http.HttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer stringBuffer = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
        }
        in.close();
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();

	}
    
    public String GetCurentRolls(int class_id) throws Exception {
        String url = "http://cbfarmv2.combrosidc.com:4022/roll/current";
        URIBuilder builder = new URIBuilder(url);
        builder.addParameter("class_id", String.valueOf(class_id));

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(builder.build());
        org.apache.http.HttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer stringBuffer = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
        }
        in.close();
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
	}
    
    
        public String GetRolltimesStudent(int class_id,String mssv) throws Exception {
            String url = "http://cbfarmv2.combrosidc.com:4022/roll/timesByMssv";
            URIBuilder builder = new URIBuilder(url);
            builder.addParameter("class_id",String.valueOf(class_id));
            builder.addParameter("mssv", mssv);
            System.out.println(builder.toString());
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(builder.build());
            org.apache.http.HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream));
            String inputLine;
            StringBuffer stringBuffer = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    stringBuffer.append(inputLine);
            }
            in.close();
            System.out.println(stringBuffer.toString());
            return stringBuffer.toString();
	}
        
        
        public String GetAllStudent(int ClassID) throws Exception {
        String url = "http://cbfarmv2.combrosidc.com:4022/student/byClassID";
        URIBuilder builder = new URIBuilder(url);
        builder.addParameter("class_id", String.valueOf(ClassID));

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(builder.build());
        org.apache.http.HttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer stringBuffer = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
        }
        in.close();
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
	}
        
        public String CreateClass(AttendenceClass attendenceClass) throws Exception {
        String url = "http://cbfarmv2.combrosidc.com:4022/class/create";
        URIBuilder builder = new URIBuilder(url);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpGet = new HttpPost(builder.build());
        List<NameValuePair> arguments = new ArrayList<>();
        arguments.add(new BasicNameValuePair("name", attendenceClass.getName()));
        arguments.add(new BasicNameValuePair("code", attendenceClass.getCode()));
        arguments.add(new BasicNameValuePair("year", attendenceClass.getYear()));
        arguments.add(new BasicNameValuePair("semester", String.valueOf(attendenceClass.getSemester())));
        httpGet.setEntity(new UrlEncodedFormEntity(arguments));
        org.apache.http.HttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer stringBuffer = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
        }
        in.close();
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
	}
        
        public String GetRollReport(int ClassID) throws Exception {
    String url = "http://cbfarmv2.combrosidc.com:4022/roll/dateByClassID";
    URIBuilder builder = new URIBuilder(url);
    builder.addParameter("class_id", String.valueOf(ClassID));

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet httpGet = new HttpGet(builder.build());
    org.apache.http.HttpResponse response = httpClient.execute(httpGet);
    int statusCode = response.getStatusLine().getStatusCode();
    InputStream inputStream = response.getEntity().getContent();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
    }
    in.close();
    System.out.println(stringBuffer.toString());
    return stringBuffer.toString();
    }
        
    public String Login(String usr,String pwd) throws Exception {
    String url = "http://cbfarmv2.combrosidc.com:4022/auth/login";
    URIBuilder builder = new URIBuilder(url);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpGet = new HttpPost(builder.build());
    List<NameValuePair> arguments = new ArrayList<>();
    arguments.add(new BasicNameValuePair("user_name", usr));
    arguments.add(new BasicNameValuePair("password", pwd));
    httpGet.setEntity(new UrlEncodedFormEntity(arguments));
    org.apache.http.HttpResponse response = httpClient.execute(httpGet);
    int statusCode = response.getStatusLine().getStatusCode();
    InputStream inputStream = response.getEntity().getContent();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
    }
    in.close();
    System.out.println(stringBuffer.toString());
    return stringBuffer.toString();
    }
    
        public String Signup(String usr,String pwd) throws Exception {
    String url = "http://cbfarmv2.combrosidc.com:4022/auth/signup";
    URIBuilder builder = new URIBuilder(url);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpGet = new HttpPost(builder.build());
    List<NameValuePair> arguments = new ArrayList<>();
    arguments.add(new BasicNameValuePair("user_name", usr));
    arguments.add(new BasicNameValuePair("password", pwd));
    httpGet.setEntity(new UrlEncodedFormEntity(arguments));
    org.apache.http.HttpResponse response = httpClient.execute(httpGet);
    int statusCode = response.getStatusLine().getStatusCode();
    InputStream inputStream = response.getEntity().getContent();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
    }
    in.close();
    System.out.println(stringBuffer.toString());
    return stringBuffer.toString();
    }
        
    public String CreateRoll(int class_id,int finger_id) throws Exception {
    String url = "http://cbfarmv2.combrosidc.com:4022/roll/create";
    URIBuilder builder = new URIBuilder(url);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpGet = new HttpPost(builder.build());
    List<NameValuePair> arguments = new ArrayList<>();
    arguments.add(new BasicNameValuePair("class_id", String.valueOf(class_id)));
    arguments.add(new BasicNameValuePair("finger_id", String.valueOf(finger_id)));
    httpGet.setEntity(new UrlEncodedFormEntity(arguments));
    org.apache.http.HttpResponse response = httpClient.execute(httpGet);
    int statusCode = response.getStatusLine().getStatusCode();
    InputStream inputStream = response.getEntity().getContent();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
    }
    in.close();
    System.out.println(stringBuffer.toString());
    return stringBuffer.toString();
    }
    
    public CreateClassRespone CreateStudent(String name,int mssv,int class_id,int finger_id,boolean autheticated) throws Exception {
    String url = "http://cbfarmv2.combrosidc.com:4022/student/create";
    URIBuilder builder = new URIBuilder(url);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpGet = new HttpPost(builder.build());
    List<NameValuePair> arguments = new ArrayList<>();
    arguments.add(new BasicNameValuePair("name", String.valueOf(name)));
    arguments.add(new BasicNameValuePair("mssv", String.valueOf(mssv)));
    arguments.add(new BasicNameValuePair("class_id", String.valueOf(class_id)));
    arguments.add(new BasicNameValuePair("finger_id", String.valueOf(finger_id)));
    arguments.add(new BasicNameValuePair("autheticated", String.valueOf(autheticated)));

    httpGet.setEntity(new UrlEncodedFormEntity(arguments));
    org.apache.http.HttpResponse response = httpClient.execute(httpGet);
    int statusCode = response.getStatusLine().getStatusCode();
    InputStream inputStream = response.getEntity().getContent();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
    }
    in.close();
    System.out.println(stringBuffer.toString());
           Gson gson = new GsonBuilder().create();
       CreateClassRespone r=new CreateClassRespone();
       r=gson.fromJson(stringBuffer.toString(), CreateClassRespone.class);
    return r;
    }
    public CreateClassRespone UpdateStudent(String name,int mssv,int class_id,int finger_id,boolean autheticated) throws Exception {
    String url = "http://cbfarmv2.combrosidc.com:4022/student/update";
    URIBuilder builder = new URIBuilder(url);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpGet = new HttpPost(builder.build());
    List<NameValuePair> arguments = new ArrayList<>();
    arguments.add(new BasicNameValuePair("name", String.valueOf(name)));
    arguments.add(new BasicNameValuePair("mssv", String.valueOf(mssv)));
    arguments.add(new BasicNameValuePair("class_id", String.valueOf(class_id)));
    arguments.add(new BasicNameValuePair("finger_id", String.valueOf(finger_id)));
    arguments.add(new BasicNameValuePair("autheticated", String.valueOf(autheticated)));

    httpGet.setEntity(new UrlEncodedFormEntity(arguments));
    org.apache.http.HttpResponse response = httpClient.execute(httpGet);
    int statusCode = response.getStatusLine().getStatusCode();
    InputStream inputStream = response.getEntity().getContent();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
    }
    in.close();
    System.out.println(stringBuffer.toString());
           Gson gson = new GsonBuilder().create();
       CreateClassRespone r=new CreateClassRespone();
       r=gson.fromJson(stringBuffer.toString(), CreateClassRespone.class);
    return r;
    }
}
