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

package com.metamx.datatypes.openrtb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Banner
{
  private final Integer width;
  private final Integer height;
  private final Integer wmax;
  private final Integer hmax;
  private final Integer wmin;
  private final Integer hmin;
  private final String id;
  private final Integer pos;
  private final List<Integer> btype;
  private final List<Integer> battr;
  private final List<String> mimes;
  private final Integer topframe;
  private final List<Integer> expdir;
  private final List<Integer> api;
  private final Ext ext;

  public Banner(
      @JsonProperty("w") Integer width,
      @JsonProperty("h") Integer height,
      @JsonProperty("wmax") Integer wmax,
      @JsonProperty("hmax") Integer hmax,
      @JsonProperty("wmin") Integer wmin,
      @JsonProperty("hmin") Integer hmin,
      @JsonProperty("id") String id,
      @JsonProperty("pos") Integer pos,
      @JsonProperty("btype") List<Integer> btype,
      @JsonProperty("battr") List<Integer> battr,
      @JsonProperty("mimes") List<String> mimes,
      @JsonProperty("topframe") Integer topframe,
      @JsonProperty("expdir") List<Integer> expdir,
      @JsonProperty("api") List<Integer> api,
      @JsonProperty("ext") Ext ext
  )
  {
    this.width = width;
    this.height = height;
    this.wmax = wmax;
    this.hmax = hmax;
    this.wmin = wmin;
    this.hmin = hmin;
    this.id = id;
    this.pos = pos;
    this.btype = btype;
    this.battr = battr;
    this.mimes = mimes;
    this.topframe = topframe;
    this.expdir = expdir;
    this.api = api;
    this.ext = ext;
  }

  @JsonProperty("w")
  public Integer getWidth()
  {
    return width;
  }

  @JsonProperty("h")
  public Integer getHeight()
  {
    return height;
  }

  @JsonProperty
  public Integer getWmax()
  {
    return wmax;
  }

  @JsonProperty
  public Integer getHmax()
  {
    return hmax;
  }

  @JsonProperty
  public Integer getWmin()
  {
    return wmin;
  }

  @JsonProperty
  public Integer getHmin()
  {
    return hmin;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty
  public Integer getPos()
  {
    return pos;
  }

  @JsonProperty
  public List<Integer> getBtype()
  {
    return btype;
  }

  @JsonProperty
  public List<Integer> getBattr()
  {
    return battr;
  }

  @JsonProperty
  public List<String> getMimes()
  {
    return mimes;
  }

  @JsonProperty
  public Integer getTopframe()
  {
    return topframe;
  }

  @JsonProperty
  public List<Integer> getExpdir()
  {
    return expdir;
  }

  @JsonProperty
  public List<Integer> getApi()
  {
    return api;
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
    private Integer width;
    private Integer height;
    private Integer wmax;
    private Integer hmax;
    private Integer wmin;
    private Integer hmin;
    private String id;
    private Integer pos;
    private List<Integer> btype;
    private List<Integer> battr;
    private List<String> mimes;
    private Integer topframe;
    private List<Integer> expdir;
    private List<Integer> api;
    private Ext ext;

    public Builder() {}

    public Builder width(final Integer width)
    {
      this.width = width;
      return this;
    }

    public Builder height(final Integer height)
    {
      this.height = height;
      return this;
    }

    public Builder wmax(final Integer wmax)
    {
      this.wmax = wmax;
      return this;
    }

    public Builder hmax(final Integer hmax)
    {
      this.hmax = hmax;
      return this;
    }

    public Builder wmin(final Integer wmin)
    {
      this.wmin = wmin;
      return this;
    }

    public Builder hmin(final Integer hmin)
    {
      this.hmin = hmin;
      return this;
    }

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder pos(final Integer pos)
    {
      this.pos = pos;
      return this;
    }

    public Builder btype(final List<Integer> btype)
    {
      this.btype = btype;
      return this;
    }

    public Builder battr(final List<Integer> battr)
    {
      this.battr = battr;
      return this;
    }

    public Builder mimes(final List<String> mimes)
    {
      this.mimes = mimes;
      return this;
    }

    public Builder topframe(final Integer topframe)
    {
      this.topframe = topframe;
      return this;
    }

    public Builder expdir(final List<Integer> expdir)
    {
      this.expdir = expdir;
      return this;
    }

    public Builder api(final List<Integer> api)
    {
      this.api = api;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Banner build()
    {
      return new Banner(
          width,
          height,
          wmax,
          hmax,
          wmin,
          hmin,
          id,
          pos,
          btype,
          battr,
          mimes,
          topframe,
          expdir,
          api,
          ext
      );
    }
  }

}
