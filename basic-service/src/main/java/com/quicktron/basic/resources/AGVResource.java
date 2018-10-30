package com.quicktron.basic.resources;

import com.codahale.metrics.Clock;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;
import com.quicktron.basic.core.AGV;
import com.quicktron.basic.db.AGVDataMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月25日 19:21
 */
@RestController
public class AGVResource {
    public static final Logger logger = LoggerFactory.getLogger(AGVResource.class);

    private final Clock clock = Clock.defaultClock();
    private final AGVDataMock agvDataMock = new AGVDataMock();
    public static class AGVResult {
        @JsonProperty
        public List<AGV> agvs;
    }

    @GetMapping("/list")
    public ResponseEntity<AGVResult> listAGV() {
        logger.info("request resource list of agv at {}.", clock.getTime());
        AGVResult r = new AGVResult();
        r.agvs = agvDataMock.list();
        return ResponseEntity.ok(r);
    }

    @PostMapping(produces = "application/json", consumes = "application./json", path = "/")
    public ResponseEntity<AGV> add(@RequestBody AGV agv) {
        agvDataMock.create(agv);
        return ResponseEntity.ok(agv);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AGV> get(@PathVariable("id") String id) {
        if (Strings.isNullOrEmpty(id)) {
            throw new IllegalArgumentException("id must be set");
        }
        return ResponseEntity.ok(agvDataMock.get(id).orNull());
    }
}
