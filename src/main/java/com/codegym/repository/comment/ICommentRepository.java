package com.codegym.repository.comment;

import com.codegym.model.Comment;
import com.codegym.repository.IRepository;

import java.util.List;

public interface ICommentRepository extends IRepository<Comment> {
    List<Comment> findByVote(Long vote);
}
