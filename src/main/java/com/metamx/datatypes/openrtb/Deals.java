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
public class Deals
{
  private final String id;
  private final Double bidFloor;
  private final String bidFloorCur;
  private final List<String> wseat;
  private final List<String> wadomain;
  private final Integer auctionType;
  private final Ext ext;

  public Deals(
      @JsonProperty("id") String id,
      @JsonProperty("bidfloor") Double bidFloor,
      @JsonProperty("bidfloorcur") String bidFloorCur,
      @JsonProperty("wseat") List<String> wseat,
      @JsonProperty("wadomain") List<String> wadomain,
      @JsonProperty("at") Integer auctionType,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.bidFloor = bidFloor;
    this.bidFloorCur = bidFloorCur;
    this.wseat = wseat;
    this.wadomain = wadomain;
    this.auctionType = auctionType;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty("bidfloor")
  public Double getBidFloor()
  {
    return bidFloor;
  }

  @JsonProperty("bidfloorcur")
  public String getBidFloorCur()
  {
    return bidFloorCur;
  }

  @JsonProperty
  public List<String> getWseat()
  {
    return wseat;
  }

  @JsonProperty
  public List<String> getWadomain()
  {
    return wadomain;
  }

  @JsonProperty("at")
  public Integer getAuctionType()
  {
    return auctionType;
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
    private Double bidFloor;
    private String bidFloorCur;
    private List<String> wseat;
    private List<String> wadomain;
    private Integer auctionType;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder bidFloor(final Double bidFloor)
    {
      this.bidFloor = bidFloor;
      return this;
    }

    public Builder bidFloorCur(final String bidFloorCur)
    {
      this.bidFloorCur = bidFloorCur;
      return this;
    }

    public Builder wseat(final List<String> wseat)
    {
      this.wseat = wseat;
      return this;
    }

    public Builder wadomain(final List<String> wadomain)
    {
      this.wadomain = wadomain;
      return this;
    }

    public Builder auctionType(final Integer auctionType)
    {
      this.auctionType = auctionType;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Deals build()
    {
      return new Deals(id, bidFloor, bidFloorCur, wseat, wadomain, auctionType, ext);
    }
  }
}
