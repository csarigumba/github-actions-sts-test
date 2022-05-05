package jp.co.suntory.nmrc.application.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jp.co.suntory.nmrc.application.resource.TestRequest;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String search(@RequestParam(required = false, name = "optionalParam") String optionalParam,
            @RequestParam(name = "requiredParam") String requiredParam) {
        return String.format("Test Search: optionalParam=%s, requiredParam=%s", optionalParam, requiredParam);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String view(@PathVariable final int id) {
        return "Test View: id = " + id;
    }

    /*
     * For simplicity, I make the return type as void.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid TestRequest request) {
        System.out.println("Test Save request: " + request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid TestRequest request) {
        System.out.println("Test Update request: " + request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final int id) {
        System.out.println("Test Delete: id = " + id);
    }
}