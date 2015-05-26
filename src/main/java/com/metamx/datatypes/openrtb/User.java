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
public class User
{
  private final String id;
  private final String buyeruid;
  private final Integer yob;
  private final String gender;
  private final String keywords;
  private final String customData;
  private final Geo geo;
  private final List<Data> data;
  private final Ext ext;

  public User(
      @JsonProperty("id") String id,
      @JsonProperty("buyerid") String buyerid,
      @JsonProperty("yob") Integer yob,
      @JsonProperty("gender") String gender,
      @JsonProperty("keywords") String keywords,
      @JsonProperty("customdata") String customData,
      @JsonProperty("geo") Geo geo,
      @JsonProperty("data") List<Data> data,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.buyeruid = buyerid;
    this.yob = yob;
    this.gender = gender;
    this.keywords = keywords;
    this.customData = customData;
    this.geo = geo;
    this.data = data;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty
  public String getBuyeruid()
  {
    return buyeruid;
  }

  @JsonProperty
  public Integer getYob()
  {
    return yob;
  }

  @JsonProperty
  public String getGender()
  {
    return gender;
  }

  @JsonProperty
  public String getKeywords()
  {
    return keywords;
  }

  @JsonProperty("customdata")
  public String getCustomData()
  {
    return customData;
  }

  @JsonProperty
  public Geo getGeo()
  {
    return geo;
  }

  @JsonProperty
  public List<Data> getData()
  {
    return data;
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
    private String id;
    private String buyeruid;
    private Integer yob;
    private String gender;
    private String keywords;
    private String customData;
    private Geo geo;
    private List<Data> data;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder buyeruid(final String buyeruid)
    {
      this.buyeruid = buyeruid;
      return this;
    }

    public Builder yob(final Integer yob)
    {
      this.yob = yob;
      return this;
    }

    public Builder gender(final String gender)
    {
      this.gender = gender;
      return this;
    }

    public Builder keywords(final String keywords)
    {
      this.keywords = keywords;
      return this;
    }

    public Builder customData(final String customData)
    {
      this.customData = customData;
      return this;
    }

    public Builder geo(final Geo geo)
    {
      this.geo = geo;
      return this;
    }

    public Builder data(final List<Data> data)
    {
      this.data = data;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public User build()
    {
      return new User(id, buyeruid, yob, gender, keywords, customData, geo, data, ext);
    }
  }
}
