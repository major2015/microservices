package com.quicktron.cs.resources;

import com.codahale.metrics.Clock;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月26日 11:21
 */
@RestController
@RequestMapping("/v1/about")
public class AboutResource {
    private final Clock clock = Clock.defaultClock();
    private final long startedAt = clock.getTime();

    @GetMapping
    public ResponseEntity about() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode n = mapper.createObjectNode();
        n.put("name", "config-service");
        n.put("upTime", clock.getTime() - startedAt);
        return ResponseEntity.status(HttpStatus.OK).body(n);
    }
}
