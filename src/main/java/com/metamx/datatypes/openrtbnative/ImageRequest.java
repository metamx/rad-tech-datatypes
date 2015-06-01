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
public class ImageRequest
{
  private final Integer type;
  private final Integer w;
  private final Integer wmin;
  private final Integer h;
  private final Integer hmin;
  private final List<String> mimes;
  private final Ext ext;

  public ImageRequest(
      @JsonProperty("type") Integer type,
      @JsonProperty("w") Integer w,
      @JsonProperty("wmin") Integer wmin,
      @JsonProperty("h") Integer h,
      @JsonProperty("hmin") Integer hmin,
      @JsonProperty("mimes") List<String> mimes,
      @JsonProperty("ext") Ext ext
  )
  {
    this.type = type;
    this.w = w;
    this.wmin = wmin;
    this.h = h;
    this.hmin = hmin;
    this.mimes = mimes;
    this.ext = ext;
  }

  @JsonProperty
  public Integer getType()
  {
    return type;
  }

  @JsonProperty
  public Integer getW()
  {
    return w;
  }

  @JsonProperty
  public Integer getWmin()
  {
    return wmin;
  }

  @JsonProperty
  public Integer getH()
  {
    return h;
  }

  @JsonProperty
  public Integer getHmin()
  {
    return hmin;
  }

  @JsonProperty
  public List<String> getMimes()
  {
    return mimes;
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
    private Integer type;
    private Integer w;
    private Integer wmin;
    private Integer h;
    private Integer hmin;
    private List<String> mimes;
    private Ext ext;

    public Builder() {}

    public Builder type(final Integer type)
    {
      this.type = type;
      return this;
    }

    public Builder w(final Integer w)
    {
      this.w = w;
      return this;
    }

    public Builder wmin(final Integer wmin)
    {
      this.wmin = wmin;
      return this;
    }

    public Builder h(final Integer h)
    {
      this.h = h;
      return this;
    }

    public Builder hmin(final Integer hmin)
    {
      this.hmin = hmin;
      return this;
    }

    public Builder mimes(final List<String> mime)
    {
      this.mimes = mime;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public ImageRequest build()
    {
      return new ImageRequest(
          type,
          w,
          wmin,
          h,
          hmin,
          mimes,
          ext
      );
    }
  }
}
