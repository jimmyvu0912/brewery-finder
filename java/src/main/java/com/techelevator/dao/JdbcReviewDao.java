package com.techelevator.dao;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.reviewDao;
import com.techelevator.model.Review;

@Component
public class JdbcReviewDao implements reviewDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Review> getReviews(Long beerId){
        List<Review> reviews = new ArrayList<>();
        String sqlGetReviewByBeerId = "SELECT * FROM reviews WHERE beer_id = ? ORDER BY create_date";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetReviewByBeerId, beerId);

        while(results.next()) {
            Review aReview = mapRowToReview(results);
            reviews.add(aReview);
        }
        return reviews;
    }

    @Override
    public void addReview(Review aReview) {
        String sqladdReview = "INSERT INTO reviews (description, rating, beer_id, user_id, name) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sqladdReview, aReview.getDescription(), aReview.getRating(), aReview.getBeerId(),aReview.getUserId(), aReview.getName());
    }

    @Override
    public void saveReview(@Valid Review review) {
        String sqlSaveReview = "INSERT INTO reviews(description, rating, create_date, beer_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(sqlSaveReview, review.getDescription(), review.getRating(),
                review.getCreateTime(), review.getBeerId());

    }

    @Override
    public List<Review> searchReviewsByBeerId(long beerId) {
        List<Review> reviewList = new ArrayList<>();
        String sqlSearchReviewByBeerId = "SELECT * FROM reviews WHERE beer_id = ? ORDER BY create_date";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchReviewByBeerId, beerId);

        while(results.next()){
            reviewList.add(mapRowToReview(results));
        }

        return reviewList;
    }

    private Review mapRowToReview(SqlRowSet row) {
        Review review = new Review();

        review.setName(row.getString("name"));
        review.setDescription(row.getString("description"));
        review.setRating(row.getInt("rating"));
        review.setBeerId(row.getLong("beer_id"));
        review.setUserId(row.getLong("user_id"));
        return review;
    }

}