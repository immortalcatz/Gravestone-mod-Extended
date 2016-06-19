package nightkosh.gravestone_extended.core.commands;

import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import nightkosh.gravestone.core.commands.Command;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ExtendedCommands {
    private static ExtendedCommands instance;

    private ExtendedCommands(FMLServerStartingEvent event) {
        instance = this;

        initCommands(event.getServer());
    }

    public static ExtendedCommands getInstance(FMLServerStartingEvent event) {
        if (instance == null) {
            return new ExtendedCommands(event);
        } else {
            return instance;
        }
    }

    private void initCommands(MinecraftServer server) {
        CommandHandler commandManager = (CommandHandler) server.getCommandManager();

        Command.addCommand(new SubCommandStructuresGenerator());
    }
}