package com.kevinjanvier.interview.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinjanvier.interview.data.RequestData;
import com.kevinjanvier.interview.data.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kevinjanvier.interview.utils.Util.listFromPost;

/**
 * DataController class handles HTTP requests for managing and retrieving a list of integers.
 * It provides endpoints to post a list of integers and retrieve a sorted list of these integers.
 */
@RestController
public class DataController {

    // List to store integers
    private List<Integer> numbers = new ArrayList<>();

    // ObjectMapper instance to handle JSON operations
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Handles POST requests to "/data".
     * Accepts a list of exactly 500 integers, validates the input, and stores the list.
     *
     * @param inputNumbers Request body containing a list of integers
     * @return ResponseEntity containing a ResponseData object with status message
     */
    @PostMapping("/data")
    public ResponseEntity<ResponseData> postRandomData(
            @RequestBody RequestData inputNumbers) {

        // Validate that the list contains exactly 500 integers
        if (inputNumbers.getNumbers().size() != 500) {
            return new ResponseEntity<>(
                    new ResponseData("The List must contain exactly 500 numbers"),
                    HttpStatus.BAD_REQUEST);
        }

        // Validate that all elements in the list are integers
        for (Integer number : inputNumbers.getNumbers()) {
            if (number == null) {
                return new ResponseEntity<>(
                        new ResponseData("The List must contain only integers"),
                        HttpStatus.BAD_REQUEST);
            }
        }

        // Store the list of integers
        this.numbers = new ArrayList<>(inputNumbers.getNumbers());
        var response = new ResponseData(numbers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to "/data".
     * Retrieves the stored list of integers, sorts it, and returns it.
     *
     * @return ResponseEntity containing the sorted list of integers
     * @throws IOException if an I/O error occurs
     */
    @GetMapping("/data")
    public ResponseEntity<List<Integer>> getData() throws IOException {
        // Retrieve the list of integers from a utility method
        var sortedNumbers = listFromPost(objectMapper);
        System.out.println("Reading numbers :: " + sortedNumbers);

        // Sort the list of integers
        Collections.sort(sortedNumbers);

        // Return the sorted list
        return new ResponseEntity<>(sortedNumbers, HttpStatus.OK);
    }
}