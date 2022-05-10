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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jp.co.suntory.nmrc.application.resource.TestObjectRequest;
import jp.co.suntory.nmrc.domain.object.TestObject;
import jp.co.suntory.nmrc.domain.service.TestObjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/test")
@Tag(name = "Test API")
@RequiredArgsConstructor
@Slf4j
public class TestController {
    
    @NonNull
    private final TestObjectService testObjectService;

    @GetMapping
    @Operation(description = "SearchAPI - Test Search API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid parameter."),
            @ApiResponse(responseCode = "404", description = "The requested resource doesn't exist.")
    })
    @ResponseStatus(HttpStatus.OK)
    public String search(@RequestParam(required = false, name = "optionalParam") String optionalParam,
            @RequestParam(name = "requiredParam") String requiredParam) {
        log.info("Test Search API");
        return String.format("Test Search: optionalParam=%s, requiredParam=%s", optionalParam, requiredParam);
    }

    @GetMapping("/{id}")
    @Operation(description = "ViewAPI - Test View API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid parameter."),
    })
    @ResponseStatus(HttpStatus.OK)
    public String view(@PathVariable final int id) {
        log.info("Test View API");
        return "Test View: id = " + id;
    }

    /*
     * For simplicity, I make the return type as void.
     */
    @PostMapping
    @Operation(description = "SaveAPI - Test Save API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid parameter."),
            @ApiResponse(responseCode = "404", description = "The requested resource doesn't exist.")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public TestObject save(@RequestBody @Valid TestObjectRequest request) {
        log.info("Test Save API");
        return testObjectService.save(request.toDomainObject());        
    }

    @PutMapping
    @Operation(description = "UpdateAPI - Test Update API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The requested resource was successfully updated."),
            @ApiResponse(responseCode = "400", description = "Invalid parameter.")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid TestObjectRequest request) {
        log.info("Test Update API");
    }

    @DeleteMapping("/{id}")
    @Operation(description = "DeleteAPI - Test Delete API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The requested resource was successfully deleted."),
            @ApiResponse(responseCode = "400", description = "Invalid parameter."),
            @ApiResponse(responseCode = "404", description = "The requested resource doesn't exist.")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final int id) {
        log.info("Test Delete API");
    }
}
