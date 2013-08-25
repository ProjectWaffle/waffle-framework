package framework.api.response;

import java.io.Serializable;

import framework.core.constants.ApplicationStatus;

public class ServiceResponseBuilder<T> implements Serializable {

    private static final long serialVersionUID = 6197368273382015514L;
    private ApplicationStatus applicationStatus;
    private T result;
    private String token;

    ServiceResponseBuilder() {

    }

    public ServiceResponse<T> build() {
        final ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setStatusCode(this.applicationStatus.getCode());
        responseHeader.setStatusMessage(this.applicationStatus.getMessage());
        responseHeader.setToken(this.token);
        return new ServiceResponse<T>(responseHeader, this.result);
    }

    /**
     * @param result
     *            the result to set
     */
    public ServiceResponseBuilder<T> result(T result) {
        this.result = result;
        return this;
    }

    /**
     * @param result
     *            the result to set
     */
    public ServiceResponseBuilder<T> status(ApplicationStatus status) {
        this.applicationStatus = status;
        return this;
    }

    /**
     * @param result
     *            the result to set
     */
    public ServiceResponseBuilder<T> token(String token) {
        this.token = token;
        return this;
    }

}
