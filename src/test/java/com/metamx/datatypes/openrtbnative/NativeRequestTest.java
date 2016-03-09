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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metamx.datatypes.openrtb.App;
import com.metamx.datatypes.openrtb.Banner;
import com.metamx.datatypes.openrtb.BidRequest;
import com.metamx.datatypes.openrtb.Content;
import com.metamx.datatypes.openrtb.Data;
import com.metamx.datatypes.openrtb.Deals;
import com.metamx.datatypes.openrtb.Device;
import com.metamx.datatypes.openrtb.Ext;
import com.metamx.datatypes.openrtb.Geo;
import com.metamx.datatypes.openrtb.Imp;
import com.metamx.datatypes.openrtb.Pmp;
import com.metamx.datatypes.openrtb.Producer;
import com.metamx.datatypes.openrtb.Publisher;
import com.metamx.datatypes.openrtb.Regs;
import com.metamx.datatypes.openrtb.Segment;
import com.metamx.datatypes.openrtb.Site;
import com.metamx.datatypes.openrtb.User;
import com.metamx.datatypes.openrtb.Video;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NativeRequestTest
{
  class NestedObject {
    private String id;
    NestedObject(String id) {
      this.id  = id;
    }

    @JsonProperty
    public String getId() {
      return id;
    }
  }

  final Ext sampleExt = Ext.builder()
                           .put("sample_str", "Test String")
                           .put("sample_int", 1)
                           .put("sample_double", 2.0)
                           .put("sample_str_list", Arrays.asList("test1", "test2"))
                           .put("sample_nested_object", Arrays.asList(new NestedObject("1"), new NestedObject("2")))
                           .build();

  final TitleRequest sampleTitle = TitleRequest.builder()
                                               .len(32)
                                               .build();

  final ImageRequest sampleImage = ImageRequest.builder()
                                        .type(4)
                                        .w(200)
                                        .wmin(180)
                                        .h(320)
                                        .hmin(300)
                                        .mimes(Arrays.asList("image/jpg","image/gif"))
                                        .build();

  final VideoRequest sampleVideo = VideoRequest.builder()
                                               .mimes(Arrays.asList("image/jpg", "image/gif"))
                                               .minduration(4)
                                               .maxduration(40)
                                               .protocols(Arrays.asList(4, 5))
                                               .build();

  final DataRequest sampleData = DataRequest.builder()
                                            .type(3)
                                            .len(32)
                                            .build();

  final AssetRequest sampleAssets = AssetRequest.builder()
                                                .id(35)
                                                .required(0)
                                                .title(sampleTitle)
                                                .img(sampleImage)
                                                .video(sampleVideo)
                                                .data(sampleData)
                                                .build();

  final NativeRequest sampleNative = NativeRequest.builder()
                           .ver("1")
                           .layout(5)
                           .adunit(2)
                           .plcmtcnt(8)
                           .seq(0)
                           .assets(
                               Arrays.asList(
                                   AssetRequest.builder()
                                               .id(35)
                                               .required(0)
                                               .title(sampleTitle)
                                               .img(sampleImage)
                                               .video(sampleVideo)
                                               .data(sampleData)
                                               .build()
                               )
                           )
                           .ext(sampleExt)
                           .build();

  @Test
  public void printJson() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(sampleNative));
  }

  final String extJson = "{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_nested_object\":[{\"id\":\"1\"},{\"id\":\"2\"}],\"sample_double\":2.0}";
  final String titleJson = "{\"len\":32}";
  final String imageJson = "{\"type\":4,\"w\":200,\"wmin\":180,\"h\":320,\"hmin\":300,\"mimes\":[\"image/jpg\",\"image/gif\"]}";
  final String videoJson = "{\"mimes\":[\"image/jpg\",\"image/gif\"],\"minduration\":4,\"maxduration\":40,\"protocols\":[4,5]}";
  final String dataJson = "{\"type\":3,\"len\":32}";
  final String assetsJson = "{\"id\":35,\"required\":0,\"title\":{\"len\":32},\"img\":{\"type\":4,\"w\":200,\"wmin\":180,\"h\":320,\"hmin\":300,\"mimes\":[\"image/jpg\",\"image/gif\"]},\"video\":{\"mimes\":[\"image/jpg\",\"image/gif\"],\"minduration\":4,\"maxduration\":40,\"protocols\":[4,5]},\"data\":{\"type\":3,\"len\":32}}";
  final String nativeJson = "{\"ver\":\"1\",\"layout\":5,\"adunit\":2,\"plcmtcnt\":8,\"seq\":0,\"assets\":[{\"id\":35,\"required\":0,\"title\":{\"len\":32},\"img\":{\"type\":4,\"w\":200,\"wmin\":180,\"h\":320,\"hmin\":300,\"mimes\":[\"image/jpg\",\"image/gif\"]},\"video\":{\"mimes\":[\"image/jpg\",\"image/gif\"],\"minduration\":4,\"maxduration\":40,\"protocols\":[4,5]},\"data\":{\"type\":3,\"len\":32}}],\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_nested_object\":[{\"id\":\"1\"},{\"id\":\"2\"}],\"sample_double\":2.0}} ";

  @Test
  public void testSerializationByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    Assert.assertEquals(extJson, objectMapper.writeValueAsString(sampleExt));
    Assert.assertEquals(titleJson, objectMapper.writeValueAsString(sampleTitle));
    Assert.assertEquals(imageJson, objectMapper.writeValueAsString(sampleImage));
    Assert.assertEquals(videoJson, objectMapper.writeValueAsString(sampleVideo));
    Assert.assertEquals(dataJson, objectMapper.writeValueAsString(sampleData));
    Assert.assertEquals(assetsJson, objectMapper.writeValueAsString(sampleAssets));
    Assert.assertEquals(nativeJson, objectMapper.writeValueAsString(sampleNative));
  }

  @Test
  public void testRoundTripByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    final String roundTripExtJson = objectMapper.writeValueAsString(
        objectMapper.readValue(extJson, Ext.class)
    );
    Assert.assertEquals(extJson, roundTripExtJson);

    final String roundTripTitleJson = objectMapper.writeValueAsString(
        objectMapper.readValue(titleJson, TitleRequest.class)
    );
    Assert.assertEquals(titleJson, roundTripTitleJson);

    final String roundTripImageJson = objectMapper.writeValueAsString(
        objectMapper.readValue(imageJson, ImageRequest.class)
    );
    Assert.assertEquals(imageJson, roundTripImageJson);

    final String roundTripVideoJson = objectMapper.writeValueAsString(
        objectMapper.readValue(videoJson, VideoRequest.class)
    );
    Assert.assertEquals(videoJson, roundTripVideoJson);

    final String roundTripDataJson = objectMapper.writeValueAsString(
        objectMapper.readValue(dataJson, DataRequest.class)
    );
    Assert.assertEquals(dataJson, roundTripDataJson);

    final String roundTripAssetsJson = objectMapper.writeValueAsString(
        objectMapper.readValue(assetsJson, AssetRequest.class)
    );
    Assert.assertEquals(assetsJson, roundTripAssetsJson);

    final String roundTripNativeJson = objectMapper.writeValueAsString(
        objectMapper.readValue(nativeJson, NativeRequest.class)
    );
    Assert.assertEquals(nativeJson, roundTripNativeJson);

  }

}
