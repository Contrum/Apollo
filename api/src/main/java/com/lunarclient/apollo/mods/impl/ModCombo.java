/*
 * This file is part of Apollo, licensed under the MIT License.
 *
 * Copyright (c) 2023 Moonsworth
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.lunarclient.apollo.mods.impl;

import com.lunarclient.apollo.option.NumberOption;
import com.lunarclient.apollo.option.SimpleOption;
import io.leangen.geantyref.TypeToken;
import java.awt.Color;

/**
 * Displays how often you have hit another player within a certain amount of time on the HUD.
 *
 * @since 1.0.0
 */
public final class ModCombo {

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Boolean> ENABLED = SimpleOption.<Boolean>builder()
        .node("combo", "enabled").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final NumberOption<Float> SCALE = NumberOption.<Float>number()
        .node("combo", "scale").type(TypeToken.get(Float.class))
        .min(0.5F).max(1.5F)
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Boolean> TEXT_SHADOW = SimpleOption.<Boolean>builder()
        .node("combo", "text-shadow").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Boolean> BRACKETS = SimpleOption.<Boolean>builder()
        .node("combo", "brackets").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.1.6
     */
    public static final SimpleOption<Color> BRACKET_COLOR = SimpleOption.<Color>builder()
        .node("combo", "bracket-color").type(TypeToken.get(Color.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Boolean> BACKGROUND = SimpleOption.<Boolean>builder()
        .node("combo", "background").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * If this is disabled the background will change size with the text.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Boolean> STATIC_BACKGROUND_WIDTH = SimpleOption.<Boolean>builder()
        .comment("If this is disabled the background will change size with the text.")
        .node("combo", "static-background-width").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * If this is disabled the background will change size with the text.
     *
     * @since 1.1.6
     */
    public static final SimpleOption<Boolean> STATIC_BACKGROUND_HEIGHT = SimpleOption.<Boolean>builder()
        .comment("If this is disabled the background will change size with the text.")
        .node("combo", "static-background-height").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final NumberOption<Integer> BACKGROUND_WIDTH = NumberOption.<Integer>number()
        .node("combo", "background-width").type(TypeToken.get(Integer.class))
        .min(46).max(62)
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final NumberOption<Integer> BACKGROUND_HEIGHT = NumberOption.<Integer>number()
        .node("combo", "background-height").type(TypeToken.get(Integer.class))
        .min(10).max(22)
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Boolean> BORDER = SimpleOption.<Boolean>builder()
        .node("combo", "border").type(TypeToken.get(Boolean.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final NumberOption<Float> BORDER_THICKNESS = NumberOption.<Float>number()
        .node("combo", "border-thickness").type(TypeToken.get(Float.class))
        .min(0.5F).max(3.0F)
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Color> BORDER_COLOR = SimpleOption.<Color>builder()
        .node("combo", "border-color").type(TypeToken.get(Color.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Color> BACKGROUND_COLOR = SimpleOption.<Color>builder()
        .node("combo", "background-color").type(TypeToken.get(Color.class))
        .notifyClient()
        .build();

    /**
     * No documentation available.
     *
     * @since 1.0.0
     */
    public static final SimpleOption<Color> TEXT_COLOR = SimpleOption.<Color>builder()
        .node("combo", "text-color").type(TypeToken.get(Color.class))
        .notifyClient()
        .build();

    private ModCombo() {
    }

}
