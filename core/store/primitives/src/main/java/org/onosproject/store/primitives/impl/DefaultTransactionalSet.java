/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.store.primitives.impl;


import org.onosproject.store.service.TransactionalMap;
import org.onosproject.store.service.TransactionalSet;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Default TransactionalSet implementation that provides a repeatable reads
 * transaction isolation level.
 *
 * @param <E> element type.
 */
public class DefaultTransactionalSet<E> implements TransactionalSet<E> {

    private TransactionalMap<E, Boolean> map;

    // dummy value to associate with an Object in the backing map
    private static final Boolean PRESENT = Boolean.TRUE;

    public DefaultTransactionalSet(TransactionalMap<E, Boolean> map) {
        this.map = checkNotNull(map);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(E e) {
        return map.remove(e) != null;
    }

    @Override
    public boolean contains(E e) {
        return map.get(e) != null;
    }
}
