/*
 * Copyright 2012-2017 CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.codelibs.fess.es.log.exentity;

import java.util.HashMap;
import java.util.Map;

import org.codelibs.fess.es.log.bsentity.BsFavoriteLog;
import org.codelibs.fess.helper.SystemHelper;
import org.codelibs.fess.util.ComponentUtil;

/**
 * @author FreeGen
 */
public class FavoriteLog extends BsFavoriteLog {

    private static final long serialVersionUID = 1L;

    public String getId() {
        return asDocMeta().id();
    }

    public void setId(final String id) {
        asDocMeta().id(id);
    }

    public Long getVersionNo() {
        return asDocMeta().version();
    }

    public void setVersionNo(final Long version) {
        asDocMeta().version(version);
    }

    @Override
    public Map<String, Object> toSource() {
        final SystemHelper systemHelper = ComponentUtil.getSystemHelper();
        Map<String, Object> sourceMap = new HashMap<>();
        if (createdAt != null) {
            sourceMap.put("createdAt", systemHelper.convertDateTime(createdAt));
        }
        if (url != null) {
            sourceMap.put("url", url);
        }
        if (docId != null) {
            sourceMap.put("docId", docId);
        }
        if (queryId != null) {
            sourceMap.put("queryId", queryId);
        }
        if (userInfoId != null) {
            sourceMap.put("userInfoId", userInfoId);
        }
        return sourceMap;
    }

    @Override
    public String toString() {
        return "FavoriteLog [createdAt=" + createdAt + ", url=" + url + ", docId=" + docId + ", queryId=" + queryId + ", userInfoId="
                + userInfoId + ", docMeta=" + docMeta + "]";
    }
}
