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

package com.metamx.datatypes.openrtbnative;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metamx.datatypes.openrtb.Ext;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VideoRequest
{
  private final List<String> mimes;
  private final Integer minduration;
  private final Integer maxduration;
  private final List<Integer> protocols;
  private final Ext ext;

  public VideoRequest(
      @JsonProperty("mimes") List<String> mimes,
      @JsonProperty("minduration") Integer minduration,
      @JsonProperty("maxduration") Integer maxduration,
      @JsonProperty("protocols") List<Integer> protocols,
      @JsonProperty("ext") Ext ext
  )
  {
    this.mimes = mimes;
    this.minduration = minduration;
    this.maxduration = maxduration;
    this.protocols = protocols;
    this.ext = ext;
  }

  @JsonProperty
  public List<String> getMimes()
  {
    return mimes;
  }

  @JsonProperty
  public Integer getMinduration()
  {
    return minduration;
  }

  @JsonProperty
  public Integer getMaxduration()
  {
    return maxduration;
  }

  @JsonProperty
  public List<Integer> getProtocols()
  {
    return protocols;
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
    private List<String> mimes;
    private Integer minduration;
    private Integer maxduration;
    private List<Integer> protocols;
    private Ext ext;

    public Builder() {}

    public Builder mimes(final List<String> mimes)
    {
      this.mimes = mimes;
      return this;
    }

    public Builder minduration(final Integer minduration)
    {
      this.minduration = minduration;
      return this;
    }

    public Builder maxduration(final Integer maxduration)
    {
      this.maxduration = maxduration;
      return this;
    }

    public Builder protocols(final List<Integer> protocols)
    {
      this.protocols = protocols;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public VideoRequest build()
    {
      return new VideoRequest(
          mimes,
          minduration,
          maxduration,
          protocols,
          ext
      );
    }
  }
}
