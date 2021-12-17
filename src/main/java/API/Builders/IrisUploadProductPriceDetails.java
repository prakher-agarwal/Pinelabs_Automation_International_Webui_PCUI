package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUploadProductPriceDetailsRequest;
import API.PojoFiles.IrisUploadProductPriceDetailsResponse;
import API.PojoFiles.IrisUploadShiftDetailsRequest;
import Constants.EnumsRepo;
import Constants.URI;
import io.restassured.response.Response;

public class IrisUploadProductPriceDetails extends BaseUtilsAPI {
    static IrisUploadProductPriceDetails irisUploadProductPriceDetails;
    IrisUploadProductPriceDetailsRequest irisUploadProductPriceDetailsRequest;
    IrisUploadProductPriceDetailsResponse irisUploadProductPriceDetailsResponse;
    public static String defaultRequest = "{\"HardwareId\":\"0821397407\",\"ProductNumber\":1234,\"ProductPrice\":500,\"ROid\":180664,\"PriceUpdateDateTime\":\"2021-04-22 20:35:41\"}";
    String request;

    private IrisUploadProductPriceDetails(String request) {
        this.request = request;
        irisUploadProductPriceDetailsRequest = stringToJavaObject(this.request, IrisUploadProductPriceDetailsRequest.class);
    }

    public static IrisUploadProductPriceDetails getInstance(String request) {
        if (irisUploadProductPriceDetails == null)
            irisUploadProductPriceDetails = new IrisUploadProductPriceDetails(request);
        return irisUploadProductPriceDetails;
    }


    public IrisUploadProductPriceDetailsResponse createAndExecute(String token) {
        request = javaObjectToString(irisUploadProductPriceDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.irisUploadProductPriceDetails, URI.baseURL, token);
        irisUploadProductPriceDetailsResponse = stringToJavaObject(response.asString(), IrisUploadProductPriceDetailsResponse.class);
        return irisUploadProductPriceDetailsResponse;
    }

    public IrisUploadProductPriceDetailsResponse getResponse() {
        return irisUploadProductPriceDetailsResponse;
    }

    public IrisUploadProductPriceDetailsRequest getRequest() {
        return irisUploadProductPriceDetailsRequest;
    }
}
