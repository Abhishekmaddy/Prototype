package main.java.enums;

public enum TokenScopetype {

    INTERNAL_SERVICES("internal_services"),
    USER_JOURNEY("user_journey"),
    UTS_TOKEN("merchant_api  merchant_api_sensitive"),
    UTS_UJT_TOKEN("my_accounts user_journey openid"),
    CL_ACTIVATION_TOKEN("cl-activation"),
    ROUTING_MERCHANT_CL_ALLOCATION("onboarding_cl_allocation");

    public final String label;

    private TokenScopetype(String label) {
        this.label = label;
    }
}