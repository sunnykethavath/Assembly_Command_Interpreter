package com.example.AssemblyLanguageInterpreter.Service;

import com.example.AssemblyLanguageInterpreter.Model.Program;
import com.example.AssemblyLanguageInterpreter.Repository.ProgramResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProgramService {

    @Autowired
    ProgramResultRepository repository;

    private Map<String, Integer> registers = new HashMap<>();

    public String executeProgram(String programText) {
        String[] lines = programText.split("\n");

        for(String line : lines){
            String[] parts = line.split(" ");
            String instruction = parts[0];

            switch (instruction){
                case "MV":
                    mv(parts[1], parts[2]);
                    break;
                case "ADD":
                    if (parts[2].startsWith("#")) add(parts[1], parts[2]);
                    else addReg(parts[1], parts[2]);
                    break;
                case "SHOW":
                    return show(parts[1], programText);
            }
        }
        return null;
    }

    private void mv(String register, String value) {
        registers.put(register, Integer.parseInt(value.replace("#","")));
    }

    private void addReg(String register1, String register2) {
        int value1 = registers.get(register1);
        int value2 = registers.get(register2);
        registers.put(register1, value1 + value2);
    }

    private void add(String register, String constant) {
        int value1 = registers.get(register);
        int value2 = registers.get(constant.replace("#",""));
        registers.put(register, value1 + value2);
    }

    private String show(String part, String programText) {
        Program program = new Program();
        StringBuilder sb = new StringBuilder();

        for(String key : registers.keySet()){
            sb.append(key).append(":");
            sb.append(registers.get(key)).append(",");
        }
        if(sb.charAt(sb.length()-1) == ',') sb.deleteCharAt(sb.length() - 1);
        program.setResult(sb.toString());
        program.setProgramText(programText);
        repository.save(program);
        registers.clear();
        return sb.toString();
    }

}
