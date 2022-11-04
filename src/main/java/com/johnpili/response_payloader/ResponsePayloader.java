package com.johnpili.response_payloader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnpili.response_payloader.models.IResponsePayload;
import com.johnpili.response_payloader.models.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

public class ResponsePayloader implements IResponsePayloader {
    private ObjectMapper objectMapper;

    public ResponsePayloader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> String generate(boolean success, T result) throws JsonProcessingException {
        return generate(success, result, false);
    }

    @Override
    public <T> String generate(boolean success, T result, boolean prettify) throws JsonProcessingException {
        IResponsePayload<T> responsePayload = new ResponsePayload<>(success, result, null, new ArrayList<>());
        if (!prettify) {
            return objectMapper.writeValueAsString(responsePayload);
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responsePayload);
    }

    @Override
    public <T> String generate(boolean success, T result, String error) throws JsonProcessingException {
        return generate(success, result, error, false);
    }

    @Override
    public <T> String generate(boolean success, T result, String error, boolean prettify) throws JsonProcessingException {
        List<String> errors = new ArrayList<>();
        errors.add(error);

        ResponsePayload<T> responsePayload = new ResponsePayload<>(
                success, result, null, errors);
        if (!prettify) {
            return objectMapper.writeValueAsString(responsePayload);
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responsePayload);
    }

    @Override
    public <T> String generate(boolean success, T result, List<String> errors) throws JsonProcessingException {
        return generate(success, result, errors, false);
    }

    @Override
    public <T> String generate(boolean success, T result, List<String> errors, boolean prettify) throws JsonProcessingException {
        ResponsePayload<T> responsePayload = new ResponsePayload<>(success, result, null, errors);
        if (!prettify) {
            return objectMapper.writeValueAsString(responsePayload);
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responsePayload);
    }

    @Override
    public <T> String jsonify(T obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    @Override
    public <T> String jsonify(T obj, boolean prettify) throws JsonProcessingException {
        if (!prettify) {
            return jsonify(obj);
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
