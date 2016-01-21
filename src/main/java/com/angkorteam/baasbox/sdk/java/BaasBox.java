package com.angkorteam.baasbox.sdk.java;

import com.angkorteam.baasbox.sdk.java.json.*;
import com.angkorteam.baasbox.sdk.java.request.*;
import com.angkorteam.baasbox.sdk.java.response.StringResponse;
import com.angkorteam.baasbox.sdk.java.response.SuccessResponse;
import com.angkorteam.baasbox.sdk.java.response.ErrorResponse;
import com.angkorteam.baasbox.sdk.java.response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import org.apache.commons.io.IOUtils;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedFile;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by socheatkhauv on 1/13/16.
 */
public class BaasBox {

    private String appCode;

    private Object currentUser;

    private Client client;

    private Gson gson;

    private String session;

    public BaasBox(String address, String appCode) {
        this.appCode = appCode;
        {
            GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
            gson = builder.create();
        }
        OkHttpClient http = new OkHttpClient();
        OkClient client = new OkClient(http);
        http.setReadTimeout(1, TimeUnit.MINUTES);
        http.setConnectTimeout(1, TimeUnit.MINUTES);
        http.setWriteTimeout(1, TimeUnit.MINUTES);
        {
            RestAdapter.Builder builder = new RestAdapter.Builder();
            builder.setConverter(new GsonConverter(gson));
            builder.setEndpoint(address);
            builder.setClient(client);
            RestAdapter restAdapter = builder.build();
            this.client = restAdapter.create(Client.class);
        }
    }

