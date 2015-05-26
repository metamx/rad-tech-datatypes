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

package com.metamx.datatypes.mmx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metamx.datatypes.openrtb.Ext;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MmxBidResponse
{
  private final String timestamp;
  private final Integer status;
  private final Long totalDuration;
  private final String bidderId;
  private final String bidderName;
  private final String cur;
  private final List<MmxSeatBid> seatBid;
  private final Integer nbr;
  private final Ext ext;

  public MmxBidResponse(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("bidder_id") String bidderId,
      @JsonProperty("bidder_name") String bidderName,
      @JsonProperty("status") Integer status,
      @JsonProperty("total_duration") Long totalDuration,
      @JsonProperty("cur") String cur,
      @JsonProperty("seatbid") List<MmxSeatBid> seatBid,
      @JsonProperty("nbr") Integer nbr,
      @JsonProperty("ext") Ext ext
  )
  {
    this.timestamp = timestamp;
    this.status = status;
    this.totalDuration = totalDuration;
    this.bidderId = bidderId;
    this.bidderName = bidderName;
    this.cur = cur;
    this.seatBid = seatBid;
    this.nbr = nbr;
    this.ext = ext;
  }

  @JsonProperty
  public String getTimestamp()
  {
    return timestamp;
  }

  @JsonProperty
  public Integer getStatus()
  {
    return status;
  }

  @JsonProperty("total_duration")
  public Long getTotalDuration()
  {
    return totalDuration;
  }

  @JsonProperty("bidder_id")
  public String getBidderId()
  {
    return bidderId;
  }

  @JsonProperty("bidder_name")
  public String getBidderName()
  {
    return bidderName;
  }

  @JsonProperty
  public String getCur()
  {
    return cur;
  }

  @JsonProperty("seatbid")
  public List<MmxSeatBid> getSeatBid()
  {
    return seatBid;
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
    private DateTime timestamp;
    private Integer status;
    private Long totalDuration;
    private String bidderId;
    private String bidderName;
    private String cur;
    private List<MmxSeatBid> seatBid;
    private Integer nbr;
    private Ext ext;

    public Builder() {}

    public Builder timestamp(final DateTime timestamp)
    {
      this.timestamp = timestamp;
      return this;
    }

    public Builder status(final Integer status)
    {
      this.status = status;
      return this;
    }

    public Builder totalDuration(final Long totalDuration)
    {
      this.totalDuration = totalDuration;
      return this;
    }

    public Builder bidderId(final String bidderId)
    {
      this.bidderId = bidderId;
      return this;
    }

    public Builder bidderName(final String bidderName)
    {
      this.bidderName = bidderName;
      return this;
    }

    public Builder cur(final String cur)
    {
      this.cur = cur;
      return this;
    }

    public Builder seatBid(final List<MmxSeatBid> seatBid)
    {
      this.seatBid = seatBid;
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

    public MmxBidResponse build()
    {
      return new MmxBidResponse(
          timestamp.withZone(DateTimeZone.UTC).toString(),
          bidderId,
          bidderName,
          status,
          totalDuration,
          cur,
          seatBid,
          nbr,
          ext
      );
    }
  }
}
