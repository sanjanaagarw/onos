/*
 * Copyright 2017-present Open Networking Foundation
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
package org.onosproject.store.cluster.messaging.impl;

import com.google.common.base.MoreObjects;

import org.onlab.util.ByteArraySizeHashPrinter;
import org.onosproject.core.HybridLogicalTime;
import org.onosproject.core.Version;
import org.onosproject.store.cluster.messaging.Endpoint;

/**
 * Internal request message.
 */
public final class InternalRequest extends InternalMessage {
    private final Endpoint sender;
    private final Version version;
    private final String subject;

    public InternalRequest(int preamble,
                           HybridLogicalTime time,
                           long id,
                           Endpoint sender,
                           Version version,
                           String subject,
                           byte[] payload) {
        super(preamble, time, id, payload);
        this.sender = sender;
        this.version = version;
        this.subject = subject;
    }

    @Override
    public Type type() {
        return Type.REQUEST;
    }

    public String subject() {
        return subject;
    }

    public Endpoint sender() {
        return sender;
    }

    public Version version() {
        return version;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time())
                .add("id", id())
                .add("subject", subject)
                .add("sender", sender)
                .add("version", version)
                .add("payload", ByteArraySizeHashPrinter.of(payload()))
                .toString();
    }
}