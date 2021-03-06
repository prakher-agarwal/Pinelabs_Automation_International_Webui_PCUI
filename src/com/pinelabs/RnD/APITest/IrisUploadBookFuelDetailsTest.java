package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisUploadBookFuelDetails;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadBookFuelDetailsTest {
   //Ready
    @Test
    public void bookFuel_TC001() {
        IrisUploadBookFuelDetails irisUploadBookFuelDetails = IrisUploadBookFuelDetails.getInstance(IrisUploadBookFuelDetails.defaultRequest);
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0820686904",  GetJWTToken.defaultrequest);
        irisUploadBookFuelDetails.getRequestPojo().setHardwareId("0820686904");
        irisUploadBookFuelDetails.getRequestPojo().setRoid(180664);
        irisUploadBookFuelDetails.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(irisUploadBookFuelDetails.getResponsePojo().getResMsg(),"Transaction Successfully Booked");

    }
}
