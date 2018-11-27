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
public class Video
{
  private final List<String> mimes;
  private final Integer minDuration;
  private final Integer maxDuration;
  private final Integer protocol;
  private final List<Integer> protocols;
  private final Integer width;
  private final Integer height;
  private final Integer startDelay;
  private final Integer linearity;
  private final Integer sequence;
  private final List<Integer> battr;
  private final Integer maxExtended;
  private final Integer minBitrate;
  private final Integer maxBitrate;
  private final Integer boxingAllowed;
  private final List<Integer> playbackMethod;
  private final List<Integer> delivery;
  private final Integer pos;
  private final List<Banner> companionAd;
  private final List<Integer> api;
  private final List<Integer> companionType;
  private final Ext ext;

  public Video(
      @JsonProperty("mimes") List<String> mimes,
      @JsonProperty("minduration") Integer minDuration,
      @JsonProperty("maxduration") Integer maxDuration,
      @JsonProperty("protocol") Integer protocol,
      @JsonProperty("protocols") List<Integer> protocols,
      @JsonProperty("w") Integer width,
      @JsonProperty("h") Integer height,
      @JsonProperty("startdelay") Integer startDelay,
      @JsonProperty("linearity") Integer linearity,
      @JsonProperty("sequence") Integer sequence,
      @JsonProperty("battr") List<Integer> battr,
      @JsonProperty("maxextended") Integer maxExtended,
      @JsonProperty("minbitrate") Integer minBitrate,
      @JsonProperty("maxbitrate") Integer maxBitrate,
      @JsonProperty("boxingallowed") Integer boxingAllowed,
      @JsonProperty("playbackmethod") List<Integer> playbackMethod,
      @JsonProperty("delivery") List<Integer> delivery,
      @JsonProperty("pos") Integer pos,
      @JsonProperty("companionad") List<Banner> companionAd,
      @JsonProperty("api") List<Integer> api,
      @JsonProperty("companiontype") List<Integer> companionType,
      @JsonProperty("ext") Ext ext
  )
  {
    this.mimes = mimes;
    this.minDuration = minDuration;
    this.maxDuration = maxDuration;
    this.protocol = protocol;
    this.protocols = protocols;
    this.width = width;
    this.height = height;
    this.startDelay = startDelay;
    this.linearity = linearity;
    this.sequence = sequence;
    this.battr = battr;
    this.maxExtended = maxExtended;
    this.minBitrate = minBitrate;
    this.maxBitrate = maxBitrate;
    this.boxingAllowed = boxingAllowed;
    this.playbackMethod = playbackMethod;
    this.delivery = delivery;
    this.pos = pos;
    this.companionAd = companionAd;
    this.api = api;
    this.companionType = companionType;
    this.ext = ext;
  }

  @JsonProperty
  public List<String> getMimes()
  {
    return mimes;
  }

  @JsonProperty("minduration")
  public Integer getMinDuration()
  {
    return minDuration;
  }

  @JsonProperty("maxduration")
  public Integer getMaxDuration()
  {
    return maxDuration;
  }

  @JsonProperty
  public Integer getProtocol()
  {
    return protocol;
  }

