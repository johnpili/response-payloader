package com.johnpili.response_payloader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnpili.response_payloader.models.IResponsePayload;
import com.johnpili.response_payloader.models.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

public class ResponsePayloader implements IResponsePayloader
{
	private ObjectMapper objectMapper;

	public ResponsePayloader(ObjectMapper objectMapper)
	{
		this.objectMapper = objectMapper;
	}

	@Override
	public <T> String generate(boolean success, T result) throws JsonProcessingException
	{
		IResponsePayload<T> responsePayload = new ResponsePayload<>(success, result, null, new ArrayList<>());
		return objectMapper.writeValueAsString(responsePayload);
	}

	@Override
	public <T> String generate(boolean success, T result, long total) throws JsonProcessingException
	{
		IResponsePayload<T> responsePayload = new ResponsePayload<>(success, result, null, new ArrayList<>());
		responsePayload.setTotal(total);
		return objectMapper.writeValueAsString(responsePayload);
	}

	@Override
	public <T> String generate(boolean success, T result, String error) throws JsonProcessingException
	{
		List<String> errors = new ArrayList<>();
		errors.add(error);

		ResponsePayload<T> responsePayload = new ResponsePayload<>(
				success, result, null, errors);
		return objectMapper.writeValueAsString(responsePayload);
	}

	@Override
	public <T> String generate(boolean success, T result, List<String> errors) throws JsonProcessingException
	{
		ResponsePayload<T> responsePayload = new ResponsePayload<>(
				success, result, null, errors);
		return objectMapper.writeValueAsString(responsePayload);
	}
}
