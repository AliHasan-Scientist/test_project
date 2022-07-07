package com.test_project.controllers;

import com.test_project.entities.ResultCard;
import com.test_project.services.ResultCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class ResultCardController {


    @Autowired
    private ResultCardService resultCardService;

    @PostMapping(path = "/student/{studentId}/result/{resultId}/resultCard", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultCard> addResult(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "resultId") Long resultId, @RequestBody ResultCard resultCard) {
        ResultCard resultCard1 = resultCardService.createAResultCard(studentId, resultId, resultCard);
        return (new ResponseEntity<>(resultCard1, HttpStatus.CREATED));
    }

    @GetMapping("/getResultCard")
    public ResponseEntity<List<ResultCard>> getAllResultCards() {
        List<ResultCard> resultCard = resultCardService.getAllResultCards();
        return new ResponseEntity<>(resultCard, HttpStatus.OK);
    }

    @GetMapping("/getResultCard/uniName/{uniName}/{fName}")
    public ResponseEntity<List<ResultCard>> findResultCardByUniversityName(@PathVariable(value = "uniName") String uniName, @PathVariable(value = "fName") String fName) {
        List<ResultCard> resultCard = resultCardService.findByUniversityNameAndStudentFirstName(uniName, fName);
        return new ResponseEntity<>(resultCard, HttpStatus.OK);
    }


}
