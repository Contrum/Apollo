package com.lunarclient.apollo.module.border;

import com.lunarclient.apollo.module.ApolloModule;
import com.lunarclient.apollo.module.ModuleDefinition;
import com.lunarclient.apollo.player.ApolloPlayer;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents the border module.
 *
 * <p>This module represents the border added in
 * version 1.8 (47) and was back-ported to 1.7.</p>
 *
 * @since 1.0.0
 */
@ApiStatus.NonExtendable
@ModuleDefinition(id = "border", name = "Border")
public abstract class BorderModule extends ApolloModule {

    /**
     * Displays the {@link Border} to the {@link ApolloPlayer}.
     *
     * @param viewer the player who is receiving the packet
     * @param border the border
     * @since 1.0.0
     */
    public abstract void displayBorder(ApolloPlayer viewer, Border border);

    /**
     * Removes the {@link Border} from the {@link ApolloPlayer}.
     *
     * @param viewer the player who is receiving the packet
     * @param borderId the border id
     * @since 1.0.0
     */
    public abstract void removeBorder(ApolloPlayer viewer, String borderId);

    /**
     * Removes the {@link Border} from the {@link ApolloPlayer}.
     *
     * @param viewer the player who is receiving the packet
     * @param border the border
     * @since 1.0.0
     */
    public abstract void removeBorder(ApolloPlayer viewer, Border border);

    /**
     * Resets all {@link BorderModule}s for the {@link ApolloPlayer}.
     *
     * @param viewer the player who is receiving the packet
     * @since 1.0.0
     */
    public abstract void resetBorders(ApolloPlayer viewer);

}
