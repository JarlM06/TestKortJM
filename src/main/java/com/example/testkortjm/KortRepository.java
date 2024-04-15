package com.example.testkortjm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KortRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public KortRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createKortstokk() {
        String sql = "CREATE TABLE IF NOT EXISTS Kortstokk (id INT AUTO_INCREMENT PRIMARY KEY)";
        jdbcTemplate.update(sql);
    }


    public void insertKort(String kortstokk_id, Kort kort) {
        String sql = "INSERT INTO " + kortstokk_id + " (type, nummer) VALUES (?, ?)";
        jdbcTemplate.update(sql, kort.getType(), kort.getNummer());
    }

    public List<Kort> getKortstokk(String kortstokkId) {
        String sql = "SELECT * FROM Kort WHERE kortstokk_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Kort.class), kortstokkId);
    }

}