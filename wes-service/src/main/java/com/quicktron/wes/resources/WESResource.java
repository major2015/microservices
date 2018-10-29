package com.quicktron.wes.resources;

import com.quicktron.wes.client.WCSClient;
import com.quicktron.wes.core.WCS;
import com.quicktron.wes.core.WES;
import com.quicktron.wes.db.WESDataMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 23:31
 */
@RestController
@RequestMapping("/v1/ces")
public class WESResource {
    @Autowired
    private WESDataMock wesDataMock;
    @Autowired
    private WCSClient wcsClient;

    @GetMapping("/list")
    public ResponseEntity<List<WES>> list() {
        return ResponseEntity.ok(wesDataMock.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WES> find(@PathVariable String id) {
        WES exist = wesDataMock.get(id).orNull();
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        WCS wcs = wcsClient.get(id);
        exist.setAgvCode(wcs.getAgvCode());
        exist.setWcsName(wcs.getName());
        return ResponseEntity.ok(exist);
    }
}
