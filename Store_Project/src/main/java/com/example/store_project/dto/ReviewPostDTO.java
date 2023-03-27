package com.example.store_project.dto;

public class ReviewPostDTO {
        private String userName;
        private Integer rating;
        private String comment;

        public ReviewPostDTO() {
        }

        public ReviewPostDTO(String userName, Integer rating, String comment) {
                this.userName = userName;
                this.rating = rating;
                this.comment = comment;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public Integer getRating() {
                return rating;
        }

        public void setRating(Integer rating) {
                this.rating = rating;
        }

        public String getComment() {
                return comment;
        }

        public void setComment(String comment) {
                this.comment = comment;
        }
}
