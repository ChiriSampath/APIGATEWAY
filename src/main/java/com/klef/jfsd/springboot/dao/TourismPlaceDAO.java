package com.klef.jfsd.springboot.dao;

package com.klef.jfsd.springboot.dao;

import com.example.touristhomestayapp.model.TourismPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TourismPlaceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper to map each row of the result set to a TourismPlace object
    private static class TourismPlaceRowMapper implements RowMapper<TourismPlace> {
        @Override
        public TourismPlace mapRow(ResultSet rs, int rowNum) throws SQLException {
            TourismPlace tourismPlace = new TourismPlace();
            tourismPlace.setId(rs.getLong("id"));
            tourismPlace.setName(rs.getString("name"));
            tourismPlace.setLocation(rs.getString("location"));
            tourismPlace.setDescription(rs.getString("description"));
            tourismPlace.setEntryFee(rs.getDouble("entry_fee"));
            return tourismPlace;
        }
    }

    // Retrieve all tourism places
    public List<TourismPlace> findAll() {
        String sql = "SELECT * FROM tourism_places";
        return jdbcTemplate.query(sql, new TourismPlaceRowMapper());
    }

    // Retrieve a tourism place by ID
    public TourismPlace findById(Long id) {
        String sql = "SELECT * FROM tourism_places WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TourismPlaceRowMapper());
    }

    // Save a new tourism place
    public void save(TourismPlace tourismPlace) {
        String sql = "INSERT INTO tourism_places (name, location, description, entry_fee) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, tourismPlace.getName(), tourismPlace.getLocation(), tourismPlace.getDescription(), tourismPlace.getEntryFee());
    }

    // Update an existing tourism place
    public void update(TourismPlace tourismPlace) {
        String sql = "UPDATE tourism_places SET name = ?, location = ?, description = ?, entry_fee = ? WHERE id = ?";
        jdbcTemplate.update(sql, tourismPlace.getName(), tourismPlace.getLocation(), tourismPlace.getDescription(), tourismPlace.getEntryFee(), tourismPlace.getId());
    }

    // Delete a tourism place by ID
    public void delete(Long id) {
        String sql = "DELETE FROM tourism_places WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
