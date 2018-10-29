package com.quicktron.wcs.resources;

import com.google.common.base.Strings;
import com.quicktron.wcs.client.BasicClient;
import com.quicktron.wcs.core.AGV;
import com.quicktron.wcs.core.WCS;
import com.quicktron.wcs.db.WCSDataMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 0:43
 */
@RestController
@RequestMapping("/v1/wcs")
public class WCSResource {
    @Autowired
    private WCSDataMock wcsDataMock;
    @Autowired
    private BasicClient basicClient;

    public static class WCSDataResult {
        public List<WCS> wcss;
    }

    @GetMapping("/list")
    public ResponseEntity<WCSDataResult> list() {
        WCSDataResult result = new WCSDataResult();
        result.wcss = wcsDataMock.list();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<WCS> get(@PathVariable("id") String id) {
        if (Strings.isNullOrEmpty(id)) {
            throw new IllegalArgumentException("id must be set");
        }
        WCS exist = wcsDataMock.get(id).orNull();
        if (exist == null) {
            throw new IllegalArgumentException("not found " + id);
        }
        BasicClient.AGVResult result = basicClient.listAGVs();
        AGV agv = result.getAgvs().stream()
                .filter(a -> a.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if (agv != null) {
            exist.setAgvCode(agv.getCode());
        }
        return ResponseEntity.ok(exist);
    }

    @PostMapping
    public ResponseEntity<WCS> post(@RequestBody WCS wcs) {
       WCS insert =  wcsDataMock.create(wcs).orNull();
       if (insert == null) {
           throw new IllegalArgumentException();
       }
       return ResponseEntity.ok(insert);
    }
}
