package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.MobSpawnHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Corridor extends CatacombsBaseComponent {

    public static final int X_LENGTH = 5;
    public static final int HEIGHT = 5;
    public static final int Z_LENGTH = 5;

    public Corridor(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        Passage entrance = new Passage(this, 0, 0, 0);
        this.setEntrance(entrance);

        this.addExit(new Passage(this, 0, 0, Z_LENGTH - 1, ComponentSide.FRONT));
        switch (facing) {
            case SOUTH:
                this.addExit(new Passage(this, X_LENGTH - 1, 0, 0, ComponentSide.LEFT));
                this.addExit(new Passage(this, 0, 0, 0, ComponentSide.RIGHT));
                break;
            case NORTH:
                this.addExit(new Passage(this, 0, 0, 4, ComponentSide.LEFT));
                this.addExit(new Passage(this, X_LENGTH - 1, 0, 4, ComponentSide.RIGHT));
                break;
            case WEST:
                this.addExit(new Passage(this, X_LENGTH - 1, 0, 4, ComponentSide.LEFT));
                this.addExit(new Passage(this, 0, 0, 4, ComponentSide.RIGHT));
                break;
            case EAST:
                this.addExit(new Passage(this, 0, 0, 0, ComponentSide.LEFT));
                this.addExit(new Passage(this, X_LENGTH - 1, 0, 0, ComponentSide.RIGHT));
                break;
        }

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y, z, X_LENGTH, HEIGHT, Z_LENGTH, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();

        this.fillWithAir(world, boundingBox, 1, 1, 0, 3, 3, 3);

        // block floor
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 1, 4, 0, 3, false, random, stoneBricks);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 1, 1, 0, 3, 3, 3, StateHelper.WEB, false);
        //piles of bones
        if (ExtendedConfig.generatePilesOfBones) {
            this.fillWithRandomizedPilesOfBones(world, boundingBox, 1, 1, 1, 4, 1, 4, false, random);
        }

        // trap floor
        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 4, 0, 0, StateHelper.NIGHTSTONE);

        // neter ceiling
        this.fillWithBlocks(world, boundingBox, 0, 4, 0, 4, 4, 3, StateHelper.NETHER_BRICK);

        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 1, 1, 0, 3, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 4, 1, 1, 4, 3, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 4, 4, 4, 4, false, random, stoneBricks);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 0, 1, 0, 0, 3, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 4, 1, 0, 4, 3, 0, StateHelper.NETHER_BRICK);

        // spawn bats
        MobSpawnHelper.spawnBats(world, random, boundingBox);

        return true;
    }
}
