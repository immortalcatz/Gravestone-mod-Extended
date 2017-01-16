package nightkosh.gravestone_extended.gui.container;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import nightkosh.gravestone_extended.block.BlockCorpse;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarSlot extends Slot {

    public AltarSlot(IInventory inventory, int slotNum, int xPos, int yPos) {
        super(inventory, slotNum, xPos, yPos);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return (Block.getBlockFromItem(stack.getItem()) instanceof BlockCorpse ||
                stack.getItem() instanceof ItemTool ||
                stack.getItem() instanceof ItemArmor ||
                stack.getItem() instanceof ItemSword);
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public void onSlotChange(ItemStack p_75220_1_, ItemStack p_75220_2_) {
        super.onSlotChange(p_75220_1_, p_75220_2_);
    }
}
