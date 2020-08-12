package mykiddrawing.quiz.repository;



import mykiddrawing.quiz.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {


	public List<Result> findByUserId(Long userId);
}