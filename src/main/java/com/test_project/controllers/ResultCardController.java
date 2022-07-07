package com.test_project.controllers;

import com.test_project.dto.ResultCardDto;
import com.test_project.entities.ResultCard;
import com.test_project.services.ResultCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class ResultCardController {


    @Autowired
    private ResultCardService resultCardService;

    @PostMapping("/student/{studentId}/result/{resultId}/resultCard")
    public ResponseEntity<ResultCardDto> addResult(@RequestBody ResultCardDto resultCardDto, @PathVariable(value = "studentId") Long studentId, @PathVariable(value = "resultId") Long resultId) {
        ResultCardDto addResult = resultCardService.createAResultCard(studentId, resultId, resultCardDto);
        return new ResponseEntity<>(addResult, HttpStatus.CREATED);
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
