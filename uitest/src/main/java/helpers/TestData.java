package helpers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestData {

    private JSONObject requestData;

    private JSONArray shipmentsOrOrders = null;

    public TestData(String customerCode) {

        Path jsonPath;
        Path jsonPathShipmentOrder;
        try {
            if (Constants.CUSTOMER_BEVIL01.equals(customerCode)) {
                jsonPath = Paths.get("ui-test/src/main/resources/testing_data_basic_request_info_cat.json");
                if (CommonSetup.config.env().equals("sys")) {
                    jsonPathShipmentOrder = Paths.get("ui-test/src/main/resources/sys/shipment_order.json");
                } else {
                    jsonPathShipmentOrder = Paths.get("ui-test/src/main/resources/int/shipment_order.json");
                }
                shipmentsOrOrders = new JSONArray(new String(Files.readAllBytes(jsonPathShipmentOrder)));
            } else
                jsonPath = Paths.get("ui-test/src/main/resources/testing_data_basic_request_info.json");
            requestData = new JSONObject(new String(Files.readAllBytes(jsonPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRequestType() {
        return requestData.getJSONObject("requestType").getString("name");
    }

    public String getDescription() {
        return requestData.getString("description");
    }

    public String getHandler() {
        return requestData.getString("handlerFullName");
    }

    public String get1stInvolvedParty() {
        return requestData.getJSONArray("involvedParties").getJSONObject(0).getString("name");
    }

    public String get2ndInvolvedParty() {
        return requestData.getJSONArray("involvedParties").getJSONObject(1).getString("name");
    }

    public String getRootCauseParty() {
        return requestData.getJSONObject("rootCauseParty").getString("name");
    }

    public String getRootCauseCategory() {
        return requestData.getJSONObject("rootCauseCategory").getString("name");
    }

    public String getHandlerGroup() {
        return requestData.getJSONObject("handlerGroup").getString("name");
    }

    public String getRequestingParty() {
        return requestData.getJSONObject("requestingParty").getString("name");
    }

    public String getPriority() {
        return requestData.getString("priority");
    }

    public String getLcc() {
        return requestData.getString("lcc");
    }

    public String getReasonCodeL1() {
        return requestData.getJSONObject("reasonCodeL1").getString("name");
    }

    public String getReasonCodeL2() {
        return requestData.getJSONObject("reasonCodeL2").getString("name");
    }

    public String getShipmentReference1() {
        return shipmentsOrOrders != null ? shipmentsOrOrders.getJSONObject(0).getString("reference") : null;
    }

    public String getShipmentReference2() {

        return shipmentsOrOrders != null ? shipmentsOrOrders.getJSONObject(3).getString("reference") : null;

    }

    public String getOrderReference1() {

        return shipmentsOrOrders != null ? shipmentsOrOrders.getJSONObject(1).getString("reference") : null;
    }

    public String getOrderReference2() {

        return shipmentsOrOrders != null ? shipmentsOrOrders.getJSONObject(2).getString("reference") : null;

    }
}

