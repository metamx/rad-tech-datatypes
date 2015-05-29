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
public class DataRequest
{
  private final int type;
  private final int len;
  private final Ext ext;

  public DataRequest(
      @JsonProperty("type") int type,
      @JsonProperty("len") int len,
      @JsonProperty("ext") Ext ext
  )
  {
    this.type = type;
    this.len = len;
    this.ext = ext;
  }

  @JsonProperty
  public int getType()
  {
    return type;
  }

  @JsonProperty
  public int getLen()
  {
    return len;
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
    private int type;
    private int len;
    private Ext ext;

    public Builder() {}

    public Builder type(final int type)
    {
      this.type = type;
      return this;
    }

    public Builder len(final int len)
    {
      this.len = len;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public DataRequest build()
    {
      return new DataRequest(
          type,
          len,
          ext
      );
    }
  }

}