package live.ticticboooom.mods.mmo.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import lombok.SneakyThrows;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class PlayerStatCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> cmd = Commands.literal("mmo_player_stat")
                .then(Commands.literal("overall").executes(x -> {
                    ServerPlayerEntity player = getPlayer(x);
                    player.sendMessage(new StringTextComponent(Double.toString(getPlayerProgress(x).getTotalLevel())), player.getUniqueID());
                    return 0;
                }));
        dispatcher.register(cmd);
    }

    @SneakyThrows
    private static IPlayerLevel getPlayerProgress(CommandContext<CommandSource> ctx) {
        return ctx.getSource().asPlayer().getCapability(Capabilities.PLAYER_LEVEL_CAPABILITY).orElse(null);
    }

    @SneakyThrows
    private static ServerPlayerEntity getPlayer(CommandContext<CommandSource> ctx) {
        return ctx.getSource().asPlayer();
    }
}
