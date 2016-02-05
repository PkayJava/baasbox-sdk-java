package com.angkorteam.baasbox.sdk.java;

import com.angkorteam.baasbox.sdk.java.json.*;
import com.angkorteam.baasbox.sdk.java.response.ArrayResponse;
import com.angkorteam.baasbox.sdk.java.response.StringResponse;
import com.angkorteam.baasbox.sdk.java.response.SuccessResponse;
import retrofit.client.Response;
import retrofit.http.*;
import retrofit.mime.TypedFile;

import java.util.Map;

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
    public StringResponse logout(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session);

    /**
     * User Management
     *
     * @param appCode
     * @param session
     * @param pushToken
     * @return
     */
    @POST("/logout/{pushToken}")
    public StringResponse logout(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("pushToken") String pushToken);

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
    public SuccessResponse fetchUsers(@Header("X-BB-SESSION") String session, @QueryMap Map<String, String> query);

    /**
     * User Management
     *
     * @param session
     * @param json
     * @return
     */
    @PUT("/me/password")
    public StringResponse changePassword(@Header("X-BB-SESSION") String session, @Body ChangePasswordJson json);

    /**
     * User Management
     *
     * @param session
     * @param json
     * @return
     */
    @PUT("/me/username")
    public StringResponse changeUsername(@Header("X-BB-SESSION") String session, @Body ChangeUsernameJson json);

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
    public SuccessResponse socialLogin(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("socialNetwork") String socialNetwork, @Body SocialLoginJson json);

    @POST("/social/{socialNetwork}")
    public SuccessResponse socialLogin(@Header("X-BB-SESSION") String session, @Path("socialNetwork") String socialNetwork, @Body SocialLoginJson json);

    @PUT("/social/{socialNetwork}")
    public SuccessResponse socialLink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("socialNetwork") String socialNetwork, @Body SocialLinkJson json);

    @PUT("/social/{socialNetwork}")
    public SuccessResponse socialLink(@Header("X-BB-SESSION") String session, @Path("socialNetwork") String socialNetwork, @Body SocialLinkJson json);

    @DELETE("/social/{socialNetwork}")
    public SuccessResponse socialUnlink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("socialNetwork") String socialNetwork);

    @DELETE("/social/{socialNetwork}")
    public SuccessResponse socialUnlink(@Header("X-BB-SESSION") String session, @Path("socialNetwork") String socialNetwork);

    @POST("/follow/{username}")
    public SuccessResponse followUser(@Header("X-BB-SESSION") String session, @Path("username") String username, @Body String mock);

    @DELETE("/follow/{username}")
    public StringResponse unfollowUser(@Header("X-BB-SESSION") String session, @Path("username") String username);

    @GET("/following/{username}")
    public SuccessResponse fetchFollowing(@Header("X-BB-SESSION") String session, @Path("username") String username);

    @GET("/followers/{username}")
    public SuccessResponse fetchFollowers(@Header("X-BB-SESSION") String session, @Path("username") String username);

    @PUT("/push/enable/{os}/{token}")
    public StringResponse enablePushNotification(@Header("X-BB-SESSION") String session, @Path("os") String os, @Path("token") String token, @Body String mock);

    @PUT("/push/disable/{token}")
    public StringResponse disablePushNotification(@Header("X-BB-SESSION") String session, @Path("token") String token, @Body String mock);

    @POST("/push/message")
    public StringResponse sendPushNotification(@Header("X-BB-SESSION") String session, @Body SendPushNotificationJson json);

    @POST("/admin/collection/{collection}")
    public StringResponse createCollection(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Body String mock);

    @DELETE("/admin/collection/{collection}")
    public StringResponse deleteCollection(@Header("X-BB-SESSION") String session, @Path("collection") String collection);

    @POST("/document/{collection}")
    public SuccessResponse createDocument(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Body Map<String, Object> document);

    @GET("/document/{collection}/{id}")
    public SuccessResponse retrieveDocumentById(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id);

    @GET("/document/{collection}")
    public ArrayResponse retrieveDocumentByQuery(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @QueryMap Map<String, String> query);

    @GET("/document/{collection}/count")
    public SuccessResponse countDocument(@Header("X-BB-SESSION") String session, @Path("collection") String collection);

    @PUT("/document/{collection}/{id}")
    public SuccessResponse modifyDocument(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id, @Body Map<String, Object> document);

    @PUT("/document/{collection}/{id}/.{field}")
    public SuccessResponse updateDocumentField(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id, @Path("field") String field, @Body Object data);

    @DELETE("/document/{collection}/{id}")
    public StringResponse deleteDocument(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id);

    @PUT("/document/{collection}/{id}/{action}/user/{username}")
    public StringResponse grantPermissionsDocumentUsername(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id, @Path("action") String action, @Path("username") String username, @Body String mock);

    @PUT("/document/{collection}/{id}/{action}/role/{rolename}")
    public StringResponse grantPermissionsDocumentRoleName(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id, @Path("action") String action, @Path("rolename") String rolename, @Body String mock);

    @DELETE("/document/{collection}/{id}/{action}/user/{username}")
    public StringResponse revokePermissionsDocumentUsername(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id, @Path("action") String action, @Path("username") String username);

    @DELETE("/document/{collection}/{id}/{action}/role/{rolename}")
    public StringResponse revokePermissionsDocumentRoleName(@Header("X-BB-SESSION") String session, @Path("collection") String collection, @Path("id") String id, @Path("action") String action, @Path("rolename") String rolename);

    @POST("/link/{sourceId}/{label}/{destinationId}")
    public SuccessResponse createLink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("sourceId") String sourceId, @Path("label") String label, @Path("destinationId") String destinationId, @Body String mock);

    @POST("/link/{sourceId}/{label}/{destinationId}")
    public SuccessResponse createLink(@Header("X-BB-SESSION") String session, @Path("sourceId") String sourceId, @Path("label") String label, @Path("destinationId") String destinationId, @Body String mock);

    @GET("/link/{id}")
    public SuccessResponse retrieveLink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("id") String id);

    @GET("/link")
    public SuccessResponse retrieveLink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @QueryMap Map<String, String> query);

    @DELETE("/link/{id}")
    public StringResponse deleteLink(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("id") String id);

    @Multipart
    @POST("/file")
    public SuccessResponse uploadFile(@Header("X-BB-SESSION") String session, @Part("file") TypedFile file, @Part("attachedData") String attachedData, @Part("acl") String acl);

    @DELETE("/file/{id}")
    public StringResponse deleteFile(@Header("X-BB-SESSION") String session, @Path("id") String id);

    @GET("/file/{id}")
    @Streaming
    public Response retrieveFile(@Header("X-BB-SESSION") String session, @Path("id") String id);

    @GET("/file/details/{id}")
    public SuccessResponse retrieveFileDetail(@Header("X-BB-SESSION") String session, @Path("id") String id);

    @GET("/file/details")
    public SuccessResponse retrieveFilesDetail(@Header("X-BB-SESSION") String session, @QueryMap Map<String, String> query);

    @PUT("/file/{id}/{action}/user/{username}")
    public StringResponse grantFileAccessUsername(@Header("X-BB-SESSION") String session, @Path("id") String id, @Path("action") String action, @Path("username") String username, @Body String mock);

    @PUT("/file/{id}/{action}/user/{rolename}")
    public StringResponse grantFileAccessRoleName(@Header("X-BB-SESSION") String session, @Path("id") String id, @Path("action") String action, @Path("rolename") String rolename, @Body String mock);

    @DELETE("/file/{id}/{action}/user/{username}")
    public StringResponse revokeFileAccessUsername(@Header("X-BB-SESSION") String session, @Path("id") String id, @Path("action") String action, @Path("username") String username);

    @DELETE("/file/{id}/{action}/user/{rolename}")
    public StringResponse revokeFileAccessRoleName(@Header("X-BB-SESSION") String session, @Path("id") String id, @Path("action") String action, @Path("rolename") String rolename);

    @POST("/admin/asset")
    @Multipart
    public SuccessResponse createAsset(@Header("X-BB-SESSION") String session, @Part("name") String name, @Part("meta") String meta, @Part("file") TypedFile file);

    @GET("/asset/{name}")
    @Streaming
    public Response retrieveAsset(@Header("X-BAASBOX-APPCODE") String appCode, @Path("name") String name);

    @DELETE("/admin/asset/{name}")
    public StringResponse deleteAsset(@Header("X-BB-SESSION") String session, @Path("name") String name);

    @GET("/admin/asset")
    public SuccessResponse fetchAsset(@Header("X-BB-SESSION") String session, @QueryMap Map<String, String> query);

    @GET("/admin/configuration/dump.json")
    public SuccessResponse fetchCurrentSetting(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session);

    @GET("/admin/configuration/{section}")
    public SuccessResponse fetchSectionSetting(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("section") String section);

    @PUT("/admin/configuration/{section}/{key}/{value}")
    public StringResponse updateValueSetting(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("section") String section, @Path("key") String key, @Path("value") String value, @Body String mock);

    @GET("/admin/endpoints")
    public SuccessResponse listGroup(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session);

    @GET("/admin/endpoints/{name}")
    public SuccessResponse readSpecificGroup(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("name") String name);

    @PUT("/admin/endpoints/{name}/enabled")
    public StringResponse enableEndpointGroup(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("name") String name, @Body String mock);

    @DELETE("/admin/endpoints/{name}/enabled")
    public StringResponse disableEndpointGroup(@Header("X-BAASBOX-APPCODE") String appCode, @Header("X-BB-SESSION") String session, @Path("name") String name);

}
