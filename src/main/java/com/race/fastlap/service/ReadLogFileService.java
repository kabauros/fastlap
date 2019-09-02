package com.race.fastlap.service;

import com.race.fastlap.vo.LapVO;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReadLogFileService {

    public List<LapVO> readLog() throws IOException, ParseException {

        BufferedReader readFile = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/main/resources/log.txt"), Charset.defaultCharset()
                )
        );

        String line = readFile.readLine();
        line = readFile.readLine();
        List<LapVO> laps = new ArrayList<LapVO>();

        while (line != null) {
            LapVO lap = new LapVO();

            lap.setHora(line.substring(0, 14).trim());
            lap.setPiloto(line.substring(16, 39).trim());
            lap.setNumeroVolta(Integer.parseInt(line.substring(40, 50).trim()));
            lap.setTempoVolta(getTime(line.substring(51, 65).trim()));
            lap.setVelocMediaVolta(Float.parseFloat(line.substring(66, line.length()).trim().replace(",", ".")));
            laps.add(lap);

            line = readFile.readLine();
        }
        return laps;
    }

    private Long getTime (String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = sdf.parse("1970-01-01 00: " + time);
        return date.getTime();
    }
}