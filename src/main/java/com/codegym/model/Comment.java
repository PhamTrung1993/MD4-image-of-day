package com.codegym.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vote;

    private String nameViewer;

    private String feedback;

    private Date date;

    public Comment() {
    }

    public Comment(Long id, Long vote, String nameViewer, String feedback, Date date) {
        this.id = id;
        this.vote = vote;
        this.nameViewer = nameViewer;
        this.feedback = feedback;
        this.date = date;
    }

    public Comment(Long vote, String nameViewer, String feedback, Date date) {
        this.vote = vote;
        this.nameViewer = nameViewer;
        this.feedback = feedback;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVote() {
        return vote;
    }

    public void setVote(Long vote) {
        this.vote = vote;
    }

    public String getNameViewer() {
        return nameViewer;
    }

    public void setNameViewer(String nameViewer) {
        this.nameViewer = nameViewer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
