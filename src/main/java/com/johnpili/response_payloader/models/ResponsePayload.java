package com.johnpili.response_payloader.models;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResponsePayload<T> implements IResponsePayload<T>
{
	private String reference; // USED FOR REFERENCE TOKEN OR UUID
	private long total;
	private T result;
	private List<String> errors; // ERROR MESSAGES
	private boolean success;
	private long timestamp;

	public ResponsePayload()
	{
		this.total = 0;
		this.reference = UUID.randomUUID().toString();
		this.errors = new ArrayList<>();
		this.timestamp = new DateTime().getMillis();
	}

	public ResponsePayload(boolean success, T result, String reference, List<String> errors)
	{
		this.total = 0;
		this.reference = (reference == null || reference.isEmpty()) ? UUID.randomUUID().toString() : reference;
		this.success = success;
		this.result = result;
		this.errors = errors;
		this.timestamp = new DateTime().getMillis();
	}

	@Override
	public String getReference()
	{
		return this.reference;
	}

	@Override
	public void setReference(String reference)
	{
		this.reference = reference;
	}

	@Override
	public long getTotal()
	{
		return this.total;
	}

	@Override
	public void setTotal(long total)
	{
		this.total = total;
	}

	@Override
	public T getResult()
	{
		return this.result;
	}

	@Override
	public void setResult(T result)
	{
		this.result = result;
	}

	@Override
	public List<String> getErrors()
	{
		return this.errors;
	}

	@Override
	public void setErrors(List<String> errors)
	{
		this.errors = errors;
	}

	@Override
	public boolean isSuccess()
	{
		return this.success;
	}

	@Override
	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	@Override
	public void setTimestamp(long epoch)
	{
		this.timestamp = epoch;
	}

	@Override
	public long getTimestamp()
	{
		return this.timestamp;
	}
}
