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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TitleRequest
{
  private final Integer len;
  private final Ext ext;

  public TitleRequest(
      @JsonProperty("len") Integer len,
      @JsonProperty("ext") Ext ext
  )
  {
    this.len = len;
    this.ext = ext;
  }

  @JsonProperty
  public Integer getLen()
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
    private Integer len;
    private Ext ext;

    public Builder() {}

    public Builder len(final Integer len)
    {
      this.len = len;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public TitleRequest build()
    {
      return new TitleRequest(len, ext);
    }
  }
}
