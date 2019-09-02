package com.race.fastlap.repository;

import com.race.fastlap.vo.RaceResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RaceResultRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class RaceResultRowMapper implements RowMapper<RaceResultVO> {

        @Override
        public RaceResultVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            RaceResultVO rr = new RaceResultVO();
            rr.setPiloto(rs.getString("piloto"));
            rr.setTempoTotal(rs.getLong("tempo_total"));
            rr.setQtdVoltas(rs.getInt("qtd_voltas"));
            rr.setMelhorVolta(rs.getLong("melhor_volta"));
            rr.setVelocMediaCorrida(rs.getFloat("velocidade_media"));
            return rr;
        }
    }

    public List<RaceResultVO> getResult() {
        return jdbcTemplate.query("select \n" +
                " piloto, \n" +
                " sum(tempo_volta) as tempo_total, \n" +
                " max(numero_volta) as qtd_voltas, \n" +
                " min(tempo_volta) as melhor_volta, \n" +
                " avg(veloc_media_volta ) as velocidade_media \n" +
                "from laps \n" +
                "group by piloto \n" +
                "order by  tempo_total", new RaceResultRepository.RaceResultRowMapper());
    }

}