  @JsonProperty
  public List<Integer> getProtocols()
  {
    return protocols;
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

  @JsonProperty("startdelay")
  public Integer getStartDelay()
  {
    return startDelay;
  }

  public Integer getLinearity()
  {
    return linearity;
  }

  @JsonProperty
  public Integer getSequence()
  {
    return sequence;
  }

  @JsonProperty
  public List<Integer> getBattr()
  {
    return battr;
  }

  @JsonProperty("maxextended")
  public Integer getMaxExtended()
  {
    return maxExtended;
  }

  @JsonProperty("minbitrate")
  public Integer getMinBitrate()
  {
    return minBitrate;
  }

  @JsonProperty("maxbitrate")
  public Integer getMaxBitrate()
  {
    return maxBitrate;
  }

  @JsonProperty("boxingallowed")
  public Integer getBoxingAllowed()
  {
    return boxingAllowed;
  }

  @JsonProperty("playbackmethod")
  public List<Integer> getPlaybackMethod()
  {
    return playbackMethod;
  }

  @JsonProperty
  public List<Integer> getDelivery()
  {
    return delivery;
  }

  @JsonProperty
  public Integer getPos()
  {
    return pos;
  }

  @JsonProperty("companionad")
  public List<Banner> getCompanionAd()
  {
    return companionAd;
  }

  @JsonProperty
  public List<Integer> getApi()
  {
    return api;
  }

  @JsonProperty("companionType")
  public List<Integer> getCompanionType()
  {
    return companionType;
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
    private List<String> mimes;
    private Integer minDuration;
    private Integer maxDuration;
    private Integer protocol;
    private List<Integer> protocols;
    private Integer width;
    private Integer height;
    private Integer startDelay;
    private Integer linearity;
    private Integer sequence;
    private List<Integer> battr;
    private Integer maxExtended;
    private Integer minBitrate;
    private Integer maxBitrate;
    private Integer boxingAllowed;
    private List<Integer> playbackMethod;
    private List<Integer> delivery;
    private Integer pos;
    private List<Banner> companionAd;
    private List<Integer> api;
    private List<Integer> companionType;
    private Ext ext;

    public Builder() {}

    public Builder mimes(final List<String> mimes)
    {
      this.mimes = mimes;
      return this;
    }

    public Builder minDuration(final Integer minDuration)
    {
      this.minDuration = minDuration;
      return this;
    }

    public Builder maxDuration(final Integer maxDuration)
    {
      this.maxDuration = maxDuration;
      return this;
    }

    public Builder protocol(final Integer protocol)
    {
      this.protocol = protocol;
      return this;
    }

    public Builder protocols(final List<Integer> protocols)
    {
      this.protocols = protocols;
      return this;
    }

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

    public Builder startDelay(final Integer startDelay)
    {
      this.startDelay = startDelay;
      return this;
    }

    public Builder linearity(final Integer linearity)
    {
      this.linearity = linearity;
      return this;
    }

    public Builder sequence(final Integer sequence)
    {
      this.sequence = sequence;
      return this;
    }

    public Builder battr(final List<Integer> battr)
    {
      this.battr = battr;
      return this;
    }

    public Builder maxExtended(final Integer maxExtended)
    {
      this.maxExtended = maxExtended;
      return this;
    }

    public Builder minBitrate(final Integer minBitrate)
    {
      this.minBitrate = minBitrate;
      return this;
    }

    public Builder maxBitrate(final Integer maxBitrate)
    {
      this.maxBitrate = maxBitrate;
      return this;
    }

    public Builder boxingAllowed(final Integer boxingAllowed)
    {
      this.boxingAllowed = boxingAllowed;
      return this;
    }

    public Builder playbackMethod(final List<Integer> playbackMethod)
    {
      this.playbackMethod = playbackMethod;
      return this;
    }

    public Builder delivery(final List<Integer> delivery)
    {
      this.delivery = delivery;
      return this;
    }

    public Builder pos(final Integer pos)
    {
      this.pos = pos;
      return this;
    }

    public Builder companionAd(final List<Banner> companionAd)
    {
      this.companionAd = companionAd;
      return this;
    }

    public Builder api(final List<Integer> api)
    {
      this.api = api;
      return this;
    }

    public Builder companionType(final List<Integer> companionType)
    {
      this.companionType = companionType;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Video build()
    {
      return new Video(
          mimes,
          minDuration,
          maxDuration,
          protocol,
          protocols,
          width,
          height,
          startDelay,
          linearity,
          sequence,
          battr,
          maxExtended,
          minBitrate,
          maxBitrate,
          boxingAllowed,
          playbackMethod,
          delivery,
          pos,
          companionAd,
          api,
          companionType,
          ext
      );
    }
  }
}
