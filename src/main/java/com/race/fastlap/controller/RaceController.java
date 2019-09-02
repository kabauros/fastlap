package com.race.fastlap.controller;

import com.race.fastlap.service.RaceClassificationService;
import com.race.fastlap.vo.RaceResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class RaceController {
     @Autowired
     public RaceClassificationService raceClassificationService;


    @RequestMapping(value = "/race/log", produces = APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public String loadLog() {
        raceClassificationService.loadLog();
        return "Log Carregado com sucesso !!!";

    }

    @RequestMapping(value = "/race/all", produces = APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public List<RaceResultVO> listAll() {

        return raceClassificationService.getResult();
    }
}
