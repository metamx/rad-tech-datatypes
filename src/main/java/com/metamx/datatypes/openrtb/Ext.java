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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Ext
{
  private final Map<String, Object> values;

  private Ext(
      Map<String, Object> values
  )
  {
    this.values = values;
  }

  @JsonCreator
  private static Ext fromMap(Map<String, Object> map) {
    return new Ext(map);
  }

  @JsonValue
  public Map<String, Object> getValues() {
    return values;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private Map<String, Object> values = new HashMap<String, Object>();

    public Builder() {}

    public Builder put(String k, String v)
    {
      this.values.put(k, v);
      return this;
    }

    public Builder put(String k, int v)
    {
      this.values.put(k, v);
      return this;
    }

    public Builder put(String k, double v)
    {
      this.values.put(k, v);
      return this;
    }

    public Builder put(String k, List<String> v)
    {
      this.values.put(k, v);
      return this;
    }

    public Ext build()
    {
      return new Ext(values);
    }
  }

}
