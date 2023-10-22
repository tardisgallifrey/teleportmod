package com.tardisgallifrey.teleportmod.enchants;

import com.tardisgallifrey.teleportmod.Init.EnchantmentInit;
import com.tardisgallifrey.teleportmod.Init.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class DistanceEnchantment extends Enchantment {

    static int level = 0;
    static EnchantmentCategory TELEPORT_STAFF_TYPE =
            EnchantmentCategory.create("teleport_staff",
                    item -> item == ItemInit.TELEPORT_STAFF.get());

    public DistanceEnchantment() {
        super(Rarity.COMMON,
                TELEPORT_STAFF_TYPE,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND,
                        EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMaxLevel() {
        return 3;

    }

    public static double enchantValue() {
        double range;

        if(level == 1){
            range = 35.0;
        } else if (level == 2) {
            range = 40.0;
        } else if (level == 3) {
            range = 50.0;
        }else{
            range = 25.0;
        }

        return range;
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class DistanceHandler {
        @SubscribeEvent
        public static void setLevel(TickEvent.PlayerTickEvent event){

            //When setLevel is called, this
            //short circuits the level check if
            //everything isn't right
            if (event.phase == TickEvent.Phase.END || event.player.level.isClientSide()) return;

            //If the above if statement fails,
            //then we can check the enchantment level
            //of the DISTANCE enchantment the player
            //has
            level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit
                                        .DISTANCE.get(), event.player);

        }
    }
}
