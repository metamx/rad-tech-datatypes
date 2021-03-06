/*
 * Rad-tech-datatypes.
 * Copyright 2014 Metamarkets Group Inc.
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

package com.metamx.datatypes.mmx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metamx.datatypes.openrtb.Ext;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MmxClick
{
  private final String timestamp;
  private final String requestId;
  private final Ext ext;

  public MmxClick(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("id") String requestId,
      @JsonProperty("ext") Ext ext
  )
  {
    this.timestamp = timestamp;
    this.requestId = requestId;
    this.ext = ext;
  }

  @JsonProperty
  public String getTimestamp()
  {
    return timestamp;
  }

  @JsonProperty("id")
  public String getRequestId()
  {
    return requestId;
  }

  @JsonProperty
  public Ext getExt()
  {
    return ext;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private DateTime timestamp;
    private String requestId;
    private Ext ext;

    public Builder() {}

    public Builder timestamp(final DateTime timestamp)
    {
      this.timestamp = timestamp;
      return this;
    }

    public Builder requestId(final String requestId)
    {
      this.requestId = requestId;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public MmxClick build()
    {
      return new MmxClick(timestamp.withZone(DateTimeZone.UTC).toString(), requestId, ext);
    }
  }
}
