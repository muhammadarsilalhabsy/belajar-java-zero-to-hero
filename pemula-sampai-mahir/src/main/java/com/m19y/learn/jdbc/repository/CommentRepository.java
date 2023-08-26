package com.m19y.learn.jdbc.repository;

import com.m19y.learn.jdbc.entity.Comment;

import java.util.List;

public interface CommentRepository {

  void insert (Comment comment);
  Comment findById(Integer id);
  List<Comment> findAll();
  List<Comment> findAllByEmail(String email);
}
