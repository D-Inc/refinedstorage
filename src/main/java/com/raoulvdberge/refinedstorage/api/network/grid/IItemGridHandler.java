package com.raoulvdberge.refinedstorage.api.network.grid;

import com.raoulvdberge.refinedstorage.api.IRSAPI;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Defines the behavior of item grids.
 */
public interface IItemGridHandler {
    int EXTRACT_HALF = 1;
    int EXTRACT_SINGLE = 2;
    int EXTRACT_SHIFT = 4;

    /**
     * Called when a player tries to extract an item from the grid.
     *
     * @param player the player that is attempting the extraction
     * @param hash   the hash of the item we're trying to extract, see {@link IRSAPI#getItemStackHashCode(ItemStack)}
     * @param flags  how we are extracting
     */
    void onExtract(EntityPlayerMP player, int hash, int flags);

    /**
     * Called when a player tries to insert an item in the grid.
     *
     * @param player the player that is attempting the insert
     * @param stack  the item we're trying to insert
     * @return the remainder, or null if there is no remainder
     */
    @Nullable
    ItemStack onInsert(EntityPlayerMP player, ItemStack stack);

    /**
     * Called when a player is trying to insert an item that it is holding in their hand in the GUI.
     *
     * @param player the player that is attempting the insert
     * @param single true if we are only inserting a single item, false otherwise
     */
    void onInsertHeldItem(EntityPlayerMP player, boolean single);

    /**
     * Called when a player requests the crafting preview window to be opened.
     *
     * @param hash      the item stack hash
     * @param quantity  the amount of that item that we need a preview for
     * @param noPreview whether the preview should show
     */
    void onCraftingPreviewRequested(EntityPlayerMP player, int hash, int quantity, boolean noPreview);

    /**
     * Called when a player requested crafting for an item.
     *
     * @param player   the player that is requesting the crafting
     * @param stack    the {@link ItemStack} to request a craft for
     * @param quantity the amount of that item that has to be crafted
     */
    void onCraftingRequested(EntityPlayerMP player, ItemStack stack, int quantity);

    /**
     * Called when a player wants to cancel a crafting task.
     *
     * @param player the player that requested the cance
     * @param id     the task id, or -1 to cancel all tasks
     */
    void onCraftingCancelRequested(EntityPlayerMP player, int id);
}
