package com.dell.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dell.entities.HangmanWord;

public interface HangmanWordRepository extends JpaRepository<HangmanWord, Long>{

}
