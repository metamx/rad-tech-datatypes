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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Geo
{
  private final Double lat;
  private final Double lon;
  private final String country;
  private final String region;
  private final String regionfips104;
  private final String metro;
  private final String city;
  private final String zip;
  private final Integer type;
  private final Ext ext;

  public Geo(
      @JsonProperty("lat") Double lat,
      @JsonProperty("lon") Double lon,
      @JsonProperty("country") String country,
      @JsonProperty("region") String region,
      @JsonProperty("regionfips104") String regionfips104,
      @JsonProperty("metro") String metro,
      @JsonProperty("city") String city,
      @JsonProperty("zip") String zip,
      @JsonProperty("type") Integer type,
      @JsonProperty("ext") Ext ext
  )
  {
    this.lat = lat;
    this.lon = lon;
    this.country = country;
    this.region = region;
    this.regionfips104 = regionfips104;
    this.metro = metro;
    this.city = city;
    this.zip = zip;
    this.type = type;
    this.ext = ext;
  }

  @JsonProperty
  public Double getLat()
  {
    return lat;
  }

  @JsonProperty
  public Double getLon()
  {
    return lon;
  }

  @JsonProperty
  public String getCountry()
  {
    return country;
  }

  @JsonProperty
  public String getRegion()
  {
    return region;
  }

  @JsonProperty
  public String getRegionfips104()
  {
    return regionfips104;
  }

  @JsonProperty
  public String getMetro()
  {
    return metro;
  }

  @JsonProperty
  public String getCity()
  {
    return city;
  }

  @JsonProperty
  public String getZip()
  {
    return zip;
  }

  @JsonProperty
  public Integer getType()
  {
    return type;
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
    private Double lat;
    private Double lon;
    private String country;
    private String region;
    private String regionfips104;
    private String metro;
    private String city;
    private String zip;
    private Integer type;
    private Ext ext;

    public Builder() {}

    public Builder lat(final Double lat)
    {
      this.lat = lat;
      return this;
    }

    public Builder lon(final Double lon)
    {
      this.lon = lon;
      return this;
    }

    public Builder country(final String country)
    {
      this.country = country;
      return this;
    }

    public Builder region(final String region)
    {
      this.region = region;
      return this;
    }

    public Builder regionfips104(final String regionfips104)
    {
      this.regionfips104 = regionfips104;
      return this;
    }

    public Builder city(final String city)
    {
      this.city = city;
      return this;
    }

    public Builder zip(final String zip)
    {
      this.zip = zip;
      return this;
    }

    public Builder metro(final String metro)
    {
      this.metro = metro;
      return this;
    }

    public Builder type(final Integer type)
    {
      this.type = type;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Geo build()
    {
      return new Geo(
          lat,
          lon,
          country,
          region,
          regionfips104,
          metro,
          city,
          zip,
          type,
          ext
      );
    }
  }
}
