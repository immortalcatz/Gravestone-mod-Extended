package nightkosh.gravestone_extended.gui.container;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.block.BlockCorpse;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ExecutionSlot extends Slot {

    public ExecutionSlot(IInventory inventory, int slotNum, int xPos, int yPos) {
        super(inventory, slotNum, xPos, yPos);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return (Block.getBlockFromItem(stack.getItem()) instanceof BlockCorpse);
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}
