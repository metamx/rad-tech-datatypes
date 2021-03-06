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
public class Link
{
  private final String url;
  private final List<String> clicktrackers;
  private final String fallback;
  private final Ext ext;

  public Link(
      @JsonProperty("url") String url,
      @JsonProperty("clicktrackers") List<String> clicktrackers,
      @JsonProperty("fallback") String fallback,
      @JsonProperty("ext") Ext ext
  )
  {
    this.url = url;
    this.clicktrackers = clicktrackers;
    this.fallback = fallback;
    this.ext = ext;
  }

  @JsonProperty
  public String getUrl()
  {
    return url;
  }

  @JsonProperty
  public List<String> getClicktrackers()
  {
    return clicktrackers;
  }

  @JsonProperty
  public String getFallback()
  {
    return fallback;
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
    private String url;
    private List<String> clicktrackers;
    private String fallback;
    private Ext ext;

    public Builder() {}

    public Builder url(final String url)
    {
      this.url = url;
      return this;
    }

    public Builder clicktrackers(final List<String> clicktrackers)
    {
      this.clicktrackers = clicktrackers;
      return this;
    }

    public Builder fallback(final String fallback)
    {
      this.fallback = fallback;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Link build()
    {
      return new Link(
          url,
          clicktrackers,
          fallback,
          ext
      );
    }
  }
}
