package com.quicktron.wcs.db;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.quicktron.wcs.core.WCS;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月26日 18:44
 */
public class WCSDataMock {
    private final List<WCS> wcss = Lists.newArrayList(
            new WCS("1", "wcs_1"),
            new WCS("2", "wcs_2"),
            new WCS("3", "wcs_3")
    );

    public List<WCS> list() {
        return wcss;
    }

    public Optional<WCS> get(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return Optional.absent();
        }
        WCS exist = wcss.stream()
                .filter(w -> w.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if (exist == null) {
            return Optional.absent();
        }
        return Optional.of(exist);
    }

    public Optional<WCS> create(WCS wcs) {
        Preconditions.checkNotNull(wcs);
        WCS exist = wcss.stream()
                .filter(w -> w.getId().equalsIgnoreCase(wcs.getId()))
                .findFirst()
                .orElse(null);
        if (exist == null) {
            wcss.add(wcs);
        }
        return Optional.of(exist);
    }
}
