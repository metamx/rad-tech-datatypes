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
public class Imp
{
  private final String id;
  private final Banner banner;
  private final Video video;
  private final Native nativeObj;
  private final String displayManager;
  private final String displayManagerVer;
  private final Integer instl;
  private final String tagId;
  private final Double bidFloor;
  private final String bidFloorCur;
  private final Integer secure;
  private final List<String> iframeBuster;
  private final Pmp pmp;
  private final Ext ext;

  public Imp(
      @JsonProperty("id") String id,
      @JsonProperty("banner") Banner banner,
      @JsonProperty("video") Video video,
      @JsonProperty("native") Native nativeObj,
      @JsonProperty("displaymanager") String displayManager,
      @JsonProperty("displaymanagerver") String displayManagerVer,
      @JsonProperty("instl") Integer instl,
      @JsonProperty("tagid") String tagId,
      @JsonProperty("bidfloor") Double bidFloor,
      @JsonProperty("bidfloorcur") String bidFloorCur,
      @JsonProperty("secure") Integer secure,
      @JsonProperty("iframebuster") List<String> iframeBuster,
      @JsonProperty("pmp") Pmp pmp,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.banner = banner;
    this.video = video;
    this.nativeObj = nativeObj;
    this.displayManager = displayManager;
    this.displayManagerVer = displayManagerVer;
    this.instl = instl;
    this.tagId = tagId;
    this.bidFloor = bidFloor;
    this.bidFloorCur = bidFloorCur;
    this.secure = secure;
    this.iframeBuster = iframeBuster;
    this.pmp = pmp;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty
  public Banner getBanner()
  {
    return banner;
  }

  @JsonProperty
  public Video getVideo()
  {
    return video;
  }

  @JsonProperty
  public Native getNativeObj()
  {
    return nativeObj;
  }

  @JsonProperty("displaymanager")
  public String getDisplayManager()
  {
    return displayManager;
  }

  @JsonProperty("displaymanagerver")
  public String getDisplayManagerVer()
  {
    return displayManagerVer;
  }

  @JsonProperty
  public Integer getInstl()
  {
    return instl;
  }

  @JsonProperty("tagid")
  public String getTagId()
  {
    return tagId;
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
  public Integer getSecure()
  {
    return secure;
  }

  @JsonProperty("iframebuster")
  public List<String> getIframeBuster()
  {
    return iframeBuster;
  }

  @JsonProperty
  public Pmp getPmp()
  {
    return pmp;
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
    private Banner banner;
    private Video video;
    private Native nativeObj;
    private String displayManager;
    private String displayManagerVer;
    private Integer instl;
    private String tagId;
    private Double bidFloor;
    private String bidFloorCur;
    private Integer secure;
    private List<String> iframebuster;
    private Pmp pmp;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder banner(final Banner banner)
    {
      this.banner = banner;
      return this;
    }

    public Builder video(final Video video)
    {
      this.video = video;
      return this;
    }

    public Builder nativeObj(final Native nativeObj)
    {
      this.nativeObj = nativeObj;
      return this;
    }

    public Builder displayManager(final String displayManager)
    {
      this.displayManager = displayManager;
      return this;
    }

    public Builder displayManagerVer(final String displayManagerVer)
    {
      this.displayManagerVer = displayManagerVer;
      return this;
    }

    public Builder instl(final Integer instl)
    {
      this.instl = instl;
      return this;
    }

    public Builder tagId(final String tagId)
    {
      this.tagId = tagId;
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

    public Builder secure(final Integer secure)
    {
      this.secure = secure;
      return this;
    }

    public Builder iframebuster(final List<String> iframebuster)
    {
      this.iframebuster = iframebuster;
      return this;
    }

    public Builder pmp(final Pmp pmp)
    {
      this.pmp = pmp;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Imp build()
    {
      return new Imp(
          id,
          banner,
          video,
          nativeObj,
          displayManager,
          displayManagerVer,
          instl,
          tagId,
          bidFloor,
          bidFloorCur,
          secure,
          iframebuster,
          pmp,
          ext
      );
    }
  }
}
