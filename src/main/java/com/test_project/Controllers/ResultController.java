package com.test_project.Controllers;

import com.test_project.Dto.ResultDto;
import com.test_project.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping("/student/{studentId}/result")
    public ResponseEntity<ResultDto> addResult(@RequestBody ResultDto resultDto, @PathVariable(value = "studentId") Long studentId) {
        ResultDto result = resultService.addAResult(resultDto, studentId);
        return (new ResponseEntity<>(result, HttpStatus.CREATED));
    }

    @GetMapping("/getResults")
    public ResponseEntity<List<ResultDto>> getAllResults() {
        List<ResultDto> resultDto = resultService.getAllResults();
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

}
