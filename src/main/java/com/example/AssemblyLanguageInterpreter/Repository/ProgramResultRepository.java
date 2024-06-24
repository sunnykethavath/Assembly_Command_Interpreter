package com.example.AssemblyLanguageInterpreter.Repository;

import com.example.AssemblyLanguageInterpreter.Model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramResultRepository extends JpaRepository<Program,Integer> {
}
