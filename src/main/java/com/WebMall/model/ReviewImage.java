package com.WebMall.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "reviewimages")
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 150)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
