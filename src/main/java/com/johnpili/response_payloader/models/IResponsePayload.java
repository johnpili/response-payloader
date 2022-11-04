package com.johnpili.response_payloader.models;

import java.util.List;

/**
 * @param <T>
 * @author John Pilli
 * @since 2019-10-09
 */

public interface IResponsePayload<T> {
    String getReference();

    void setReference(String reference);

    T getResult();

    void setResult(T result);

    List<String> getErrors();

    void setErrors(List<String> errors);

    boolean isSuccess();

    void setSuccess(boolean success);

    void setTimestamp(long epoch);

    long getTimestamp();
}
