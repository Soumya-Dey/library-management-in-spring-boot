package com.cognizant.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.entity.Book;
import com.cognizant.entity.Lending;
import com.cognizant.entity.User;
import com.cognizant.repo.BookRepository;
import com.cognizant.repo.LendingRepository;
import com.cognizant.repo.UserRepository;
import com.cognizant.utils.LendingObject;
import com.cognizant.utils.LendingStatus;

@Service
public class LendingService {
    private final LendingRepository lendingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LendingService(LendingRepository lendingRepository, UserRepository userRepository,
            BookRepository bookRepository) {
        this.lendingRepository = lendingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<Lending> getLendings() {
        return lendingRepository.findAll();
    };

    public Lending getLending(Long lendingId) throws Exception {
        Optional<Lending> oLending = lendingRepository.findById(lendingId);
        if (!oLending.isPresent())
            throw new Exception("Lending not found!");
        else
            return oLending.get();
    }

    public List<Lending> getLendingsOfUser(User user) throws Exception {
        return lendingRepository.findAllByUserFk(user);
    }

    public Lending createLending(LendingObject lendingObject) throws Exception {
        Optional<User> oUser = userRepository.findById(lendingObject.getUserId());
        Optional<Book> oBook = bookRepository.findById(lendingObject.getBookId());
        if (!oUser.isPresent() || !oBook.isPresent())
            throw new Exception("User or Book invalid!");

        User existingUser = oUser.get();
        Book existingBook = oBook.get();

        Lending lending = new Lending();
        lending.setLendDate(new Date(System.currentTimeMillis()));
        lending.setReturnDate(new Date(System.currentTimeMillis() + 604800000));
        lending.setUserFk(existingUser);
        lending.setBookFk(existingBook);
        lending.setStatus(LendingStatus.REQUESTED);
        existingUser.getLendings().add(lending);
        existingBook.getLendings().add(lending);

        Lending newLending = lendingRepository.save(lending);
        return newLending;
    }

    public Lending updateLendingStatus(Long lendingId, LendingStatus newStatus) throws Exception {
        Optional<Lending> oLending = lendingRepository.findById(lendingId);
        if (!oLending.isPresent())
            throw new Exception("Lending not found!");
        else {
            Lending lending = oLending.get();
            lending.setStatus(newStatus);
            Lending updatedLending = lendingRepository.save(lending);
            return updatedLending;
        }
    }
}
