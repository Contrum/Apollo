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
package com.lunarclient.apollo.example.proto.examples;

import com.lunarclient.apollo.common.v1.EntityId;
import com.lunarclient.apollo.entity.v1.FlipEntityMessage;
import com.lunarclient.apollo.entity.v1.OverrideRainbowSheepMessage;
import com.lunarclient.apollo.entity.v1.ResetFlipedEntityMessage;
import com.lunarclient.apollo.entity.v1.ResetRainbowSheepMessage;
import com.lunarclient.apollo.example.common.modules.impl.EntityExample;
import com.lunarclient.apollo.example.proto.ProtobufPacketUtil;
import com.lunarclient.apollo.example.proto.ProtobufUtil;
import java.util.Set;
import java.util.stream.Collectors;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;

public class EntityProtoExample extends EntityExample {

    @Override
    public void overrideRainbowSheepExample(Player viewer) {
        Set<EntityId> sheepUuidsProto = viewer.getWorld().getEntitiesByClass(Sheep.class).stream()
            .map(sheep -> ProtobufUtil.createEntityIdProto(sheep.getEntityId(), sheep.getUniqueId()))
            .collect(Collectors.toSet());

        OverrideRainbowSheepMessage message = OverrideRainbowSheepMessage.newBuilder()
            .addAllEntityIds(sheepUuidsProto)
            .build();

        ProtobufPacketUtil.sendPacket(viewer, message);
    }

    @Override
    public void resetRainbowSheepExample(Player viewer) {
        Set<EntityId> sheepUuidsProto = viewer.getWorld().getEntitiesByClass(Sheep.class).stream()
            .map(sheep -> ProtobufUtil.createEntityIdProto(sheep.getEntityId(), sheep.getUniqueId()))
            .collect(Collectors.toSet());

        ResetRainbowSheepMessage message = ResetRainbowSheepMessage.newBuilder()
            .addAllEntityIds(sheepUuidsProto)
            .build();

        ProtobufPacketUtil.sendPacket(viewer, message);
    }

    @Override
    public void flipEntityExample(Player viewer) {
        Set<EntityId> entityUuidsProto = viewer.getWorld()
            .getNearbyEntities(viewer.getLocation(), 10, 10, 10)
            .stream().filter(entity -> entity instanceof Cow)
            .map(sheep -> ProtobufUtil.createEntityIdProto(sheep.getEntityId(), sheep.getUniqueId()))
            .collect(Collectors.toSet());

        FlipEntityMessage message = FlipEntityMessage.newBuilder()
            .addAllEntityIds(entityUuidsProto)
            .build();

        ProtobufPacketUtil.sendPacket(viewer, message);
    }

    @Override
    public void resetFlippedEntityExample(Player viewer) {
        Set<EntityId> entityUuidsProto = viewer.getWorld()
            .getNearbyEntities(viewer.getLocation(), 10, 10, 10)
            .stream().filter(entity -> entity instanceof Cow)
            .map(sheep -> ProtobufUtil.createEntityIdProto(sheep.getEntityId(), sheep.getUniqueId()))
            .collect(Collectors.toSet());

        ResetFlipedEntityMessage message = ResetFlipedEntityMessage.newBuilder()
            .addAllEntityIds(entityUuidsProto)
            .build();

        ProtobufPacketUtil.sendPacket(viewer, message);
    }

}
