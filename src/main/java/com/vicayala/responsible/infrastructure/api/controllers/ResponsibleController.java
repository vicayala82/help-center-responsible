package com.vicayala.responsible.infrastructure.api.controllers;

import com.vicayala.responsible.domain.dtos.responsible.ResponsibleDTO;
import com.vicayala.responsible.domain.helpers.ResponsibleHelper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/responsible")
@AllArgsConstructor
public class ResponsibleController {

    private final ResponsibleHelper responsibleHelper;
    @GetMapping("/ping")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("pong");
    }
    @PostMapping
    public ResponseEntity<ResponsibleDTO> post(@RequestBody ResponsibleDTO requestDto){
        return ResponseEntity.ok(responsibleHelper.save(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsibleDTO> get(@PathVariable String id){
        return ResponseEntity.ok(responsibleHelper.getForId(id));
    }


}
