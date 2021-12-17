package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUploadShiftDetailsRequest;
import API.PojoFiles.IrisUploadShiftDetailsResponse;
import API.PojoFiles.IrisUploadTransactionDetailsRequest;
import Constants.EnumsRepo;
import Constants.URI;
import io.restassured.response.Response;

public class IrisUploadShiftDetails extends BaseUtilsAPI {
    static IrisUploadShiftDetails irisUploadShiftDetails;
    IrisUploadShiftDetailsRequest irisUploadShiftDetailsRequest;
    IrisUploadShiftDetailsResponse irisUploadShiftDetailsResponse;
    public static String defaultRequest = "{\"HardwareId\":\"0821397407\",\"ShiftStatus\":\"0\",\"ShiftNumber\":1,\"ROid\":180664,\"ShiftStartDateTime\":\"2021-04-22 10:00:00\",\"ShiftEndDateTime\":\"2021-04-22 20:00:00\"}";
    String request;

    private IrisUploadShiftDetails(String request) {
        this.request = request;
        irisUploadShiftDetailsRequest = stringToJavaObject(this.request, IrisUploadShiftDetailsRequest.class);

    }

    public static IrisUploadShiftDetails getInstance(String request) {
        if (irisUploadShiftDetails == null)
            irisUploadShiftDetails = new IrisUploadShiftDetails(request);
        return irisUploadShiftDetails;
    }


    public IrisUploadShiftDetailsResponse createAndExecute(String token) {
        request = javaObjectToString(irisUploadShiftDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.irisUploadShiftDetails, URI.baseURL, token);
        irisUploadShiftDetailsResponse = stringToJavaObject(response.asString(), IrisUploadShiftDetailsResponse.class);
        return irisUploadShiftDetailsResponse;
    }

    public IrisUploadShiftDetailsResponse getResponse() {
        return irisUploadShiftDetailsResponse;
    }

    public IrisUploadShiftDetailsRequest getRequest() {
        return irisUploadShiftDetailsRequest;
    }
}
