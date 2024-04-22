package test.ifabula.contant;

import test.ifabula.exception.BusinessException;

public final class Endpoint {

    private Endpoint() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String BASE_ENDPOINT = "/api";
    public static final String AUTH = BASE_ENDPOINT + "/auth";
}
