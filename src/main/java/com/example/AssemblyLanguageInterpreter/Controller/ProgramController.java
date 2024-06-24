package com.example.AssemblyLanguageInterpreter.Controller;

import com.example.AssemblyLanguageInterpreter.Model.Program;
import com.example.AssemblyLanguageInterpreter.Service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @PostMapping("/execute")
    public String execute(@RequestBody String programText){
        return programService.executeProgram(programText);
    }
}
