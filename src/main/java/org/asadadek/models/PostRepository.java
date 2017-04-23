package org.asadadek.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by abhay on 22-04-2017.
 */
public interface PostRepository extends CrudRepository<Post,Integer> {

    List<Post> findByTitleContaining(String pattern);
}
