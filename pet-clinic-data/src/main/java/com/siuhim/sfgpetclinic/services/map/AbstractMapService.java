package com.siuhim.sfgpetclinic.services.map;

import com.siuhim.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity> {

    protected Map<Long, T> map = new HashMap<>();
    Set<T> findAll() {
        return new HashSet<>(map.values());
    }
    T findById(Long id) {
        return map.get(id);
    }
    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }
    void deleteById(Long id) {
        map.remove(id);
    }
    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    Long getNextId() {
        if (map.size() > 0) {
            return Collections.max(map.keySet())+1;
        } else {
            return 1L;
        }
    }
}
