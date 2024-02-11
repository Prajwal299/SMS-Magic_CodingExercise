package com.CodingExercise.Exercise.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodingExercise.Exercise.entity.Client;



@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

	
}
