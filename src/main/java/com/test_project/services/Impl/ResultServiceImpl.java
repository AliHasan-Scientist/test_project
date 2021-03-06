package com.test_project.services.Impl;

import com.test_project.dto.ResultDto;
import com.test_project.entities.Result;
import com.test_project.entities.Student;
import com.test_project.repository.ResultRepository;
import com.test_project.repository.StudentRepository;
import com.test_project.services.ResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResultDto addAResult(ResultDto resultDto, Long studentId) {
        Student student = this.studentRepository.findById(studentId).orElseThrow(null);
        Result result = dtoToResult(resultDto);
        result.setStudent(student);
        Result savedResult = resultRepository.save(result);
        return this.resultToDto(savedResult);
    }


    @Override
    public List<ResultDto> getAllResults() {
        List<Result> results = this.resultRepository.findAll();
        return results.stream().map(this::resultToDto).collect(Collectors.toList());
    }

    @Override
    public ResultDto getResultWithId(Long resultId) {
        return null;
    }

    @Override
    public ResultDto updateResult(Long resultId) {


        return null;
    }

    @Override
    public void deleteResult(Long resultId) {

    }

    //Model Mapper
    private Result dtoToResult(ResultDto resultDto) {
        return this.modelMapper.map(resultDto, Result.class);
    }

    public ResultDto resultToDto(Result result) {
        return this.modelMapper.map(result, ResultDto.class);
    }
}
