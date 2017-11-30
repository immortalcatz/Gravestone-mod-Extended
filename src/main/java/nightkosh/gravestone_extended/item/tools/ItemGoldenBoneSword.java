package nightkosh.gravestone_extended.item.tools;

import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemGoldenBoneSword extends ItemBoneSword {

    public ItemGoldenBoneSword() {
        super(ToolMaterial.GOLD);
        this.setUnlocalizedName("gravestone.bone_sword_golden");
        this.setRegistryName(ModInfo.ID, "gs_bone_sword_golden");
    }
}
