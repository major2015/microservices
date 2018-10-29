package com.quicktron.wes.db;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.quicktron.wes.core.WES;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 23:16
 */
public class WESDataMock {
    private final List<WES> wess;

    public WESDataMock() {
        wess = Lists.newArrayList(
                new WES("1", "wes_1"),
                new WES("2", "wes_2"),
                new WES("3", "wes_3")
        );
    }

    public List<WES> list() {
        return wess;
    }

    public Optional<WES> get(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return Optional.absent();
        }
        WES exist = wess.stream()
                .filter(w -> w.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if (exist == null) {
            return Optional.absent();
        }
        return Optional.of(exist);
    }
}
