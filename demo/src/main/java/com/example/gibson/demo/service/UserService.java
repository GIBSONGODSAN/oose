package com.example.gibson.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gibson.demo.model.Records;
import com.example.gibson.demo.repository.RecordRepository;

@Service
public class UserService {

    @Autowired
    private RecordRepository recordRepository;

    public void saveRecord(String value1, String value2, int value3) {
        recordRepository.save(new Records(value1, value2, value3));
    }

    public Records getRecordByValue1(String value1) {
        return recordRepository.findByValue1(value1);
    }

    public void deleteRecordByValue1(String value1) {
        Records record = recordRepository.findByValue1(value1);
        recordRepository.delete(record);
    }

    public void updateRecord(String value1, String value2, int value3) {
        Records record = recordRepository.findByValue1(value1);
        record.setValue2(value2);
        record.setValue3(value3);
        recordRepository.save(record);
    }

}
