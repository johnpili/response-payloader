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
	 * Primarily intended for list result with pagination payloads
	 * @param success
	 * @param result
	 * @param total
	 * @param <T>
	 * @return
	 */
	<T> String generate(boolean success, T result, long total) throws JsonProcessingException;

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
}
