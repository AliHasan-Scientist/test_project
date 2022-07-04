package com.test_project.Services.Impl;

import com.test_project.Dto.ResultCardDto;
import com.test_project.Entities.Result;
import com.test_project.Entities.ResultCard;
import com.test_project.Entities.Student;
import com.test_project.Repository.ResultCardRepository;
import com.test_project.Repository.ResultRepository;
import com.test_project.Repository.StudentRepository;
import com.test_project.Services.ResultCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResultCardServiceImpl implements ResultCardService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private ResultCardRepository resultCardRepository;

    public ResultCard createAResultCard(Long studentId, Long resultId, ResultCard resultCard) {
        Student student = studentRepository.findById(studentId).orElseThrow(null);
        Result result = resultRepository.findById(resultId).orElseThrow(null);

        resultCard.setStudent(student);
        resultCard.setResult(result);
        resultCard.setAnnouncedDate(new Date());

        return resultCardRepository.save(resultCard);
    }

    @Override
    public List<ResultCard> getAllResultCards() {
        return resultCardRepository.findAll();

    }


    @Override
    public List<ResultCard> findByUniversityNameAndStudentFirstName(String universityName, String student_firstName) {
        return resultCardRepository.findByUniversityNameAndStudentFirstName(universityName, student_firstName);
    }

    // Model Mapper
    private ResultCard dtoToResultCard(ResultCardDto resultCardDto) {
        return this.modelMapper.map(resultCardDto, ResultCard.class);
    }

    public ResultCardDto resultCardToDto(ResultCard resultCard) {
        return this.modelMapper.map(resultCard, ResultCardDto.class);
    }
}

