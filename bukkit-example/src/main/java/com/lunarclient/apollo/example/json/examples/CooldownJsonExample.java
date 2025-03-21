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
package com.lunarclient.apollo.example.json.examples;

import com.google.gson.JsonObject;
import com.lunarclient.apollo.example.common.modules.impl.CooldownExample;
import com.lunarclient.apollo.example.json.JsonPacketUtil;
import com.lunarclient.apollo.example.json.JsonUtil;
import java.time.Duration;
import org.bukkit.entity.Player;

public class CooldownJsonExample extends CooldownExample {

    @Override
    public void displayCooldownItemExample(Player viewer) {
        JsonObject message = new JsonObject();
        message.addProperty("@type", "type.googleapis.com/lunarclient.apollo.cooldown.v1.DisplayCooldownMessage");
        message.addProperty("name", "enderpearl-cooldown");
        message.addProperty("duration", JsonUtil.createDurationObject(Duration.ofSeconds(15)));
        message.add("icon", JsonUtil.createItemStackIconObject("ENDER_PEARL", 0, 0));

        JsonPacketUtil.sendPacket(viewer, message);
    }

    @Override
    public void displayCooldownResourceExample(Player viewer) {
        JsonObject message = new JsonObject();
        message.addProperty("@type", "type.googleapis.com/lunarclient.apollo.cooldown.v1.DisplayCooldownMessage");
        message.addProperty("name", "lunar-cooldown");
        message.addProperty("duration", JsonUtil.createDurationObject(Duration.ofSeconds(15)));
        message.add("icon", JsonUtil.createSimpleResourceLocationIconObject("lunar:logo/logo-200x182.svg", 12));

        JsonPacketUtil.sendPacket(viewer, message);
    }

    @Override
    public void removeCooldownExample(Player viewer) {
        JsonObject message = new JsonObject();
        message.addProperty("@type", "type.googleapis.com/lunarclient.apollo.cooldown.v1.RemoveCooldownMessage");
        message.addProperty("name", "enderpearl-cooldown");

        JsonPacketUtil.sendPacket(viewer, message);
    }

    @Override
    public void resetCooldownsExample(Player viewer) {
        JsonObject message = new JsonObject();
        message.addProperty("@type", "type.googleapis.com/lunarclient.apollo.cooldown.v1.ResetCooldownsMessage");

        JsonPacketUtil.sendPacket(viewer, message);
    }

}
