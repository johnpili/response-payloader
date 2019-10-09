package com.johnpili.response_payloader.models;

import java.util.List;

/**
 * @author John Pilli
 * @since 2019-10-09
 * @param <T>
 */

public interface IResponsePayload<T>
{
	String getReference();

	void setReference(String reference);

	long getTotal();

	void setTotal(long total);

	T getResult();

	void setResult(T result);

	List<String> getErrors();

	void setErrors(List<String> errors);

	boolean isSuccess();

	void setSuccess(boolean success);

	void setTimestamp(long epoch);

	long getTimestamp();
}
