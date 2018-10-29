package com.quicktron.basic.db;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.quicktron.basic.core.AGV;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月26日 17:51
 */
public class AGVDataMock {
    private final List<AGV> agvs = ImmutableList.of(
            new AGV("1", "agv_1"),
            new AGV("2", "agv_1"),
            new AGV("3", "agv_1")
    );

    public List<AGV> list() {
        return agvs;
    }

    public Optional<AGV> create(AGV agv) {
        Preconditions.checkNotNull(agv);
        long exist = agvs.stream().filter(a -> a.getId().equalsIgnoreCase(agv.getId())).count();
        if (exist < 1) {
            agvs.add(agv);
        }
        return Optional.of(agv);
    }

    public Optional<AGV> get(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return Optional.absent();
        }
        AGV exist = agvs.stream()
                .filter(a -> a.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if (exist == null) {
            return Optional.absent();
        }
        return Optional.of(exist);
    }
}
