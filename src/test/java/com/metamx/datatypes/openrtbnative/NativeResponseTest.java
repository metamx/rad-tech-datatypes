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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metamx.datatypes.openrtb.Ext;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NativeResponseTest
{

  final Ext sampleExt = Ext.builder()
                           .put("sample_str", "Test String")
                           .put("sample_int", 1)
                           .put("sample_double", 2.0)
                           .put("sample_str_list", Arrays.asList("test1", "test2"))
                           .build();

  final TitleResponse sampleTitle = TitleResponse.builder()
                                               .text("threetwo")
                                               .build();

  final ImageResponse sampleImage = ImageResponse.builder()
                                        .url("4")
                                        .w(200)
                                        .h(320)
                                        .build();

  final VideoResponse sampleVideo = VideoResponse.builder()
                                               .vasttag("xml")
                                               .build();

  final DataResponse sampleData = DataResponse.builder()
                                            .label("xz")
                                            .value("49")
                                            .build();

  final Link sampleLink = Link.builder()
                              .url("3")
                              .clicktrackers(Arrays.asList("32", "34"))
                              .fallback("hah.com")
                              .build();

  final AssetResponse sampleAssets = AssetResponse.builder()
                                                .id(35)
                                                .required(0)
                                                .title(sampleTitle)
                                                .img(sampleImage)
                                                .video(sampleVideo)
                                                .data(sampleData)
                                                .link(sampleLink)
                                                .build();

  final NativeResponse sampleNative = NativeResponse.builder()
                                                    .ver("1")
                                                    .assets(
                                                        Arrays.asList(
                                                            AssetResponse.builder()
                                                                         .id(35)
                                                                         .required(0)
                                                                         .title(sampleTitle)
                                                                         .img(sampleImage)
                                                                         .video(sampleVideo)
                                                                         .data(sampleData)
                                                                         .build()
                                                        )
                                                    )
                                                    .link(sampleLink)
                                                    .imptrackers(Arrays.asList("abc","1234"))
                                                    .jstracker("8")
                                                    .ext(sampleExt)
                           .build();

  final NativeAdCreative sampleCreative = NativeAdCreative.builder()
                          .nativeobj(sampleNative)
                          .build();

  @Test
  public void printJson() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(sampleNative));
  }

  final String extJson = "{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}";
  final String titleJson = "{\"text\":\"threetwo\"}";
  final String linkJson = "{\"url\":\"3\",\"clicktrackers\":[\"32\",\"34\"],\"fallback\":\"hah.com\"}";
  final String imageJson = "{\"url\":\"4\",\"w\":200,\"h\":320}";
  final String videoJson = "{\"vasttag\":\"xml\"}";
  final String dataJson = "{\"label\":\"xz\",\"value\":\"49\"}";
  final String assetsJson = "{\"id\":35,\"required\":0,\"title\":{\"text\":\"threetwo\"},\"img\":{\"url\":\"4\",\"w\":200,\"h\":320},\"video\":{\"vasttag\":\"xml\"},\"data\":{\"label\":\"xz\",\"value\":\"49\"},\"link\":{\"url\":\"3\",\"clicktrackers\":[\"32\",\"34\"],\"fallback\":\"hah.com\"}}";

  final String nativeJson = "{\"ver\":\"1\",\"assets\":[{\"id\":35,\"required\":0,\"title\":{\"text\":\"threetwo\"},\"img\":{\"url\":\"4\",\"w\":200,\"h\":320},\"video\":{\"vasttag\":\"xml\"},\"data\":{\"label\":\"xz\",\"value\":\"49\"}}],\"link\":{\"url\":\"3\",\"clicktrackers\":[\"32\",\"34\"],\"fallback\":\"hah.com\"},\"imptrackers\":[\"abc\",\"1234\"],\"jstracker\":\"8\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";

  final String creativeJson = "{\"nativeobj\":{\"ver\":\"1\",\"assets\":[{\"id\":35,\"required\":0,\"title\":{\"text\":\"threetwo\"},\"img\":{\"url\":\"4\",\"w\":200,\"h\":320},\"video\":{\"vasttag\":\"xml\"},\"data\":{\"label\":\"xz\",\"value\":\"49\"}}],\"link\":{\"url\":\"3\",\"clicktrackers\":[\"32\",\"34\"],\"fallback\":\"hah.com\"},\"imptrackers\":[\"abc\",\"1234\"],\"jstracker\":\"8\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}}";

  @Test
  public void testSerializationByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    Assert.assertEquals(extJson, objectMapper.writeValueAsString(sampleExt));
    Assert.assertEquals(titleJson, objectMapper.writeValueAsString(sampleTitle));
    Assert.assertEquals(linkJson, objectMapper.writeValueAsString(sampleLink));
    Assert.assertEquals(imageJson, objectMapper.writeValueAsString(sampleImage));
    Assert.assertEquals(videoJson, objectMapper.writeValueAsString(sampleVideo));
    Assert.assertEquals(dataJson, objectMapper.writeValueAsString(sampleData));
    Assert.assertEquals(assetsJson, objectMapper.writeValueAsString(sampleAssets));
    Assert.assertEquals(nativeJson, objectMapper.writeValueAsString(sampleNative));

    Assert.assertEquals(creativeJson, objectMapper.writeValueAsString(sampleCreative));
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
        objectMapper.readValue(titleJson, TitleResponse.class)
    );
    Assert.assertEquals(titleJson, roundTripTitleJson);

    final String roundTripLinkJson = objectMapper.writeValueAsString(
        objectMapper.readValue(linkJson, Link.class)
    );
    Assert.assertEquals(linkJson, roundTripLinkJson);

    final String roundTripImageJson = objectMapper.writeValueAsString(
        objectMapper.readValue(imageJson, ImageResponse.class)
    );
    Assert.assertEquals(imageJson, roundTripImageJson);

    final String roundTripVideoJson = objectMapper.writeValueAsString(
        objectMapper.readValue(videoJson, VideoResponse.class)
    );
    Assert.assertEquals(videoJson, roundTripVideoJson);

    final String roundTripDataJson = objectMapper.writeValueAsString(
        objectMapper.readValue(dataJson, DataResponse.class)
    );
    Assert.assertEquals(dataJson, roundTripDataJson);

    final String roundTripAssetsJson = objectMapper.writeValueAsString(
        objectMapper.readValue(assetsJson, AssetResponse.class)
    );
    Assert.assertEquals(assetsJson, roundTripAssetsJson);

    final String roundTripNativeJson = objectMapper.writeValueAsString(
        objectMapper.readValue(nativeJson, NativeResponse.class)
    );
    Assert.assertEquals(nativeJson, roundTripNativeJson);

    final String roundTripCreativeJson = objectMapper.writeValueAsString(
        objectMapper.readValue(creativeJson, NativeAdCreative.class)
    );
    Assert.assertEquals(creativeJson, roundTripCreativeJson);

  }

}
