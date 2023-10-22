package com.tardisgallifrey.teleportmod.Init;

import com.tardisgallifrey.teleportmod.TeleportModMain;
import com.tardisgallifrey.teleportmod.enchants.DistanceEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
                    TeleportModMain.MOD_ID);

    public static final RegistryObject<Enchantment> DISTANCE =
            ENCHANTMENTS.register("distance",
                    DistanceEnchantment::new);
}
