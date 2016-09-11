/*
 * Copyright (C) 2016 Commerce Technologies, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.commercehub.sensu.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * A stash with associated path and expiration information.
 */
public class StashPath {
    /**
     * Special value to indicate that a stash should never expire.
     */
    public static final int NEVER = -1;

    private String path;
    private Integer expire;
    private JsonObject content;

    public StashPath() {
        this(null);
    }

    public StashPath(String path) {
        this(path, null);
    }

    public StashPath(String path, JsonObject content) {
        this(path, content, null);
    }

    public StashPath(String path, JsonObject content, Integer expire) {
        this.path = path;
        this.content = content == null ? new JsonObject() : content;
        this.expire = expire;
    }

    public StashPath(Map<String, Object> content, String path) {
        this(content, path, null);
    }

    public StashPath(Map<String, Object> content, String path, Integer expire) {
        this(path, new Gson().toJsonTree(content).getAsJsonObject(), expire);
    }

    /**
     * Returns the content of the stash (arbitrary JSON).
     *
     * @return the content of the stash (arbitrary JSON)
     */
    public JsonObject getContent() {
        return content;
    }

    /**
     * Sets the content of the stash (arbitrary JSON).
     *
     * @param content the content of the stash (arbitrary JSON)
     */
    public void setContent(JsonObject content) {
        this.content = content;
    }

    /**
     * Returns the expiration duration of the stash (in seconds).  The default is to never expire, which is returned as {@value #NEVER}.
     *
     * @return the expiration duration of the stash (in seconds)
     */
    public Integer getExpire() {
        return expire;
    }

    /**
     * Sets the expiration duration of the stash (in seconds).  The default is to never expire.
     *
     * @param expire the expiration duration of the stash (in seconds)
     */
    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    /**
     * Returns whether the stash will expire at some point.
     *
     * @return whether the stash will expire at some point
     */
    public boolean isTimeLimited() {
        return expire != NEVER;
    }

    /**
     * Returns the path of the stash.
     *
     * @return the path of the stash
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path of the stash.
     *
     * @param path the path of the stash
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "StashPath{" +
                "path='" + path + '\'' +
                ", expire=" + expire +
                ", content=" + content +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StashPath stashPath = (StashPath) o;

        if (content != null ? !content.equals(stashPath.content) : stashPath.content != null) return false;
        if (getNormalizedExpire() != stashPath.getNormalizedExpire()) return false;
        if (path != null ? !path.equals(stashPath.path) : stashPath.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = path != null ? path.hashCode() : 0;
        result = 31 * result + Integer.valueOf(getNormalizedExpire()).hashCode();
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    private int getNormalizedExpire() {
        return expire == null ? NEVER : expire;
    }
}
