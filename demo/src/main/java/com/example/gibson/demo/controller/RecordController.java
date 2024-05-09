package com.example.gibson.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gibson.demo.service.UserService;
import com.example.gibson.demo.model.Records;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/record")
public class RecordController {

    @Autowired
    private UserService userService;

    @GetMapping("/getRecord")
    public String getMethodName(@RequestParam String param) {
        Records record = userService.getRecordByValue1(param);
        return record.getValue1() + " " + record.getValue2() + " " + record.getValue3();
    }
    
    @PostMapping("/saveRecord")
    public void saveRecord(@RequestBody Records record) {
        userService.saveRecord(record.getValue1(), record.getValue2(), record.getValue3());
    }
    
    @PostMapping("/deleteRecord")
    public void deleteRecordByValue1(@RequestParam String param) {
        userService.deleteRecordByValue1(param);
    }

    @PostMapping("/updateRecord")
    public void updateRecord(@RequestParam String param) {
        userService.updateRecord(param, "new value2", 100);
    }
}
