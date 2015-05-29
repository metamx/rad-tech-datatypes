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
  private final int type;
  private final int w;
  private final int wmin;
  private final int h;
  private final int hmin;
  private final List<String> mimes;
  private final Ext ext;

  public ImageRequest(
      @JsonProperty("type") int type,
      @JsonProperty("w") int w,
      @JsonProperty("wmin") int wmin,
      @JsonProperty("h") int h,
      @JsonProperty("hmin") int hmin,
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
  public int getType()
  {
    return type;
  }

  @JsonProperty
  public int getW()
  {
    return w;
  }

  @JsonProperty
  public int getWmin()
  {
    return wmin;
  }

  @JsonProperty
  public int getH()
  {
    return h;
  }

  @JsonProperty
  public int getHmin()
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
    private int type;
    private int w;
    private int wmin;
    private int h;
    private int hmin;
    private List<String> mimes;
    private Ext ext;

    public Builder() {}

    public Builder type(final int type)
    {
      this.type = type;
      return this;
    }

    public Builder w(final int w)
    {
      this.w = w;
      return this;
    }

    public Builder wmin(final int wmin)
    {
      this.wmin = wmin;
      return this;
    }

    public Builder h(final int h)
    {
      this.h = h;
      return this;
    }

    public Builder hmin(final int hmin)
    {
      this.hmin = hmin;
      return this;
    }

    public Builder mime(final List<String> mime)
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