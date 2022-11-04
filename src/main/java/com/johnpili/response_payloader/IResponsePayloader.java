package com.johnpili.response_payloader;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * @author John Pilli
 * @since 2018-10-01
 */

public interface IResponsePayloader
{
	/**
	 * The basic response payload
	 * @param success
	 * @param result
	 * @param <T>
	 * @return
	 */
	<T> String generate(boolean success, T result) throws JsonProcessingException;

	/**
	 * Response payload with single error string
	 * @param success
	 * @param result
	 * @param error
	 * @param <T>
	 * @return
	 */
	<T> String generate(boolean success, T result, String error) throws JsonProcessingException;

	/**
	 * Response payload with list errors
	 * @param success
	 * @param result
	 * @param errors
	 * @param <T>
	 * @return
	 */
	<T> String generate(boolean success, T result, List<String> errors) throws JsonProcessingException;

	/**
	 * The basic response payload with prettify
	 * @param success
	 * @param result
	 * @param prettify
	 * @param <T>
	 * @return
	 * @throws JsonProcessingException
	 */
	<T> String generate(boolean success, T result, boolean prettify) throws JsonProcessingException;

	/**
	 * Response payload with single error string with prettify
	 * @param success
	 * @param result
	 * @param error
	 * @param prettify
	 * @param <T>
	 * @return
	 * @throws JsonProcessingException
	 */
	<T> String generate(boolean success, T result, String error, boolean prettify) throws JsonProcessingException;

	/**
	 * Response payload with list errors with prettify
	 * @param success
	 * @param result
	 * @param errors
	 * @param prettify
	 * @param <T>
	 * @return
	 * @throws JsonProcessingException
	 */
	<T> String generate(boolean success, T result, List<String> errors, boolean prettify) throws JsonProcessingException;

	<T> String jsonify(T obj) throws JsonProcessingException;

	<T> String jsonify(T obj, boolean prettify) throws JsonProcessingException;
}
