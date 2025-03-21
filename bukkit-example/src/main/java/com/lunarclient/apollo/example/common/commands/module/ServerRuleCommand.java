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
package com.lunarclient.apollo.example.common.commands.module;

import com.lunarclient.apollo.example.ApolloExamplePlugin;
import com.lunarclient.apollo.example.common.modules.impl.ServerRuleExample;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ServerRuleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player only!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 2) {
            player.sendMessage("Usage: /serverrule <antiportaltraps|overridenametagrenderdistance|nametagrenderdistance> <value>");
            return true;
        }

        ServerRuleExample serverRuleExample = ApolloExamplePlugin.getPlugin().getServerRuleExample();

        switch (args[0].toLowerCase()) {
            case "antiportaltraps": {
                boolean value = Boolean.parseBoolean(args[1]);
                serverRuleExample.setAntiPortalTraps(value);

                player.sendMessage("Anti portal traps rule has been set to " + value);
                break;
            }

            case "overridenametagrenderdistance": {
                boolean value = Boolean.parseBoolean(args[1]);
                serverRuleExample.setOverrideNametagRenderDistance(player, value);

                player.sendMessage("Override nametag render distance rule has been set to " + value);
                break;
            }

            case "nametagrenderdistance": {
                int value;

                try {
                    value = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage("Input must be a number for this rule.");
                    return true;
                }

                serverRuleExample.setNametagRenderDistanceExample(value);
                player.sendMessage("Nametag render distance has been set to " + value);
                break;
            }

            default: {
                player.sendMessage("Usage: /serverrule <antiportaltraps|overridenametagrenderdistance|nametagrenderdistance> <value>");
                break;
            }
        }

        return true;
    }
}
