package com.techelevator.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import com.techelevator.model.Review;

public interface reviewDao {

    List<Review> getReviews(Long beer_id);

    void addReview(Review aReview);

    void saveReview(@Valid Review review);

    List<Review> searchReviewsByBeerId(long beerId);

}