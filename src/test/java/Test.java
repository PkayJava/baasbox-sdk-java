import com.angkorteam.baasbox.sdk.java.BaasBox;
import com.angkorteam.baasbox.sdk.java.request.LoginRequest;
import com.angkorteam.baasbox.sdk.java.response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by socheatkhauv on 1/13/16.
 */
public class Test {

    public static final String IP_A = "http://192.168.1.108:9000";
    public static final String IP_B = "http://192.168.209.128:9000";

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BaasBox baasBox = new BaasBox(IP_A, "1234567890");
        {
            LoginRequest request = new LoginRequest();
            request.setUsername("socheat.khauv");
            request.setPassword("123123a");
            Response response = baasBox.login(request);
//            System.out.println(gson.toJson(response));
        }
        {
            Response response = baasBox.loggedUserProfile();
            // System.out.println(gson.toJson(response));
        }
        {
            baasBox.followUser("pkayjava@gmail.com");
        }
        {
//            SignupRequest request = new SignupRequest();
//            request.setUsername("socheat.khauv");
//            request.setPassword("1234567890");
        }
    }
}
