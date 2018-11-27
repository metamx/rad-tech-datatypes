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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageResponse
{
  private final String url;
  private final Integer w;
  private final Integer h;
  private final Ext ext;

  public ImageResponse(
      @JsonProperty("url") String url,
      @JsonProperty("w") Integer w,
      @JsonProperty("h") Integer h,
      @JsonProperty("ext") Ext ext
  )
  {
    this.url = url;
    this.w = w;
    this.h = h;
    this.ext = ext;
  }

  @JsonProperty
  public String getUrl() { return url; }

  @JsonProperty
  public Integer getW()
  {
    return w;
  }

  @JsonProperty
  public Integer getH()
  {
    return h;
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
    private Integer w;
    private Integer h;
    private Ext ext;

    public Builder() {}

    public Builder url(final String url)
    {
      this.url = url;
      return this;
    }

    public Builder w(final Integer w)
    {
      this.w = w;
      return this;
    }

    public Builder h(final Integer h)
    {
      this.h = h;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public ImageResponse build()
    {
      return new ImageResponse(
          url,
          w,
          h,
          ext
      );
    }
  }
}
