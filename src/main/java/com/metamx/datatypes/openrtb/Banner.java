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
  private final Integer height;
  private final Integer width;
  private final Integer pos;
  private final List<Integer> apiFrameworks;
  private final Ext ext;

  public Banner(
      @JsonProperty("h") Integer height,
      @JsonProperty("w") Integer width,
      @JsonProperty("pos") Integer pos,
      @JsonProperty("api") List<Integer> apiFrameworks,
      @JsonProperty("ext") Ext ext
  )
  {
    this.height = height;
    this.width = width;
    this.pos = pos;
    this.apiFrameworks = apiFrameworks;
    this.ext = ext;
  }

  @JsonProperty("h")
  public Integer getHeight()
  {
    return height;
  }

  @JsonProperty("w")
  public Integer getWidth()
  {
    return width;
  }

  @JsonProperty
  public Integer getPos()
  {
    return pos;
  }

  @JsonProperty("api")
  public List<Integer> getApiFrameworks()
  {
    return apiFrameworks;
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
    private Integer height;
    private Integer width;
    private Integer pos;
    private List<Integer> apiFrameworks;
    private Ext ext;

    public Builder() {}

    public Builder height(final Integer height)
    {
      this.height = height;
      return this;
    }

    public Builder width(final Integer width)
    {
      this.width = width;
      return this;
    }

    public Builder pos(final Integer pos)
    {
      this.pos = pos;
      return this;
    }

    public Builder apiFrameworks(final List<Integer> apiFrameworks)
    {
      this.apiFrameworks = apiFrameworks;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Banner build()
    {
      return new Banner(height, width, pos, apiFrameworks, ext);
    }
  }

}
