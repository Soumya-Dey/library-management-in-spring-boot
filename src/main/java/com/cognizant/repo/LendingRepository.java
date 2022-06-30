package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.Book;
import com.cognizant.entity.Lending;
import com.cognizant.entity.User;

import java.util.List;

public interface LendingRepository extends JpaRepository<Lending, Long> {

    List<Lending> findAllByBookFk(Book book);

    List<Lending> findAllByUserFk(User user);

}
