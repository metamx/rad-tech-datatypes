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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BidResponse
{
  private final String id;
  private final List<SeatBid> seatBid;
  private final String bidId;
  private final String cur;
  private final String customData;
  private final Integer nbr;
  private final Ext ext;

  public BidResponse(
      @JsonProperty("id") String id,
      @JsonProperty("seatbid") List<SeatBid> seatBid,
      @JsonProperty("bidid") String bidId,
      @JsonProperty("cur") String cur,
      @JsonProperty("customdata") String customData,
      @JsonProperty("nbr") Integer nbr,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.seatBid = seatBid;
    this.bidId = bidId;
    this.cur = cur;
    this.customData = customData;
    this.nbr = nbr;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty("seatbid")
  public List<SeatBid> getSeatBid()
  {
    return seatBid;
  }

  @JsonProperty("bidid")
  public String getBidId()
  {
    return bidId;
  }

  @JsonProperty
  public String getCur()
  {
    return cur;
  }

  @JsonProperty("customdata")
  public String getCustomData()
  {
    return customData;
  }

  @JsonProperty
  public Integer getNbr()
  {
    return nbr;
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
    private List<SeatBid> seatBid;
    private String bidId;
    private String cur;
    private String customData;
    private Integer nbr;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder seatBid(final List<SeatBid> seatBid)
    {
      this.seatBid = seatBid;
      return this;
    }

    public Builder bidId(final String bidId)
    {
      this.bidId = bidId;
      return this;
    }

    public Builder cur(final String cur)
    {
      this.cur = cur;
      return this;
    }

    public Builder customData(final String customData)
    {
      this.customData = customData;
      return this;
    }

    public Builder nbr(final Integer nbr)
    {
      this.nbr = nbr;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public BidResponse build()
    {
      return new BidResponse(
          id,
          seatBid,
          bidId,
          cur,
          customData,
          nbr,
          ext
      );
    }
  }
}
