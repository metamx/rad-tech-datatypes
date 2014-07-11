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
  private final String city;
  private final String country;
  private final String region;
  private final String zip;
  private final String metro;
  private final Integer type;
  private final Double lat;
  private final Double lon;
  private final Ext ext;

  public Geo(
      @JsonProperty("city") String city,
      @JsonProperty("country") String country,
      @JsonProperty("region") String region,
      @JsonProperty("zip") String zip,
      @JsonProperty("metro") String metro,
      @JsonProperty("type") Integer type,
      @JsonProperty("lat") Double lat,
      @JsonProperty("lon") Double lon,
      @JsonProperty("ext") Ext ext
  )
  {
    this.city = city;
    this.country = country;
    this.region = region;
    this.zip = zip;
    this.metro = metro;
    this.type = type;
    this.lat = lat;
    this.lon = lon;
    this.ext = ext;
  }

  @JsonProperty
  public String getCity()
  {
    return city;
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
  public String getZip()
  {
    return zip;
  }

  @JsonProperty
  public String getMetro()
  {
    return metro;
  }

  @JsonProperty
  public Integer getType()
  {
    return type;
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
    private String city;
    private String country;
    private String region;
    private String zip;
    private String metro;
    private Integer type;
    private Double lat;
    private Double lon;
    private Ext ext;

    public Builder() {}

    public Builder city(final String city)
    {
      this.city = city;
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

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Geo build()
    {
      return new Geo(city, country, region, zip, metro, type, lat, lon, ext);
    }
  }
}
