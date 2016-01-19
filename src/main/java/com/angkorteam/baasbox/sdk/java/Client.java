package com.angkorteam.baasbox.sdk.java;

import com.angkorteam.baasbox.sdk.java.json.*;
import com.angkorteam.baasbox.sdk.java.response.LogoutResponse;
import com.angkorteam.baasbox.sdk.java.response.SuccessResponse;
import retrofit.client.Response;
import retrofit.http.*;

/**
 * Created by socheatkhauv on 1/14/16.
 */
public interface Client {

    /**
     * User Management
     *
     * @param json
     * @return
     */
    @POST("/login")
    public SuccessResponse login(@Body LoginJson json);

    /**
     * User Management
     *
     * @param appCode
     * @param json
     * @return
     */
    @POST("/user")
    public SuccessResponse signup(@Header("X-BAASBOX-APPCODE") String appCode, @Body SignupJson json);

    /**
     * User Management
     *
     * @param appCode
     * @param session
     * @return
     */
    @POST("/logout")
    public LogoutResponse logout(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session);

    /**
     * User Management
     *
     * @param appCode
     * @param session
     * @param pushToken
     * @return
     */
    @POST("/logout/{pushToken}")
    public LogoutResponse logout(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("pushToken") String pushToken);

    /**
     * User Management
     *
     * @param appCode
     * @param session
     * @return
     */
    @PUT("/me/suspend")
    @Streaming
    public Response suspendUser(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Body String mock);

    /**
     * User Management
     *
     * @param appCode
     * @param session
     * @param username
     * @return
     */
    @PUT("/admin/user/suspend/{username}")
    @Streaming
    public Response suspendUser(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("username") String username, @Body String mock);

    /**
     * User Management
     *
     * @param appCode
     * @param session
     * @param username
     * @return
     */
    @PUT("/admin/user/activate/{username}")
    @Streaming
    public Response activateUser(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("username") String username, @Body String mock);

    /**
     * User Management
     *
     * @param session
     * @return
     */
    @GET("/me")
    public SuccessResponse loggedUserProfile(@Header("X-BB-SESSION") String session);

    /**
     * User Management
     *
     * @param session
     * @param json
     * @return
     */
    @PUT("/me")
    public SuccessResponse updateUserProfile(@Header("X-BB-SESSION") String session, @Body UpdateUserProfileJson json);

    /**
     * User Management
     *
     * @param session
     * @param username
     * @return
     */
    @GET("/user/{username}")
    public SuccessResponse fetchUserProfile(@Header("X-BB-SESSION") String session, @Path("username") String username);

    /**
     * User Management
     *
     * @param session
     * @return
     */
    @GET("/users")
    public SuccessResponse fetchUsers(@Header("X-BB-SESSION") String session);

    /**
     * User Management
     *
     * @param session
     * @param json
     * @return
     */
    @PUT("/me/password")
    public SuccessResponse changePassword(@Header("X-BB-SESSION") String session, @Body ChangePasswordJson json);

    /**
     * User Management
     *
     * @param session
     * @param json
     * @return
     */
    @PUT("/me/username")
    public SuccessResponse changeUsername(@Header("X-BB-SESSION") String session, @Body ChangeUsernameJson json);

    /**
     * User Management
     *
     * @param appCode
     * @param username
     * @return
     */
    @GET("/user/{username}/password/reset")
    public Response passwordReset(@Header("X-BAASBOX-APPCODE") String appCode, @Path("username") String username);

    @GET("/social")
    public SuccessResponse social(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session);

    @GET("/social")
    public SuccessResponse social(@Header("X-BB-SESSION") String session);

    @POST("/social/{socialNetwork}")
    public SuccessResponse socialLogin(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Header("socialNetwork") String socialNetwork, @Body SocialLoginJson json);

    @POST("/social/{socialNetwork}")
    public SuccessResponse socialLogin(@Header("X-BB-SESSION") String session, @Header("socialNetwork") String socialNetwork, @Body SocialLoginJson json);

    @PUT("/social/{socialNetwork}")
    public SuccessResponse socialLink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Header("socialNetwork") String socialNetwork, @Body SocialLinkJson json);

    @PUT("/social/{socialNetwork}")
    public SuccessResponse socialLink(@Header("X-BB-SESSION") String session, @Header("socialNetwork") String socialNetwork, @Body SocialLinkJson json);

    @DELETE("/social/{socialNetwork}")
    public SuccessResponse socialUnlink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session);

    @DELETE("/social/{socialNetwork}")
    public SuccessResponse socialUnlink(@Header("X-BB-SESSION") String session);

    @POST("/follow/{username}")
    public SuccessResponse followUser(@Header("X-BB-SESSION") String session, @Path("username") String username, @Body String mock);

    @DELETE("/follow/{username}")
    public SuccessResponse unfollowUser(@Header("X-BB-SESSION") String session, @Path("username") String username);

    @GET("/following/{username}")
    public SuccessResponse fetchFollowing(@Header("X-BB-SESSION") String session, @Path("username") String username);

    @GET("/followers/{username}")
    public SuccessResponse fetchFollowers(@Header("X-BB-SESSION") String session, @Path("username") String username);

    @PUT("/push/enable/{os}/{token}")
    public SuccessResponse enablePushNotification(@Header("X-BB-SESSION") String session, @Path("os") String os, @Path("token") String token, @Body String mock);

    @PUT("/push/disable/{token}")
    public SuccessResponse disablePushNotification(@Header("X-BB-SESSION") String session, @Path("token") String token, @Body String mock);

    @POST("/push/message")
    public SuccessResponse sendPushNotification(@Header("X-BB-SESSION") String session, @Body SendPushNotificationJson json);

}
