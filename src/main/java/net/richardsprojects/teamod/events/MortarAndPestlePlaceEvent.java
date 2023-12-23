package net.richardsprojects.teamod.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.common.blocks.entities.BlockEntityMortarAndPestle;

@Mod.EventBusSubscriber(modid = CoffeeAndTeaMod.MODID)
public class MortarAndPestlePlaceEvent {

    @SubscribeEvent
    public void onBlockPlaceEvent(BlockEvent.EntityPlaceEvent event) {
        // make sure the entity is a player, and they are placing a mortar and pestle
        if (!(event.getEntity() instanceof Player player)) return;
        if (!event.getPlacedBlock().getBlock().equals(CoffeeAndTeaMod.MORTAR_AND_PESTLE.get())) return;
        BlockEntity be = event.getLevel().getBlockEntity(event.getPos());
        if (!(be instanceof BlockEntityMortarAndPestle mortar)) return;

        int damage = player.getInventory().getSelected().getDamageValue();
        mortar.setDurability(64 - damage);
    }

}