    /**
     * User Management
     *
     * @param request
     * @return
     */
    public Response login(LoginRequest request) {
        LoginJson json = new LoginJson();
        json.setUsername(request.getUsername());
        json.setPassword(request.getPassword());
        json.setAppCode(appCode);
        try {
            SuccessResponse response = this.client.login(json);
            session = (String) response.getData().get("X-BB-SESSION");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param request
     * @return
     */
    public Response signup(SignupRequest request) {
        SignupJson json = new SignupJson();
        json.setUsername(request.getUsername());
        json.setPassword(request.getPassword());
        json.setVisibleByAnonymousUsers(request.getVisibleByAnonymousUsers());
        json.setVisibleByFriends(request.getVisibleByFriends());
        json.setVisibleByRegisteredUsers(request.getVisibleByRegisteredUsers());
        json.setVisibleByTheUser(request.getVisibleByTheUser());
        try {
            SuccessResponse response = this.client.signup(appCode, json);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param pushToken
     * @return
     */
    public Response logout(String pushToken) {
        try {
            StringResponse response = this.client.logout(appCode, session, pushToken);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @return
     */
    public Response logout() {
        try {
            StringResponse response = this.client.logout(appCode, session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @return
     */
    public Response suspendUser() {
        try {
            retrofit.client.Response resp = this.client.suspendUser(appCode, session, "mock");
            SuccessResponse response = new SuccessResponse();
            response.setHttpCode(resp.getStatus());
            response.setResult(resp.getReason());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param username
     * @return
     */
    public Response suspendUser(String username) {
        try {
            retrofit.client.Response resp = this.client.suspendUser(appCode, session, username, "mock");
            SuccessResponse response = new SuccessResponse();
            response.setResult(resp.getReason());
            response.setHttpCode(resp.getStatus());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param username
     * @return
     */
    public Response activateUser(String username) {
        try {
            retrofit.client.Response resp = this.client.activateUser(appCode, session, username, "mock");
            SuccessResponse response = new SuccessResponse();
            response.setHttpCode(resp.getStatus());
            response.setResult(resp.getReason());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @return
     */
    public Response loggedUserProfile() {
        try {
            SuccessResponse response = this.client.loggedUserProfile(session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param request
     * @return
     */
    public Response updateUserProfile(UpdateUserProfileRequest request) {
        UpdateUserProfileJson json = new UpdateUserProfileJson();
        if (request.getVisibleByAnonymousUsers() != null && !request.getVisibleByAnonymousUsers().isEmpty()) {
            json.setVisibleByAnonymousUsers(request.getVisibleByAnonymousUsers());
        }
        if (request.getVisibleByFriends() != null && !request.getVisibleByFriends().isEmpty()) {
            json.setVisibleByFriends(request.getVisibleByFriends());
        }
        if (request.getVisibleByRegisteredUsers() != null && !request.getVisibleByRegisteredUsers().isEmpty()) {
            json.setVisibleByRegisteredUsers(request.getVisibleByRegisteredUsers());
        }
        if (request.getVisibleByTheUser() != null && !request.getVisibleByTheUser().isEmpty()) {
            json.setVisibleByTheUser(request.getVisibleByTheUser());
        }
        try {
            SuccessResponse response = this.client.updateUserProfile(session, json);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param username
     * @return
     */
    public Response fetchUserProfile(String username) {
        try {
            SuccessResponse response = this.client.fetchUserProfile(session, username);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @return
     */
    public Response fetchUsers() {
        try {
            SuccessResponse response = this.client.fetchUsers(session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param request
     * @return
     */
    public Response changePassword(ChangePasswordRequest request) {
        try {
            ChangePasswordJson json = new ChangePasswordJson();
            json.setNewPassword(request.getNewPassword());
            json.setOldPassword(request.getOldPassword());
            StringResponse response = this.client.changePassword(session, json);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param request
     * @return
     */
    public Response changeUsername(ChangeUsernameRequest request) {
        try {
            ChangeUsernameJson json = new ChangeUsernameJson();
            json.setUsername(request.getUsername());
            StringResponse response = this.client.changeUsername(session, json);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * User Management
     *
     * @param username
     * @return
     */
    public Response passwordReset(String username) {
        try {
            retrofit.client.Response resp = this.client.passwordReset(appCode, username);
            SuccessResponse response = new SuccessResponse();
            response.setHttpCode(resp.getStatus());
            response.setResult(resp.getReason());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response social() {
        try {
            if (appCode != null && !"".equals(appCode) && session != null && !"".equals(session)) {
                SuccessResponse response = this.client.social(appCode, session);
                return response;
            }
            if (session != null && !"".equals(session)) {
                SuccessResponse response = this.client.social(session);
                return response;
            }
            return null;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response socialLogin(SocialLoginRequest request) {
        try {
            SocialLoginJson json = new SocialLoginJson();
            json.setSecret(request.getSecret());
            json.setToken(request.getToken());
            if (appCode != null && !"".equals(appCode) && session != null && !"".equals(session)) {
                SuccessResponse response = this.client.socialLogin(appCode, session, request.getSocialNetwork(), json);
                return response;
            }
            if (session != null && !"".equals(session)) {
                SuccessResponse response = this.client.socialLogin(session, request.getSocialNetwork(), json);
                return response;
            }
            return null;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response socialLink(SocialLinkRequest request) {
        try {
            SocialLinkJson json = new SocialLinkJson();
            json.setSecret(request.getSecret());
            json.setToken(request.getToken());
            if (appCode != null && !"".equals(appCode) && session != null && !"".equals(session)) {
                SuccessResponse response = this.client.socialLink(appCode, session, request.getSocialNetwork(), json);
                return response;
            }
            if (session != null && !"".equals(session)) {
                SuccessResponse response = this.client.socialLink(session, request.getSocialNetwork(), json);
                return response;
            }
            return null;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response socialUnlink() {
        try {
            if (appCode != null && !"".equals(appCode) && session != null && !"".equals(session)) {
                SuccessResponse response = this.client.socialUnlink(appCode, session);
                return response;
            }
            if (session != null && !"".equals(session)) {
                SuccessResponse response = this.client.socialUnlink(session);
                return response;
            }
            return null;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response followUser(String username) {
        try {
            SuccessResponse response = this.client.followUser(session, username, "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response unfollowUser(String username) {
        try {
            StringResponse response = this.client.unfollowUser(session, username);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response fetchFollowing(String username) {
        try {
            SuccessResponse response = this.client.fetchFollowing(session, username);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response fetchFollowers(String username) {
        try {
            SuccessResponse response = this.client.fetchFollowers(session, username);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response enablePushNotification(String os, String token) {
        try {
            StringResponse response = this.client.enablePushNotification(session, os, token, "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response disablePushNotification(String token) {
        try {
            StringResponse response = this.client.disablePushNotification(session, token, "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response sendPushNotification(SendPushNotificationRequest request) {
        try {
            SendPushNotificationJson json = new SendPushNotificationJson();
            json.setActionLocalizedKey(request.getActionLocalizedKey());
            json.setBadge(request.getBadge());
            json.setCategory(request.getCategory());
            json.setCollapseKey(request.getCollapseKey());
            json.setContentAvailable(request.getContentAvailable());
            json.setLocalizedKey(request.getLocalizedKey());
            json.setMessage(request.getMessage());
            json.setSound(request.getSound());
            json.setTimeToLive(request.getTimeToLive());
            if (request.getLocalizedArguments() != null && !request.getLocalizedArguments().isEmpty()) {
                json.setLocalizedArguments(request.getLocalizedArguments());
            }
            if (request.getProfiles() != null && !request.getProfiles().isEmpty()) {
                json.setProfiles(request.getProfiles());
            }
            if (request.getUsers() != null && !request.getUsers().isEmpty()) {
                json.setUsers(request.getUsers());
            }
            if (request.getCustom() != null && !request.getCustom().isEmpty()) {
                json.setCustom(request.getCustom());
            }
            StringResponse response = this.client.sendPushNotification(session, json);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response createNewCollection(String collection) {
        try {
            StringResponse response = this.client.createNewCollection(session, collection, "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response deleteCollection(String collection) {
        try {
            StringResponse response = this.client.deleteCollection(session, collection);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response createDocument(String collection, Map<String, Object> document) {
        try {
            SuccessResponse response = this.client.createDocument(session, collection, document);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveDocumentById(String collection, String id) {
        try {
            SuccessResponse response = this.client.retrieveDocumentById(session, collection, id);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveDocumentByQuery(String collection) {
        try {
            SuccessResponse response = this.client.retrieveDocumentByQuery(session, collection);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response countDocument(String collection) {
        try {
            SuccessResponse response = this.client.countDocument(session, collection);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response modifyDocument(String collection, String id, Map<String, Object> document) {
        try {
            SuccessResponse response = this.client.modifyDocument(session, collection, id, document);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response updateDocumentField(String collection, String id, String field, Object data) {
        try {
            SuccessResponse response = this.client.updateDocumentField(session, collection, id, field, data);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response deleteDocument(String collection, String id) {
        try {
            StringResponse response = this.client.deleteDocument(session, collection, id);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response grantPermissionsDocument(UsernamePermissionsDocumentRequest request) {
        try {
            StringResponse response = this.client.grantPermissionsDocumentUsername(session, request.getCollection(), request.getId(), request.getAction(), request.getUsername(), "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response grantPermissionsDocument(RoleNamePermissionsDocumentRequest request) {
        try {
            StringResponse response = this.client.grantPermissionsDocumentRoleName(session, request.getCollection(), request.getId(), request.getAction(), request.getRolename(), "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response revokePermissionsDocument(UsernamePermissionsDocumentRequest request) {
        try {
            StringResponse response = this.client.revokePermissionsDocumentUsername(session, request.getCollection(), request.getId(), request.getAction(), request.getUsername());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response revokePermissionsDocument(RoleNamePermissionsDocumentRequest request) {
        try {
            StringResponse response = this.client.revokePermissionsDocumentRoleName(session, request.getCollection(), request.getId(), request.getAction(), request.getRolename());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response createLink(CreateLinkRequest request) {
        try {
            if (appCode != null && !"".equals(appCode) && session != null && !"".equals(session)) {
                SuccessResponse response = this.client.createLink(appCode, session, request.getSourceId(), request.getLabel(), request.getDestinationId(), "mock");
                return response;
            }
            if (session != null && !"".equals(session)) {
                SuccessResponse response = this.client.createLink(session, request.getSourceId(), request.getLabel(), request.getDestinationId(), "mock");
                return response;
            }
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Response retrieveLink(String id) {
        try {
            SuccessResponse response = this.client.retrieveLink(appCode, session, id);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveLink() {
        try {
            SuccessResponse response = this.client.retrieveLink(appCode, session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response deleteLink(String id) {
        try {
            StringResponse response = this.client.deleteLink(appCode, session, id);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response uploadFile(File file, Map<String, Object> attachedData, Map<String, Object> acl) {
        try {
            String mineType = URLConnection.guessContentTypeFromName(file.getAbsolutePath());
            String jsonAttachedData = null;
            if (attachedData != null && !attachedData.isEmpty()) {
                jsonAttachedData = gson.toJson(attachedData);
            }
            String jsonAcl = null;
            if (acl != null && !acl.isEmpty()) {
                jsonAcl = gson.toJson(acl);
            }
            SuccessResponse response = this.client.uploadFile(session, new TypedFile(mineType, file), jsonAttachedData, jsonAcl);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response deleteFile(String id) {
        try {
            StringResponse response = this.client.deleteFile(session, id);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveFile(String id) {
        try {
            retrofit.client.Response resp = this.client.retrieveFile(session, id);
            SuccessResponse response = new SuccessResponse();
            response.setData(new LinkedHashMap<>());
            long length = resp.getBody().length();
            response.getData().put("length", length);
            response.getData().put("mimeType", resp.getBody().mimeType());
            try {
                byte[] content = IOUtils.toByteArray(resp.getBody().in());
                response.getData().put("content", content);
                if (length == -1) {
                    response.getData().put("length", content.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.setHttpCode(resp.getStatus());
            response.setResult(resp.getReason());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveFileDetail(String id) {
        try {
            SuccessResponse response = this.client.retrieveFileDetail(session, id);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveFilesDetail() {
        try {
            SuccessResponse response = this.client.retrieveFilesDetail(session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response grantFileAccess(UsernameFileAccessRequest request) {
        try {
            StringResponse response = this.client.grantFileAccessUsername(session, request.getId(), request.getAction(), request.getUsername(), "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response grantFileAccess(RoleNameFileAccessRequest request) {
        try {
            StringResponse response = this.client.grantFileAccessRoleName(session, request.getId(), request.getAction(), request.getRolename(), "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response revokeFileAccess(UsernameFileAccessRequest request) {
        try {
            StringResponse response = this.client.revokeFileAccessUsername(session, request.getId(), request.getAction(), request.getUsername());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response revokeFileAccess(RoleNameFileAccessRequest request) {
        try {
            StringResponse response = this.client.revokeFileAccessRoleName(session, request.getId(), request.getAction(), request.getRolename());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response createAsset(String name, Map<String, Object> meta, File file) {
        try {
            String mineType = URLConnection.guessContentTypeFromName(file.getAbsolutePath());
            String jsonMeta = null;
            if (meta != null && !meta.isEmpty()) {
                jsonMeta = gson.toJson(meta);
            }
            SuccessResponse response = this.client.createAsset(session, name, jsonMeta, new TypedFile(mineType, file));
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response retrieveAsset(String name) {
        try {
            retrofit.client.Response resp = this.client.retrieveAsset(appCode, name);
            SuccessResponse response = new SuccessResponse();
            response.setData(new LinkedHashMap<String, Object>());
            long length = resp.getBody().length();
            response.getData().put("length", length);
            response.getData().put("mimeType", resp.getBody().mimeType());
            try {
                byte[] content = IOUtils.toByteArray(resp.getBody().in());
                response.getData().put("content", content);
                if (length == -1) {
                    response.getData().put("length", content.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.setHttpCode(resp.getStatus());
            response.setResult(resp.getReason());
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response deleteAsset(String name) {
        try {
            StringResponse response = this.client.deleteAsset(session, name);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response fetchAsset() {
        try {
            SuccessResponse response = this.client.fetchAsset(session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response fetchCurrentSetting() {
        try {
            SuccessResponse response = this.client.fetchCurrentSetting(appCode, session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response fetchSectionSetting(String section) {
        try {
            SuccessResponse response = this.client.fetchSectionSetting(appCode, session, section);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response updateValueSetting(String section, String key, String value) {
        try {
            StringResponse response = this.client.updateValueSetting(appCode, session, section, key, value, "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response listGroup() {
        try {
            SuccessResponse response = this.client.listGroup(appCode, session);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response readSpecificGroup(String name) {
        try {
            SuccessResponse response = this.client.readSpecificGroup(appCode, session, name);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response enableEndpointGroup(String name) {
        try {
            StringResponse response = this.client.enableEndpointGroup(appCode, session, name, "mock");
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Response disableEndpointGroup(String name) {
        try {
            StringResponse response = this.client.disableEndpointGroup(appCode, session, name);
            return response;
        } catch (RetrofitError error) {
            System.out.println(error.getMessage());
            try {
                ErrorResponse response = gson.fromJson(IOUtils.toString(error.getResponse().getBody().in()), ErrorResponse.class);
                response.setHttpCode(error.getResponse().getStatus());
                response.setResult(error.getResponse().getReason());
                return response;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}