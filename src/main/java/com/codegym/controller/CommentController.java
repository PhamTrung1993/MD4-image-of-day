package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.model.CommentForm;
import com.codegym.config.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/list")
    public ModelAndView home(@RequestParam(name = "vote", required = false) Long vote) {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Comment> comments;
        if (vote == null) {
            comments = commentService.findAll();
        } else {
            comments = commentService.findByVote(vote);
        }
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("commentForm", new CommentForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String summitComment(@ModelAttribute CommentForm commentForm, Model model) {
        Long vote = commentForm.getVote();
        String nameViewer = commentForm.getNameViewer();
        String feedback = commentForm.getFeedback();
        Comment comment = new Comment();
        comment.setFeedback(feedback);
        comment.setNameViewer(nameViewer);
        comment.setVote(vote);
        if (commentForm.getDate() == null) {
            comment.setDate(new Date());
        }
        commentService.save(comment);
        model.addAttribute("message", "Comment submit successfully!!!");
        model.addAttribute("comments", commentService.findAll());
        return "/index";
    }
}
