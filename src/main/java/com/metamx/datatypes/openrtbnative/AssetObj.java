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
import com.metamx.datatypes.openrtb.Video;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AssetObj
{
  private final int id;
  private final int req;
  private final TitleReq title;
  private final ImgReq imgReq;
  private final Video video;
  private final DataReq dataReq;
  private final Ext ext;

  public AssetObj(
      @JsonProperty("id") int id,
      @JsonProperty("req") int req,
      @JsonProperty("title") TitleReq title,
      @JsonProperty("img") ImgReq imgReq,
      @JsonProperty("video") Video video,
      @JsonProperty("data") DataReq dataReq,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.req = req;
    this.title = title;
    this.imgReq = imgReq;
    this.video = video;
    this.dataReq = dataReq;
    this.ext = ext;
  }

  @JsonProperty
  public int getId()
  {
    return id;
  }

  @JsonProperty
  public int getReq()
  {
    return req;
  }

  @JsonProperty
  public TitleReq getTitle()
  {
    return title;
  }

  @JsonProperty
  public ImgReq getImgReq()
  {
    return imgReq;
  }

  @JsonProperty
  public Video getVideo()
  {
    return video;
  }

  @JsonProperty
  public DataReq getDataReq()
  {
    return dataReq;
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
    private int id;
    private int req;
    private TitleReq title;
    private ImgReq imgReq;
    private Video video;
    private DataReq dataReq;
    private Ext ext;

    public Builder() {}

    public Builder id(final int id)
    {
      this.id = id;
      return this;
    }

    public Builder req(final int req)
    {
      this.req = req;
      return this;
    }

    public Builder title(final TitleReq title)
    {
      this.title = title;
      return this;
    }

    public Builder img(final ImgReq imgReq)
    {
      this.imgReq = imgReq;
      return this;
    }

    public Builder video(final Video video)
    {
      this.video = video;
      return this;
    }

    public Builder data(final DataReq dataReq)
    {
      this.dataReq = dataReq;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public AssetObj build()
    {
      return new AssetObj(
          id,
          req,
          title,
          imgReq,
          video,
          dataReq,
          ext
      );
    }
  }

}
