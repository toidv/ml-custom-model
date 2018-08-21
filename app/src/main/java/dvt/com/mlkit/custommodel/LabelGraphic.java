// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package dvt.com.mlkit.custommodel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import dvt.com.mlkit.GraphicOverlay;

/**
 * Graphic instance for rendering image labels.
 */
public class LabelGraphic extends GraphicOverlay.Graphic {

    private final Paint textPaint;
    private final GraphicOverlay overlay;

    private List<String> labels;

    LabelGraphic(GraphicOverlay overlay) {
        super(overlay);
        this.overlay = overlay;
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(60.0f);
    }

    synchronized void updateLabel(List<String> labels) {
        this.labels = labels;
        postInvalidate();
    }

    @Override
    public synchronized void draw(Canvas canvas) {
        float x = overlay.getWidth() / 4.0f;
        float y = overlay.getHeight() / 4.0f;

        for (String label : labels) {
            canvas.drawText(label, x, y, textPaint);
            y = y - 62.0f;
        }
    }
}
