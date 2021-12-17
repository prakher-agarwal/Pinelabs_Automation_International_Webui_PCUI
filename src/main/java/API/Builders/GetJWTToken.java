package API.Builders;

import API.Base.BaseUtilsAPI;
import Constants.EnumsRepo;
import API.PojoFiles.GetJWTRequest;
import API.PojoFiles.GetJWTResponse;
import Constants.URI;
import io.restassured.response.Response;



public class GetJWTToken extends BaseUtilsAPI {

    private static GetJWTToken getJWTToken;
    GetJWTRequest getJwtTokenRequest;
    GetJWTResponse getJWTResponse;
    public static String defaultrequest = "{\"hardwareid\":\"0821397985\",\"Devicesubtype\":\"82\"}";
    String request;

    private GetJWTToken(String request) {
        this.request = request;
        getJwtTokenRequest = stringToJavaObject(this.request, GetJWTRequest.class);
    }

    public static GetJWTToken getInstance(String request) {
        if (getJWTToken == null)
            getJWTToken = new GetJWTToken(request);
        return getJWTToken;

    }


    public GetJWTResponse createAndExecute() {
        request = javaObjectToString(getJwtTokenRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.getJwtToken, URI.baseURL);
        getJWTResponse = stringToJavaObject(response.asString(), GetJWTResponse.class);
        return getJWTResponse;
    }

    public GetJWTResponse getResponse() {
        return getJWTResponse;
    }

    public GetJWTRequest getRequest() {
        return getJwtTokenRequest;
    }
}
