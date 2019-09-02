package com.race.fastlap.service;

import com.race.fastlap.repository.LapRepository;
import com.race.fastlap.repository.RaceResultRepository;
import com.race.fastlap.vo.LapVO;
import com.race.fastlap.vo.RaceResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Service
public class RaceClassificationService {

    @Autowired
    public ReadLogFileService readLogFileService;

    @Autowired
    public LapRepository lapRepository;

    @Autowired
    public RaceResultRepository raceResultRepository;

    public void loadLog(){
        try {
            List<LapVO> laps = readLogFileService.readLog();

            for(LapVO lap : laps){
                lapRepository.insert(lap);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public List<RaceResultVO> getResult (){

        List<RaceResultVO> resultList = raceResultRepository.getResult();
        int position = 0;
        Long bestLap = resultList.get(0).getTempoTotal();

        for(RaceResultVO result: resultList){
            result.setPosicao(++position);
            result.setTempoTotalFormated(getTimeFormated(result.getTempoTotal()));
            result.setMelhorVoltaFormated(getTimeFormated(result.getMelhorVolta()));
            result.setDiferencaTempo("+ " + getTimeFormated(result.getTempoTotal() -bestLap));
        }
        return resultList;
    }

    private String getTimeFormated(Long milis){
        int minutes = (int) (milis /(1000 * 60));
        int seconds = (int) (milis / 1000 % 60);
        int millis  = (int) (milis % 1000);
        return String.format("%02d:%02d.%03d", minutes, seconds, millis);
    }

}
