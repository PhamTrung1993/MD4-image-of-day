package com.codegym.config.service.comment;

import com.codegym.model.Comment;
import com.codegym.config.service.IService;

import java.util.List;

public interface ICommentService extends IService<Comment> {
    List<Comment> findByVote(Long vote);
}
