package jp.wasabeef.example.fresco;

/**
 * Copyright (C) 2015 Wasabeef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import net.grobas.view.PolygonImageView;

import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.example.fresco.MainAdapter.Type;
import jp.wasabeef.fresco.processors.BlurPostprocessor;
import jp.wasabeef.fresco.processors.ColorFilterPostprocessor;
import jp.wasabeef.fresco.processors.GrayscalePostprocessor;
import jp.wasabeef.fresco.processors.MaskPostprocessor;
import jp.wasabeef.fresco.processors.gpu.BrightnessFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.ContrastFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.InvertFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.KuawaharaFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.PixelationFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.SepiaFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.SketchFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.SwirlFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.ToonFilterPostprocessor;
import jp.wasabeef.fresco.processors.gpu.VignetteFilterPostprocessor;

public class MainActivity extends AppCompatActivity {



  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      Fresco.initialize(this);
      setContentView(R.layout.test_layout);
      PolygonImageView simpleDraweeView = (PolygonImageView) findViewById(R.id.test_image);
      simpleDraweeView.setImageResource(R.drawable.default_user_image);

//      simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
//
//      ImageRequest request = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.demo)
//              .build();
//
//      PipelineDraweeController controller =
//              (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
//                      .setImageRequest(request)
//                      .setOldController(simpleDraweeView.getController())
//                      .build();
//      simpleDraweeView.setController(controller);


//    setContentView(R.layout.activity_main);
//
//    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
//    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
//    List<Type> dataSet = new ArrayList<>();
//    dataSet.add(Type.Blur);
//    dataSet.add(Type.Grayscale);
//    dataSet.add(Type.ColorFilter);
//    dataSet.add(Type.Mask);
//    dataSet.add(Type.NinePatchMask);
//    dataSet.add(Type.Pixel);
//    dataSet.add(Type.Vignette);
//    dataSet.add(Type.Kuawahara);
//    dataSet.add(Type.Brightness);
//    dataSet.add(Type.Swirl);
//    dataSet.add(Type.Sketch);
//    dataSet.add(Type.Invert);
//    dataSet.add(Type.Contrast);
//    dataSet.add(Type.Sepia);
//    dataSet.add(Type.Toon);
//
//    recyclerView.setAdapter(new MainAdapter(this, dataSet));
  }
}
