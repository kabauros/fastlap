package com.race.fastlap.repository;

import com.race.fastlap.vo.LapVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

@Repository
public class LapRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class LapRowMapper implements RowMapper<LapVO> {

        @Override
        public LapVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            LapVO lap = new LapVO();
            lap.setId(rs.getLong("id"));
            lap.setHora(rs.getString("hora"));
            lap.setPiloto(rs.getString("piloto"));
            lap.setNumeroVolta(rs.getInt("numero_volta"));
            lap.setTempoVolta(rs.getLong("tempo_volta"));
            lap.setVelocMediaVolta(rs.getFloat("veloc_media_volta"));
            return lap;
        }
    }

    public int insert(LapVO lap) throws ParseException {
        return jdbcTemplate.update("insert into laps (id, hora, piloto, numero_volta, tempo_volta, veloc_media_volta) " + "values(?, ?, ?, ?, ?, ?)",
                new Object[] {lap.getId(), lap.getHora(), lap.getPiloto(), lap.getNumeroVolta(), lap.getTempoVolta(), lap.getVelocMediaVolta()});
    }


}
