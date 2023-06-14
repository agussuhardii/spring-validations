package com.agussuhardi.springvalidation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :21.24
 * @project spring-validation
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "sample")
@Validated
@Slf4j
public class SampleController {

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid UserVO vo) {
//        logic register here
//        ...
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
