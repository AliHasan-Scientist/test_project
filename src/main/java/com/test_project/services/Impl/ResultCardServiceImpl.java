package com.test_project.services.Impl;

import com.test_project.dto.ResultCardDto;
import com.test_project.entities.Result;
import com.test_project.entities.ResultCard;
import com.test_project.entities.Student;
import com.test_project.repository.ResultCardRepository;
import com.test_project.repository.ResultRepository;
import com.test_project.repository.StudentRepository;
import com.test_project.services.ResultCardService;
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
        resultCard.setAnnouncedDate(new Date());
//        resultCard.setResult(result);
//        resultCard.setStudent(student);
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

