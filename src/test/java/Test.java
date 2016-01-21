import com.angkorteam.baasbox.sdk.java.BaasBox;
import com.angkorteam.baasbox.sdk.java.Filter;
import com.angkorteam.baasbox.sdk.java.request.LoginRequest;
import com.angkorteam.baasbox.sdk.java.response.Response;
import com.angkorteam.baasbox.sdk.java.response.SuccessResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by socheatkhauv on 1/13/16.
 */
public class Test {

    public static final String IP_A = "http://192.168.1.108:9000";
    public static final String IP_B = "http://192.168.209.128:9000";
    public static final String IP_C = "http://172.16.1.48:9000";

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BaasBox baasBox = new BaasBox(IP_A, "1234567890");
        {
            LoginRequest request = new LoginRequest();
            request.setUsername("admin");
            request.setPassword("admin");
            Response response = baasBox.login(request);
//            System.out.println(gson.toJson(response));
        }
        {
            Response response = baasBox.loggedUserProfile();
            System.out.println(gson.toJson(response));
        }
//        File file = new File("/home/socheat/Documents/git/Red5/red5-server/changelog.txt");
//        baasBox.uploadFile(file, new HashMap<>(), new HashMap<>());
        {
//            Response response = baasBox.createCollection("test11");
        }
        {
//            Response response = baasBox.countDocument("test11");
        }
        {
            Filter filter = new Filter();
            filter.setFields("hello, firstName, test");
            filter.setGroupBy("hello");
            filter.setWhere("hello like 'world%'");
            Response response = baasBox.retrieveDocumentByQuery("test11", filter);
            System.out.println(gson.toJson(response));
        }
        {
//            Map<String, Object> document = new LinkedHashMap<>();
//            document.put("hello", "world");
//            baasBox.createDocument("test11", document);
        }
    }
}
