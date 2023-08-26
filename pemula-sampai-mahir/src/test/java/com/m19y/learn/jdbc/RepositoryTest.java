package com.m19y.learn.jdbc;

import com.m19y.learn.jdbc.entity.Comment;
import com.m19y.learn.jdbc.repository.CommentRepository;
import com.m19y.learn.jdbc.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

  private CommentRepository repository;


  @BeforeEach
  void setUp() {
    repository = new CommentRepositoryImpl();
  }

  @Test
  void testInsertComment() {
    Comment comment = new Comment("tidak@gmail.com", "Jajajaja!");

    repository.insert(comment);

    assertNotNull(comment.getId());
    System.out.println(comment.getId());
  }

  @Test
  void testFindById() {
    Comment comment = repository.findById(29642);
    assertNotNull(comment);
    assertEquals("tidak@gmail.com", comment.getEmail());
    assertEquals("Jajajaja!", comment.getComment());
  }

  @Test
  void findAll() {
    List<Comment> comments = repository.findAll();

    for (Comment comment: comments) {
      System.out.println("Id : " + comment.getId());
      System.out.println("Email : " + comment.getEmail());
      System.out.println("Comment : " + comment.getComment());
      System.out.println("====================\n");
    }
  }

  @Test
  void findByEmail() {

    List<Comment> comments = repository.findAllByEmail("salah@gmail.com");

//    assertEquals(4, comments.size());

    for (Comment comment: comments) {
      System.out.println("Id : " + comment.getId());
      System.out.println("Email : " + comment.getEmail());
      System.out.println("Comment : " + comment.getComment());
      System.out.println("====================\n");
    }
  }
}
